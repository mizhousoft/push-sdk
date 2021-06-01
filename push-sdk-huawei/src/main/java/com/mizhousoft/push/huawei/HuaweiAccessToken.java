package com.mizhousoft.push.huawei;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * AccessToken
 *
 * @version
 */
public class HuaweiAccessToken extends HuaweiError
{
	// Token
	@JsonProperty("access_token")
	private String accessToken;

	// Token过期时间
	@JsonProperty("expires_in")
	private long expiresIn = -1;

	// Token类型
	@JsonProperty("token_type")
	private String tokenType;

	/**
	 * 获取accessToken
	 * 
	 * @return
	 */
	public String getAccessToken()
	{
		return accessToken;
	}

	/**
	 * 设置accessToken
	 * 
	 * @param accessToken
	 */
	public void setAccessToken(String accessToken)
	{
		this.accessToken = accessToken;
	}

	/**
	 * 获取expiresIn
	 * 
	 * @return
	 */
	public long getExpiresIn()
	{
		return expiresIn;
	}

	/**
	 * 设置expiresIn
	 * 
	 * @param expiresIn
	 */
	public void setExpiresIn(long expiresIn)
	{
		this.expiresIn = expiresIn;
	}

	/**
	 * 获取tokenType
	 * 
	 * @return
	 */
	public String getTokenType()
	{
		return tokenType;
	}

	/**
	 * 设置tokenType
	 * 
	 * @param tokenType
	 */
	public void setTokenType(String tokenType)
	{
		this.tokenType = tokenType;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("{\"");
		if (error != null)
		{
			builder.append("error\":\"");
			builder.append(error);
			builder.append("\", \"");
		}
		if (subError != null)
		{
			builder.append("subError\":\"");
			builder.append(subError);
			builder.append("\", \"");
		}
		if (description != null)
		{
			builder.append("description\":\"");
			builder.append(description);
		}
		builder.append("\"}");
		return builder.toString();
	}
}
