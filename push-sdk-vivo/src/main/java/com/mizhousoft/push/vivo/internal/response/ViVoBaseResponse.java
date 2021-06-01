package com.mizhousoft.push.vivo.internal.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 响应
 *
 * @version
 */
public class ViVoBaseResponse
{
	// 结果
	@JsonProperty("result")
	protected int result;

	// 描述
	@JsonProperty("desc")
	protected String desc;

	/**
	 * 获取result
	 * 
	 * @return
	 */
	public int getResult()
	{
		return result;
	}

	/**
	 * 设置result
	 * 
	 * @param result
	 */
	public void setResult(int result)
	{
		this.result = result;
	}

	/**
	 * 获取desc
	 * 
	 * @return
	 */
	public String getDesc()
	{
		return desc;
	}

	/**
	 * 设置desc
	 * 
	 * @param desc
	 */
	public void setDesc(String desc)
	{
		this.desc = desc;
	}
}
