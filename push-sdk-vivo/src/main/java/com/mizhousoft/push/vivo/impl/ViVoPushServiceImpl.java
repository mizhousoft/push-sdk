package com.mizhousoft.push.vivo.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mizhousoft.commons.crypto.generator.RandomGenerator;
import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.push.NotificationType;
import com.mizhousoft.push.action.ClickAction;
import com.mizhousoft.push.action.IntentClickAction;
import com.mizhousoft.push.exception.PushException;
import com.mizhousoft.push.request.NotificationRequest;
import com.mizhousoft.push.result.PushResult;
import com.mizhousoft.push.util.IntentUtils;
import com.mizhousoft.push.validator.RequestValidator;
import com.mizhousoft.push.vivo.ViVoAuthService;
import com.mizhousoft.push.vivo.ViVoMessageCateConverter;
import com.mizhousoft.push.vivo.ViVoPushService;
import com.mizhousoft.push.vivo.config.ViVoProfile;
import com.mizhousoft.push.vivo.constant.ViVoConstants;
import com.mizhousoft.push.vivo.internal.request.ViVoBroadcastPushRequest;
import com.mizhousoft.push.vivo.internal.request.ViVoBroadcastTaskRequest;
import com.mizhousoft.push.vivo.internal.request.ViVoUnicastPushRequest;
import com.mizhousoft.push.vivo.internal.response.ViVoBroadcastPushResponse;
import com.mizhousoft.push.vivo.internal.response.ViVoBroadcastTaskResponse;
import com.mizhousoft.push.vivo.internal.response.ViVoUnicastPushResponse;

import kong.unirest.core.Unirest;
import kong.unirest.core.UnirestException;

/**
 * 推送服务
 *
 * @version
 */
public class ViVoPushServiceImpl implements ViVoPushService
{
	private static final Logger LOG = LoggerFactory.getLogger(ViVoPushServiceImpl.class);

	// 凭证
	private ViVoProfile profile;

	// ViVoAuthService
	private ViVoAuthService vivoAuthService;

