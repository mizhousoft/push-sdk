package com.mizhousoft.push.oppo.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.commons.restclient.service.RestClientService;
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

	// REST服务
	private RestClientService restClientService;

	// OppoAuthService
	private OppoAuthService oppoAuthService;

	/**
	 * 构造函数
	 *
	 * @param profile
	 * @param restClientService
	 */
	public OppoPushServiceImpl(OppoProfile profile, RestClientService restClientService)
	{
		super();
		this.profile = profile;
		this.restClientService = restClientService;

		this.oppoAuthService = new OppoAuthServiceImpl(profile, restClientService);
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

			HttpHeaders headers = new HttpHeaders();
			MediaType type = MediaType.parseMediaType("application/x-www-form-urlencoded");
			headers.setContentType(type);

			MultiValueMap<String, Object> formData = new LinkedMultiValueMap<>(20);
			formData.add(OppoConstants.PARAM_MESSAGE, message);
			formData.add(OppoConstants.PARAM_TOKEN, accessToken.getAuthToken());

			HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(formData, headers);

			String responseBody = restClientService.postForObject(UNICAST_PUSH_URL, httpEntity, String.class);

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

			HttpHeaders headers = new HttpHeaders();
			MediaType type = MediaType.parseMediaType("application/x-www-form-urlencoded");
			headers.setContentType(type);

			MultiValueMap<String, Object> formData = new LinkedMultiValueMap<>(20);
			formData.add(OppoConstants.PARAM_TOKEN, accessToken.getAuthToken());

			Iterator<Entry<String, Object>> iter = notificationParams.entrySet().iterator();
			while (iter.hasNext())
			{
				Entry<String, Object> entry = iter.next();
				formData.add(entry.getKey(), entry.getValue());
			}

			HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(formData, headers);

			String responseBody = restClientService.postForObject(BROADCAST_TASK_URL, httpEntity, String.class);

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

			formData = new LinkedMultiValueMap<>(20);
			formData.add(OppoConstants.PARAM_TOKEN, accessToken.getAuthToken());
			formData.add(OppoConstants.PARAM_TARGET_TYPE, OppoConstants.TARGET_TYPE_REGISTRATION_ID);
			formData.add(OppoConstants.PARAM_TARGET_VALUE, targetValue);
			formData.add(OppoConstants.PARAM_MESSAGE_ID, taskResponse.getData().getMessageId());

			httpEntity = new HttpEntity<>(formData, headers);

			responseBody = restClientService.postForObject(BROADCAST_PUSH_URL, httpEntity, String.class);

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
