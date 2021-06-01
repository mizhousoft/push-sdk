package com.mizhousoft.push.xiaomi.impl;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.commons.restclient.service.RestClientService;
import com.mizhousoft.push.action.ClickAction;
import com.mizhousoft.push.action.IntentClickAction;
import com.mizhousoft.push.exception.PushException;
import com.mizhousoft.push.request.NotificationRequest;
import com.mizhousoft.push.result.PushResult;
import com.mizhousoft.push.util.IntentUtils;
import com.mizhousoft.push.validator.RequestValidator;
import com.mizhousoft.push.xiaomi.XiaoMiPushService;
import com.mizhousoft.push.xiaomi.config.XiaoMiProfile;
import com.mizhousoft.push.xiaomi.constant.XiaoMiConstants;
import com.mizhousoft.push.xiaomi.internal.request.MiMessageExtra;
import com.mizhousoft.push.xiaomi.internal.request.MiMessageRequest;
import com.mizhousoft.push.xiaomi.internal.response.MiMessagePushResponse;

/**
 * 小米推送服务
 *
 * @version
 */
public class XiaoMiPushServiceImpl implements XiaoMiPushService
{
	private static final Logger LOG = LoggerFactory.getLogger(XiaoMiPushServiceImpl.class);

	// 凭证
	private XiaoMiProfile profile;

	// REST服务
	private RestClientService restClientService;

	// 通知ID
	private AtomicInteger notifyId = new AtomicInteger(1);

	/**
	 * 构造函数
	 *
	 * @param profile
	 * @param restClientService
	 */
	public XiaoMiPushServiceImpl(XiaoMiProfile profile, RestClientService restClientService)
	{
		super();
		this.profile = profile;
		this.restClientService = restClientService;
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

		MiMessageRequest messageRequest = convertTo(request);

		try
		{
			String authorization = "key=" + profile.getAppSecret();

			HttpHeaders headers = new HttpHeaders();
			MediaType type = MediaType.parseMediaType("application/x-www-form-urlencoded;charset=UTF-8");
			headers.setContentType(type);
			headers.add("Authorization", authorization);

			MultiValueMap<String, Object> formData = buildFormData(messageRequest);

			HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(formData, headers);

			String response = restClientService.postForObject(PUSH_URL, httpEntity, String.class);

			LOG.info("Push response is {}.", response);

			MiMessagePushResponse pushResponse = JSONUtils.parse(response, MiMessagePushResponse.class);

			if (XiaoMiConstants.SEND_MESSAGE_FAILURE == pushResponse.getCode())
			{
				return new PushResult(pushResponse.getTraceId(), request.getTokens());
			}
			else if (0 != pushResponse.getCode())
			{
				throw new PushException("Push data failed, response is " + pushResponse.toString() + '.');
			}

			return new PushResult(pushResponse.getTraceId(), pushResponse.getIllegalTokens());
		}
		catch (JSONException e)
		{
			throw new PushException("Serialize object is null.", e);
		}
	}

	private MiMessageRequest convertTo(NotificationRequest request)
	{
		MiMessageRequest messageRequest = new MiMessageRequest();
		messageRequest.setRestrictedPackageNames(profile.getPackageNames());
		messageRequest.setPassThrough(XiaoMiConstants.PASS_THROUGH_NOTIFICATION);
		messageRequest.setTitle(request.getTitle());
		messageRequest.setDescription(request.getBody());
		messageRequest.setNotifyType(XiaoMiConstants.NOTIFY_TYPE_SOUND);
		messageRequest.setRegId(StringUtils.join(request.getTokens(), ","));
		messageRequest.setNotifyId(getNotifiyId());

		MiMessageExtra extra = new MiMessageExtra();
		extra.setForeground(XiaoMiConstants.NOTIFY_FOREGROUND_OPEN);

		ClickAction action = request.getClickAction();
		if (action instanceof IntentClickAction)
		{
			extra.setEffect(XiaoMiConstants.NOTIFY_EFFECT_ANY_ACTIVITY);

			String intent = IntentUtils.formatIntent(profile.getIntentFormat(), action.getExtProperties());
			extra.setIntentUri(intent);
		}

		messageRequest.setExtra(extra);

		return messageRequest;
	}

	private MultiValueMap<String, Object> buildFormData(MiMessageRequest request)
	{
		MultiValueMap<String, Object> formData = new LinkedMultiValueMap<>(20);
		formData.add(MiMessageRequest.RESTRICTED_PACKAGE_NAME, request.getRestrictedPackageNames());
		formData.add(MiMessageRequest.PASS_THROUGH, request.getPassThrough());
		formData.add(MiMessageRequest.TITLE, request.getTitle());
		formData.add(MiMessageRequest.DESCRIPTION, request.getDescription());
		formData.add(MiMessageRequest.NOTIFY_TYPE, request.getNotifyType());
		formData.add(MiMessageRequest.REGISTRATION_ID, request.getRegId());
		formData.add(MiMessageRequest.NOTIFY_ID, request.getNotifyId());

		MiMessageExtra extra = request.getExtra();
		formData.add(MiMessageExtra.NOTIFY_EFFECT, extra.getEffect());
		formData.add(MiMessageExtra.INTENT_URI, extra.getIntentUri());
		formData.add(MiMessageExtra.NOTIFY_FOREGROUND, extra.getForeground());

		return formData;
	}

	private int getNotifiyId()
	{
		int value = notifyId.getAndIncrement();
		if (value > 1000000)
		{
			notifyId.set(1);
		}

		return value;
	}
}
