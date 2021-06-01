package com.mizhousoft.push.huawei;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 错误
 *
 * @version
 */
public class HuaweiError
{
	// 错误
	@JsonProperty("error")
	protected String error;

	// 错误
	@JsonProperty("sub_error")
	protected String subError;

	// 错误信息
	@JsonProperty("error_description")
	protected String description;

	/**
	 * 获取error
	 * @return
	 */
	public String getError()
	{
		return error;
	}

	/**
	 * 设置error
	 * @param error
	 */
	public void setError(String error)
	{
		this.error = error;
	}

	/**
	 * 获取subError
	 * @return
	 */
	public String getSubError()
	{
		return subError;
	}

	/**
	 * 设置subError
	 * @param subError
	 */
	public void setSubError(String subError)
	{
		this.subError = subError;
	}

	/**
	 * 获取description
	 * @return
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * 设置description
	 * @param description
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}
}
