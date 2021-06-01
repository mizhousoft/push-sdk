package com.mizhousoft.push.umeng.impl;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.commons.lang.CharEncoding;
import com.mizhousoft.commons.restclient.service.RestClientService;
import com.mizhousoft.push.exception.PushException;
import com.mizhousoft.push.request.NotificationRequest;
import com.mizhousoft.push.result.PushResult;
import com.mizhousoft.push.umeng.UMengNotificationRequest;
import com.mizhousoft.push.umeng.UMengPushService;
import com.mizhousoft.push.umeng.config.UMengProfile;
import com.mizhousoft.push.umeng.constant.UMengConstants;
import com.mizhousoft.push.umeng.internal.request.UMengMessageRequest;
import com.mizhousoft.push.umeng.internal.request.UMengPayload;
import com.mizhousoft.push.umeng.internal.request.UMengPayloadBody;
import com.mizhousoft.push.umeng.internal.response.UMengDataResponse;
import com.mizhousoft.push.umeng.internal.response.UMengPushResponse;
import com.mizhousoft.push.validator.RequestValidator;

/**
 * 友盟推送服务
 *
 * @version
 */
public class UMengPushServiceImpl implements UMengPushService
{
	private static final Logger LOG = LoggerFactory.getLogger(UMengPushServiceImpl.class);

	// 凭证
	private UMengProfile profile;

	// REST服务
	private RestClientService restClientService;

	/**
	 * 构造函数
	 *
	 * @param profile
	 * @param restClientService
	 */
	public UMengPushServiceImpl(UMengProfile profile, RestClientService restClientService)
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

		UMengMessageRequest messageRequest = convertTo(request);

		try
		{
			String requestBody = JSONUtils.toJSONString(messageRequest);

			String signPlainText = "POST" + PUSH_URL + requestBody + profile.getAppSecret();
			String sign = DigestUtils.md5Hex(signPlainText.getBytes(CharEncoding.UTF8)).toLowerCase(Locale.US);

			String url = PUSH_URL + "?sign=" + sign;

			HttpHeaders headers = new HttpHeaders();
			MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
			headers.setContentType(type);

			HttpEntity<String> httpEntity = new HttpEntity<String>(requestBody, headers);

			String responseBody = restClientService.postForObject(url, httpEntity, String.class);

			LOG.info("Push response is {}.", responseBody);

			UMengPushResponse response = JSONUtils.parse(responseBody, UMengPushResponse.class);
			if (null == response || null == response.getData())
			{
				throw new PushException("Invoke umeng send url failed.");
			}

			UMengDataResponse resultData = response.getData();

			String taskId = StringUtils.isBlank(resultData.getMsgId()) ? resultData.getTaskId() : resultData.getMsgId();
			if (UMengConstants.RESULT_FAIL.equals(response.getRet()))
			{
				return new PushResult(taskId, request.getTokens());
			}

			return new PushResult(taskId);
		}
		catch (JSONException e)
		{
			throw new PushException("Serialize object is null.", e);
		}
	}

	private UMengMessageRequest convertTo(NotificationRequest request) throws PushException
	{
		if (request instanceof UMengNotificationRequest)
		{
			UMengNotificationRequest umengRequest = (UMengNotificationRequest) request;

			UMengPayloadBody payloadBody = new UMengPayloadBody();
			payloadBody.setTitle(umengRequest.getTitle());
			payloadBody.setText(umengRequest.getBody());
			payloadBody.setAfterOpen(UMengConstants.CLICK_ACTION_GO_APP);

			HashMap<String, String> extra = new HashMap<String, String>();

			Map<String, Object> extProperties = request.getClickAction().getExtProperties();
			extProperties.forEach((key, value) -> extra.put(key, value.toString()));

			UMengPayload payload = new UMengPayload();
			payload.setDisplayType(UMengConstants.DISPLAY_TYPE_NOTIFICATION);
			payload.setBody(payloadBody);
			payload.setExtra(extra);

			String alias = StringUtils.join(umengRequest.getTokens().iterator(), ",");

			UMengMessageRequest msgRequest = new UMengMessageRequest();
			msgRequest.setAlias(alias);
			msgRequest.setAliasType(umengRequest.getAliasType());
			msgRequest.setAppKey(profile.getAppId());
			msgRequest.setType(UMengConstants.MESSAGE_TYPE_CUSTOMIZEDCAST);
			msgRequest.setTimestamp(System.currentTimeMillis() + "");
			msgRequest.setProductionMode(BooleanUtils.toStringTrueFalse(profile.isSandbox()));
			msgRequest.setPayload(payload);

			return msgRequest;
		}
		else
		{
			throw new PushException("Notification not support.");
		}
	}
}