	/**
	 * 构造函数
	 *
	 * @param profile
	 */
	public ViVoPushServiceImpl(ViVoProfile profile)
	{
		super();
		this.profile = profile;

		ViVoAuthServiceImpl vivoAuthService = new ViVoAuthServiceImpl();
		vivoAuthService.setProfile(this.profile);
		this.vivoAuthService = vivoAuthService;
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

		if (request.getTitle().length() > 20)
		{
			throw new PushException("The title is too long and cannot exceed 20 characters.");
		}
		else if (request.getTokens().size() > 1000)
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
		String regId = request.getTokens().iterator().next();

		ViVoUnicastPushRequest unicastPush = new ViVoUnicastPushRequest();
		unicastPush.setTitle(request.getTitle());
		unicastPush.setContent(request.getBody());
		unicastPush.setNetworkType(ViVoConstants.NETWORK_TYPE_UNLIMITED);
		unicastPush.setNotifyType(ViVoConstants.NOTIFYTYPE_RING_VIBRATION);
		unicastPush.setPushMode(profile.isSandbox() ? ViVoConstants.PUSH_MODE_TEST_PUSH : ViVoConstants.PUSH_MODE_OFFICIAL_PUSH);
		unicastPush.setRegId(regId);
		unicastPush.setRequestId(RandomGenerator.genHexString(16, true));

		ClickAction action = request.getClickAction();
		if (action instanceof IntentClickAction)
		{
			unicastPush.setSkipType(ViVoConstants.SKIPTYPE_APP_SPEC_PAGE);

			String intent = IntentUtils.formatIntent(profile.getIntentFormat(), action.getExtProperties());
			unicastPush.setSkipContent(intent);
		}

		String category = ViVoMessageCateConverter.convert(request.getCategory());
		unicastPush.setCategory(category);

		try
		{
			String accessToken = vivoAuthService.getAccessToken();

			String body = JSONUtils.toJSONString(unicastPush);

			String responseBody = Unirest.post(UNICAST_PUSH_URL).header("authToken", accessToken)
			        .header("Content-Type", "application/json; charset=UTF-8").body(body).asString().getBody();

			LOG.info("Push response is {}.", responseBody);

			ViVoUnicastPushResponse response = JSONUtils.parse(responseBody, ViVoUnicastPushResponse.class);
			if (ViVoConstants.INVALID_REGISTRATION_ID == response.getResult())
			{
				return new PushResult(response.getTaskId(), request.getTokens());
			}
			else if (0 != response.getResult())
			{
				throw new PushException("Push data failed, response is " + response.toString());
			}

			return new PushResult(response.getTaskId());
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
		ViVoBroadcastTaskRequest taskRequest = new ViVoBroadcastTaskRequest();
		taskRequest.setTitle(request.getTitle());
		taskRequest.setContent(request.getBody());
		taskRequest.setNetworkType(ViVoConstants.NETWORK_TYPE_UNLIMITED);
		taskRequest.setNotifyType(ViVoConstants.NOTIFYTYPE_RING_VIBRATION);
		taskRequest.setRequestId(RandomGenerator.genHexString(16, true));
		taskRequest.setPushMode(profile.isSandbox() ? ViVoConstants.PUSH_MODE_TEST_PUSH : ViVoConstants.PUSH_MODE_OFFICIAL_PUSH);

		ClickAction action = request.getClickAction();
		if (action instanceof IntentClickAction)
		{
			taskRequest.setSkipType(ViVoConstants.SKIPTYPE_APP_SPEC_PAGE);

			String intent = IntentUtils.formatIntent(profile.getIntentFormat(), action.getExtProperties());
			taskRequest.setSkipContent(intent);
		}

		int classification = NotificationType.SYSTEM.equals(request.getNotificationType()) ? ViVoConstants.CLASSIFICATION_SYSTEM
		        : ViVoConstants.CLASSIFICATION_OPERATION;
		taskRequest.setClassification(classification);

		String category = ViVoMessageCateConverter.convert(request.getCategory());
		taskRequest.setCategory(category);

		try
		{
			String accessToken = vivoAuthService.getAccessToken();

			String body = JSONUtils.toJSONString(taskRequest);

			String responseBody = Unirest.post(BROADCAST_TASK_URL).header("authToken", accessToken)
			        .header("Content-Type", "application/json; charset=UTF-8").body(body).asString().getBody();

			LOG.info("Push response is {}.", responseBody);

			ViVoBroadcastTaskResponse taskResponse = JSONUtils.parse(responseBody, ViVoBroadcastTaskResponse.class);
			if (0 != taskResponse.getResult())
			{
				throw new PushException("Push data failed, response is " + taskResponse.toString());
			}

			ViVoBroadcastPushRequest pushRequest = new ViVoBroadcastPushRequest();
			pushRequest.setPushMode(profile.isSandbox() ? ViVoConstants.PUSH_MODE_TEST_PUSH : ViVoConstants.PUSH_MODE_OFFICIAL_PUSH);
			pushRequest.setRegIds(request.getTokens());
			pushRequest.setRequestId(RandomGenerator.genHexString(16, true));
			pushRequest.setTaskId(taskResponse.getTaskId());

			body = JSONUtils.toJSONString(pushRequest);

			responseBody = Unirest.post(BROADCAST_PUSH_URL).header("authToken", accessToken)
			        .header("Content-Type", "application/json; charset=UTF-8").body(body).asString().getBody();

			LOG.info("Push response is {}.", responseBody);

			ViVoBroadcastPushResponse pushResponse = JSONUtils.parse(responseBody, ViVoBroadcastPushResponse.class);
			if (ViVoConstants.INVALID_REGISTRATION_ID == pushResponse.getResult())
			{
				return new PushResult(taskResponse.getTaskId(), request.getTokens());
			}
			else if (0 != pushResponse.getResult())
			{
				throw new PushException("Push data failed, response is " + pushResponse.toString());
			}

			return new PushResult(taskResponse.getTaskId());
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
}
