package com.mizhousoft.push.oppo.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mizhousoft.commons.crypto.CryptoException;
import com.mizhousoft.commons.crypto.digest.SHA256Digest;
import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.commons.lang.CharEncoding;
import com.mizhousoft.commons.lang.HexUtils;
import com.mizhousoft.commons.restclient.service.RestClientService;
import com.mizhousoft.push.exception.PushException;
import com.mizhousoft.push.oppo.OppoAccessToken;
import com.mizhousoft.push.oppo.OppoAuthService;
import com.mizhousoft.push.oppo.OppoGenericResponse;
import com.mizhousoft.push.oppo.config.OppoProfile;

/**
 * 认证服务
 *
 * @version
 */
public class OppoAuthServiceImpl implements OppoAuthService
{
	// 凭证
	private OppoProfile profile;

	// REST服务
	private RestClientService restClientService;

	// 访问Token
	private volatile OppoAccessToken accessToken;

	/**
	 * 构造函数
	 *
	 * @param profile
	 * @param restClientService
	 */
	public OppoAuthServiceImpl(OppoProfile profile, RestClientService restClientService)
	{
		super();
		this.profile = profile;
		this.restClientService = restClientService;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OppoAccessToken getAccessToken() throws PushException
	{
		if (!isAccessTokenExpired())
		{
			return this.accessToken;
		}

		try
		{
			String appKey = profile.getAppKey();
			long timestamp = System.currentTimeMillis();

			String plaintext = String.format("%s%s%s", new Object[] { appKey, Long.valueOf(timestamp), profile.getMasterSecret() });
			byte[] bytes = SHA256Digest.hash(plaintext.getBytes(CharEncoding.UTF8));
			String sign = HexUtils.encodeHexString(bytes, true);

			MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
			postParameters.add("app_key", appKey);
			postParameters.add("sign", sign);
			postParameters.add("timestamp", timestamp);

			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/x-www-form-urlencoded");
			HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(postParameters, headers);

			String responseBody = restClientService.postForObject(OAUTH2_TOKEN_URL, entity, String.class);

			OppoGenericResponse<OppoAccessToken> response = JSONUtils.parse(responseBody,
			        new TypeReference<OppoGenericResponse<OppoAccessToken>>()
			        {
			        });
			if (0 != response.getCode())
			{
				throw new PushException("Auth failed, response is " + response.toString());
			}

			OppoAccessToken accessToken = response.getData();

			long expiresTime = accessToken.getCtime() + (24 * 60 * 60 - 120) * 1000;
			accessToken.setExpiresIn(expiresTime);

			this.accessToken = accessToken;

			return accessToken;
		}
		catch (JSONException e)
		{
			throw new PushException(e.getErrorCode(), e.getMessage(), e);
		}
		catch (CryptoException e)
		{
			throw new PushException(e.getErrorCode(), e.getMessage(), e);
		}
	}

	private boolean isAccessTokenExpired()
	{
		if (null == accessToken)
		{
			return true;
		}

		return (System.currentTimeMillis() > accessToken.getExpiresIn());
	}
}
