package com.mizhousoft.push.oppo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * AccessToken
 *
 * @version
 */
public class OppoAccessToken
{
	// Token
	@JsonProperty("auth_token")
	private String authToken;

	// Token创建时间
	@JsonProperty("create_time")
	private long ctime;

	// 过期时间
	private long expiresIn;

	/**
	 * 获取authToken
	 * @return
	 */
	public String getAuthToken()
	{
		return authToken;
	}

	/**
	 * 设置authToken
	 * @param authToken
	 */
	public void setAuthToken(String authToken)
	{
		this.authToken = authToken;
	}

	/**
	 * 获取ctime
	 * @return
	 */
	public long getCtime()
	{
		return ctime;
	}

	/**
	 * 设置ctime
	 * @param ctime
	 */
	public void setCtime(long ctime)
	{
		this.ctime = ctime;
	}

	/**
	 * 获取expiresIn
	 * @return
	 */
	public long getExpiresIn()
	{
		return expiresIn;
	}

	/**
	 * 设置expiresIn
	 * @param expiresIn
	 */
	public void setExpiresIn(long expiresIn)
	{
		this.expiresIn = expiresIn;
	}
}
