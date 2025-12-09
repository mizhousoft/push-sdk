package com.mizhousoft.push.oppo.impl;

import java.util.HashMap;
import java.util.Map;

import com.mizhousoft.commons.crypto.CryptoException;
import com.mizhousoft.commons.crypto.digest.SHA256Digest;
import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.commons.lang.CharEncoding;
import com.mizhousoft.commons.lang.HexUtils;
import com.mizhousoft.push.exception.PushException;
import com.mizhousoft.push.oppo.OppoAccessToken;
import com.mizhousoft.push.oppo.OppoAuthService;
import com.mizhousoft.push.oppo.OppoGenericResponse;
import com.mizhousoft.push.oppo.config.OppoProfile;

import kong.unirest.core.Unirest;
import kong.unirest.core.UnirestException;
import tools.jackson.core.type.TypeReference;

/**
 * 认证服务
 *
 * @version
 */
public class OppoAuthServiceImpl implements OppoAuthService
{
	// 凭证
	private OppoProfile profile;

	// 访问Token
	private volatile OppoAccessToken accessToken;

	/**
	 * 构造函数
	 *
	 * @param profile
	 */
	public OppoAuthServiceImpl(OppoProfile profile)
	{
		super();
		this.profile = profile;
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

			Map<String, Object> postParameters = new HashMap<>(3);
			postParameters.put("app_key", appKey);
			postParameters.put("sign", sign);
			postParameters.put("timestamp", timestamp);

			String responseBody = Unirest.post(OAUTH2_TOKEN_URL).fields(postParameters).asString().getBody();

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
		catch (UnirestException e)
		{
			throw new PushException("Request failed.", e);
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
