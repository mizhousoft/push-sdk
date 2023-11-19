package com.mizhousoft.push.oppo.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.push.action.ClickAction;
import com.mizhousoft.push.action.IntentClickAction;
import com.mizhousoft.push.exception.PushException;
import com.mizhousoft.push.oppo.OppoAccessToken;
import com.mizhousoft.push.oppo.OppoAuthService;
import com.mizhousoft.push.oppo.OppoGenericResponse;
import com.mizhousoft.push.oppo.OppoPushService;
import com.mizhousoft.push.oppo.config.OppoProfile;
import com.mizhousoft.push.oppo.constant.OppoConstants;
import com.mizhousoft.push.oppo.internal.BroadcastPushResponse;
import com.mizhousoft.push.oppo.internal.BroadcastTaskResponse;
import com.mizhousoft.push.oppo.internal.OppoNotification;
import com.mizhousoft.push.oppo.internal.UnicastPushResponse;
import com.mizhousoft.push.oppo.util.OppoMessageUtils;
import com.mizhousoft.push.request.NotificationRequest;
import com.mizhousoft.push.result.PushResult;
import com.mizhousoft.push.util.IntentUtils;
import com.mizhousoft.push.validator.RequestValidator;

import kong.unirest.core.Unirest;
import kong.unirest.core.UnirestException;

/**
 * 推送服务
 *
 * @version
 */
public class OppoPushServiceImpl implements OppoPushService
{
	private static final Logger LOG = LoggerFactory.getLogger(OppoPushServiceImpl.class);

	// 凭证
	private OppoProfile profile;

	// OppoAuthService
	private OppoAuthService oppoAuthService;

	/**
	 * 构造函数
	 *
	 * @param profile
	 */
	public OppoPushServiceImpl(OppoProfile profile)
	{
		super();
		this.profile = profile;

		this.oppoAuthService = new OppoAuthServiceImpl(profile);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isSupportMultiSend()
	{
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PushResult pushNotification(NotificationRequest request) throws PushException
	{
		RequestValidator.validate(request);

		if (request.getTokens().size() > 1000)
		{
			throw new PushException("Token too many, can not exceed 1000.");
		}

		if (1 == request.getTokens().size())
		{
			return pushUnicastRequest(request);
		}
		else
		{
			return pushBroadcastRequest(request);
		}
	}

	private PushResult pushUnicastRequest(NotificationRequest request) throws PushException
	{
		OppoNotification notification = buildNotification(request);

		Map<String, Object> notificationParams = OppoMessageUtils.buildNotificationParams(notification);

		String regId = request.getTokens().iterator().next();

		try
		{
			Map<String, Object> messageParams = new HashMap<>(4);
			messageParams.put(OppoConstants.PARAM_TARGET_TYPE, OppoConstants.TARGET_TYPE_REGISTRATION_ID);
			messageParams.put(OppoConstants.PARAM_TARGET_VALUE, regId);
			messageParams.put(OppoConstants.PARAM_NOTIFICATION, notificationParams);

			String message = JSONUtils.toJSONString(messageParams);

			OppoAccessToken accessToken = oppoAuthService.getAccessToken();

			Map<String, Object> formData = new HashMap<>(2);
			formData.put(OppoConstants.PARAM_MESSAGE, message);
			formData.put(OppoConstants.PARAM_TOKEN, accessToken.getAuthToken());

			String responseBody = Unirest.post(UNICAST_PUSH_URL).fields(formData).asString().getBody();

			LOG.info("Push response is {}.", responseBody);

			OppoGenericResponse<UnicastPushResponse> response = JSONUtils.parse(responseBody,
			        new TypeReference<OppoGenericResponse<UnicastPushResponse>>()
			        {
			        });

			if (OppoConstants.INVALID_REGISTRATION_ID == response.getCode())
			{
				return new PushResult(null, request.getTokens());
			}
			else if (0 != response.getCode())
			{
				throw new PushException("Push data failed, response is " + response.toString());
			}

			String requestId = response.getData().getMessageId();
			return new PushResult(requestId);
		}
		catch (UnirestException e)
		{
			throw new PushException("Request failed.", e);
		}
		catch (JSONException e)
		{
			throw new PushException("Serialize object is null.", e);
		}
	}

	private PushResult pushBroadcastRequest(NotificationRequest request) throws PushException
	{
		OppoNotification notification = buildNotification(request);

		Map<String, Object> notificationParams = OppoMessageUtils.buildNotificationParams(notification);

		try
		{
			OppoAccessToken accessToken = oppoAuthService.getAccessToken();

			Map<String, Object> formData = new HashMap<>(20);
			formData.put(OppoConstants.PARAM_TOKEN, accessToken.getAuthToken());

			Iterator<Entry<String, Object>> iter = notificationParams.entrySet().iterator();
			while (iter.hasNext())
			{
				Entry<String, Object> entry = iter.next();
				formData.put(entry.getKey(), entry.getValue());
			}

			String responseBody = Unirest.post(BROADCAST_TASK_URL).fields(formData).asString().getBody();

			LOG.info("Push response is {}.", responseBody);

			OppoGenericResponse<BroadcastTaskResponse> taskResponse = JSONUtils.parse(responseBody,
			        new TypeReference<OppoGenericResponse<BroadcastTaskResponse>>()
			        {
			        });
			if (0 != taskResponse.getCode())
			{
				throw new PushException("Push data failed, response is " + taskResponse.toString());
			}

			String targetValue = StringUtils.join(request.getTokens(), ";");

			formData = new HashMap<>(20);
			formData.put(OppoConstants.PARAM_TOKEN, accessToken.getAuthToken());
			formData.put(OppoConstants.PARAM_TARGET_TYPE, OppoConstants.TARGET_TYPE_REGISTRATION_ID);
			formData.put(OppoConstants.PARAM_TARGET_VALUE, targetValue);
			formData.put(OppoConstants.PARAM_MESSAGE_ID, taskResponse.getData().getMessageId());

			responseBody = Unirest.post(BROADCAST_PUSH_URL).fields(formData).asString().getBody();

			OppoGenericResponse<BroadcastPushResponse> pushResponse = JSONUtils.parse(responseBody,
			        new TypeReference<OppoGenericResponse<BroadcastPushResponse>>()
			        {
			        });
			if (0 != pushResponse.getCode())
			{
				throw new PushException("Push data failed, response is " + pushResponse.toString());
			}

			LOG.info("Push response is {}.", pushResponse.toString());

			BroadcastPushResponse dataResponse = pushResponse.getData();
			Set<String> illegalTokens = dataResponse.getInvalidTokens();

			return new PushResult(dataResponse.getMessageId(), illegalTokens);
		}
		catch (UnirestException e)
		{
			throw new PushException("Request failed.", e);
		}
		catch (JSONException e)
		{
			throw new PushException("Serialize object is null.", e);
		}
	}

	private OppoNotification buildNotification(NotificationRequest request)
	{
		OppoNotification notification = new OppoNotification();
		notification.setStyle(OppoConstants.NOTIFICATION_STYLE_STANDARD);
		notification.setTitle(request.getTitle());
		notification.setContent(request.getBody());

		ClickAction action = request.getClickAction();
		if (action instanceof IntentClickAction)
		{
			notification.setClickActionType(OppoConstants.CLICK_ACTION_OPEN_INTENT_SCHEME);

			String intent = IntentUtils.formatOppoIntent(profile.getIntentFormat(), action.getExtProperties());
			notification.setClickActionUrl(intent);
		}

		notification.setChannelId(request.getChannelId());

		return notification;
	}
}
