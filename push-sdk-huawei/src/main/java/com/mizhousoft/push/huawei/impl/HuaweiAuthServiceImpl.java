package com.mizhousoft.push.huawei.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.push.exception.PushException;
import com.mizhousoft.push.huawei.HuaweiAccessToken;
import com.mizhousoft.push.huawei.HuaweiAuthService;
import com.mizhousoft.push.huawei.config.HuaweiProfile;

import kong.unirest.core.Unirest;
import kong.unirest.core.UnirestException;

/**
 * 认证服务
 *
 * @version
 */
public class HuaweiAuthServiceImpl implements HuaweiAuthService
{
	// 凭证
	private HuaweiProfile profile;

	// 访问Token
	private volatile HuaweiAccessToken accessToken;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized HuaweiAccessToken getAccessToken() throws PushException
	{
		if (isAccessTokenExpired())
		{
			Map<String, Object> postParameters = new HashMap<>(3);
			postParameters.put("grant_type", "client_credentials");
			postParameters.put("client_id", profile.getAppId());
			postParameters.put("client_secret", profile.getAppSecret());

			try
			{
				String responseBody = Unirest.post(OAUTH2_TOKEN_URL).fields(postParameters).asString().getBody();

				HuaweiAccessToken hwAccessToken = JSONUtils.parse(responseBody, HuaweiAccessToken.class);

				if (!StringUtils.isBlank(hwAccessToken.getError()))
				{
					throw new PushException("Push outh2 failed, error is " + hwAccessToken.toString());
				}

				long expiresTime = System.currentTimeMillis() + (hwAccessToken.getExpiresIn() - 120) * 1000L;
				hwAccessToken.setExpiresIn(expiresTime);

				this.accessToken = hwAccessToken;
			}
			catch (UnirestException e)
			{
				throw new PushException(e.getMessage(), e);
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

		return (System.currentTimeMillis() > accessToken.getExpiresIn());
	}

	/**
	 * 设置profile
	 * 
	 * @param profile
	 */
	public void setProfile(HuaweiProfile profile)
	{
		this.profile = profile;
	}
}
