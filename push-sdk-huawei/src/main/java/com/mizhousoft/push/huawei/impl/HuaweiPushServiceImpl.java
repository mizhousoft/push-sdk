package com.mizhousoft.push.huawei.impl;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.push.action.ClickAction;
import com.mizhousoft.push.action.IntentClickAction;
import com.mizhousoft.push.exception.PushException;
import com.mizhousoft.push.huawei.HuaweiAccessToken;
import com.mizhousoft.push.huawei.HuaweiAuthService;
import com.mizhousoft.push.huawei.HuaweiPushService;
import com.mizhousoft.push.huawei.config.HuaweiProfile;
import com.mizhousoft.push.huawei.constant.HuaweiConstants;
import com.mizhousoft.push.huawei.internal.HwResultCodeMap;
import com.mizhousoft.push.huawei.internal.android.HwAndroidNotification;
import com.mizhousoft.push.huawei.internal.android.HwClickAction;
import com.mizhousoft.push.huawei.internal.message.HwAndroidConfig;
import com.mizhousoft.push.huawei.internal.message.HwMessage;
import com.mizhousoft.push.huawei.internal.message.HwNotification;
import com.mizhousoft.push.huawei.internal.message.HwPushRequest;
import com.mizhousoft.push.huawei.internal.response.HwMessagePushResponse;
import com.mizhousoft.push.huawei.internal.response.HwPartSucceedResponse;
import com.mizhousoft.push.request.MessageRequest;
import com.mizhousoft.push.request.NotificationRequest;
import com.mizhousoft.push.result.PushResult;
import com.mizhousoft.push.util.IntentUtils;
import com.mizhousoft.push.util.PushAsserts;
import com.mizhousoft.push.validator.RequestValidator;

import kong.unirest.core.Unirest;
import kong.unirest.core.UnirestException;

/**
 * 推送服务
 *
 * @version
 */
public class HuaweiPushServiceImpl implements HuaweiPushService
{
	private static final Logger LOG = LoggerFactory.getLogger(HuaweiPushServiceImpl.class);

	// 凭证
	private HuaweiProfile profile;

	// HuaweiAuthService
	private HuaweiAuthService huaweiAuthService;

	/**
	 * 构造函数
	 *
	 * @param profile
	 */
	public HuaweiPushServiceImpl(HuaweiProfile profile)
	{
		super();
		this.profile = profile;

		HuaweiAuthServiceImpl huaweiAuthService = new HuaweiAuthServiceImpl();
		huaweiAuthService.setProfile(this.profile);
		this.huaweiAuthService = huaweiAuthService;
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

		HwMessage message = new HwMessage();

		Set<String> tokens = new HashSet<>(request.getTokens());
		message.setTokens(tokens);

		HwNotification notification = new HwNotification();
		notification.setTitle(request.getTitle());
		notification.setBody(request.getBody());
		message.setNotification(notification);

		HwAndroidConfig androidConfig = new HwAndroidConfig();

		HwAndroidNotification androidNotification = new HwAndroidNotification();
		androidNotification.setTitle(request.getTitle());
		androidNotification.setBody(request.getBody());
		androidNotification.setVisibility(HuaweiConstants.VISIBILITY_PUBLIC);
		androidNotification.setImportance(HuaweiConstants.IMPORTANCE_NORMAL);
		androidNotification.setChannelId(request.getChannelId());
		androidNotification.setStyle(HuaweiConstants.STYLE_DEFAULE);
		androidNotification.setForegroundShow(true);

		ClickAction action = request.getClickAction();
		if (action instanceof IntentClickAction)
		{
			HwClickAction clickAction = new HwClickAction();
			clickAction.setType(HuaweiConstants.CLICK_ACTION_OPEN_CUST_ACTIVITY);

			String intent = IntentUtils.formatIntent(profile.getIntentFormat(), action.getExtProperties());
			clickAction.setIntent(intent);

			androidNotification.setClickAction(clickAction);
		}

		androidConfig.setNotification(androidNotification);
		message.setAndroidConfig(androidConfig);

		HwPushRequest pushRequest = new HwPushRequest();
		pushRequest.setMessage(message);

		return sendPushMessage(pushRequest);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PushResult pushMessage(MessageRequest request) throws PushException
	{
		PushAsserts.notEmpty(request.getDataMap(), "Request data map is null.");
		PushAsserts.notEmpty(request.getTokens(), "Request tokens is null.");

		if (request.getTokens().size() > 1000)
		{
			throw new PushException("Token too many, can not exceed 1000.");
		}

		try
		{
			HwPushRequest pushRequest = new HwPushRequest();

			HwMessage message = new HwMessage();
			message.setTokens(request.getTokens());

			if (null != request.getDataMap())
			{
				String data = JSONUtils.toJSONString(request.getDataMap());
				message.setData(data);
			}

			pushRequest.setMessage(message);

			return sendPushMessage(pushRequest);
		}
		catch (JSONException e)
		{
			throw new PushException("Serialize object is null.", e);
		}
	}

	private PushResult sendPushMessage(HwPushRequest request) throws PushException
	{
		try
		{
			HuaweiAccessToken accessToken = huaweiAuthService.getAccessToken();
			String authorization = accessToken.getTokenType() + " " + accessToken.getAccessToken();

			String requestBody = JSONUtils.toJSONString(request);

			String url = String.format(PUSH_URL, profile.getAppId());

			String responseBody = Unirest.post(url).body(requestBody).header("Authorization", authorization)
			        .header("Content-Type", "application/json; charset=UTF-8").asString().getBody();

			LOG.info("Push response is {}.", responseBody);

			HwMessagePushResponse pushResponse = JSONUtils.parse(responseBody, HwMessagePushResponse.class);

			PushResult pushResult = buildPushResult(request, pushResponse);

			return pushResult;
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

	private PushResult buildPushResult(HwPushRequest request, HwMessagePushResponse pushResponse) throws JSONException, PushException
	{
		String requestId = pushResponse.getRequestId();
		Set<String> tokens = request.getMessage().getTokens();

		if (HwResultCodeMap.isPartSucceedCode(pushResponse.getCode()))
		{
			HwPartSucceedResponse partSucceed = JSONUtils.parse(pushResponse.getMsg(), HwPartSucceedResponse.class);

			Set<String> illegalTokens = partSucceed.getIllegalTokens();

			return new PushResult(requestId, illegalTokens);
		}
		else if (HwResultCodeMap.isAllIllegalTokenCode(pushResponse.getCode()))
		{
			return new PushResult(requestId, tokens);
		}
		else if (HwResultCodeMap.isSucceedCode(pushResponse.getCode()))
		{
			return new PushResult(requestId);
		}
		else
		{
			throw new PushException("Push data failed, error is " + pushResponse.toString() + '.');
		}
	}
}
