package com.mizhousoft.push.huawei.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.commons.restclient.service.RestClientService;
import com.mizhousoft.push.exception.PushException;
import com.mizhousoft.push.huawei.HuaweiAccessToken;
import com.mizhousoft.push.huawei.HuaweiAuthService;
import com.mizhousoft.push.huawei.config.HuaweiProfile;

/**
 * 认证服务
 *
 * @version
 */
public class HuaweiAuthServiceImpl implements HuaweiAuthService
{
	// 凭证
	private HuaweiProfile profile;

	// REST服务
	private RestClientService restClientService;

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
			MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
			postParameters.add("grant_type", "client_credentials");
			postParameters.add("client_id", profile.getAppId());
			postParameters.add("client_secret", profile.getAppSecret());

			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/x-www-form-urlencoded");
			HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(postParameters, headers);

			String responseBody = restClientService.postForObject(OAUTH2_TOKEN_URL, entity, String.class);

			try
			{
				HuaweiAccessToken hwAccessToken = JSONUtils.parse(responseBody, HuaweiAccessToken.class);

				if (!StringUtils.isBlank(hwAccessToken.getError()))
				{
					throw new PushException("Push outh2 failed, error is " + hwAccessToken.toString());
				}

				long expiresTime = System.currentTimeMillis() + (hwAccessToken.getExpiresIn() - 120) * 1000L;
				hwAccessToken.setExpiresIn(expiresTime);

				this.accessToken = hwAccessToken;
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

	/**
	 * 设置restClientService
	 * 
	 * @param restClientService
	 */
	public void setRestClientService(RestClientService restClientService)
	{
		this.restClientService = restClientService;
	}
}
