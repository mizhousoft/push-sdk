package com.mizhousoft.push.vivo.internal.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * AccessToken
 *
 * @version
 */
public class ViVoAccessTokenResponse extends ViVoBaseResponse
{
	// Token
	@JsonProperty("authToken")
	private String authToken;

	/**
	 * 获取authToken
	 * 
	 * @return
	 */
	public String getAuthToken()
	{
		return authToken;
	}

	/**
	 * 设置authToken
	 * 
	 * @param authToken
	 */
	public void setAuthToken(String authToken)
	{
		this.authToken = authToken;
	}
}
