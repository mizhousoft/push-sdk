package com.mizhousoft.push.vivo.impl;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;

import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.commons.lang.CharEncoding;
import com.mizhousoft.push.exception.PushException;
import com.mizhousoft.push.vivo.ViVoAuthService;
import com.mizhousoft.push.vivo.ViVoResultCodeMap;
import com.mizhousoft.push.vivo.config.ViVoProfile;
import com.mizhousoft.push.vivo.internal.response.ViVoAccessTokenResponse;

import kong.unirest.core.Unirest;
import kong.unirest.core.UnirestException;

/**
 * ViVo认证服务
 *
 * @version
 */
public class ViVoAuthServiceImpl implements ViVoAuthService
{
	// 凭证
	private ViVoProfile profile;

	// 访问Token
	private volatile String accessToken;

	// Token过期时间
	private volatile long expiresTime;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized String getAccessToken() throws PushException
	{
		if (isAccessTokenExpired())
		{
			long timestamp = System.currentTimeMillis();
			String signPlainText = profile.getAppId() + profile.getAppKey() + timestamp + profile.getAppSecret();

			try
			{
				String sign = DigestUtils.md5Hex(signPlainText.getBytes(CharEncoding.UTF8)).toLowerCase(Locale.US);

				Map<String, Object> requestMap = new HashMap<>(4);
				requestMap.put("appId", profile.getAppId());
				requestMap.put("appKey", profile.getAppKey());
				requestMap.put("timestamp", timestamp);
				requestMap.put("sign", sign);

				String responseBody = Unirest.post(AUTH_URL).body(requestMap).asString().getBody();

				ViVoAccessTokenResponse tokenResponse = JSONUtils.parse(responseBody, ViVoAccessTokenResponse.class);

				if (0 != tokenResponse.getResult())
				{
					throw new PushException(
					        "result is " + tokenResponse.getResult() + ", " + ViVoResultCodeMap.getDescription(tokenResponse.getResult()));
				}

				this.accessToken = tokenResponse.getAuthToken();
				this.expiresTime = System.currentTimeMillis() + (2 * 60 * 60 - 200) * 1000L;
			}
			catch (UnirestException e)
			{
				throw new PushException("Request failed.", e);
			}
			catch (JSONException e)
			{
				throw new PushException(e.getErrorCode(), e);
			}
		}

		return this.accessToken;
	}

	private boolean isAccessTokenExpired()
	{
		if (null == accessToken)
		{
			return true;
		}

		return (System.currentTimeMillis() > expiresTime);
	}

	/**
	 * 设置profile
	 * 
	 * @param profile
	 */
	public void setProfile(ViVoProfile profile)
	{
		this.profile = profile;
	}

}
