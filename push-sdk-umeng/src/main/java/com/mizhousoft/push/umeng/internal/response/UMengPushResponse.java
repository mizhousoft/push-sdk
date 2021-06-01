package com.mizhousoft.push.umeng.internal.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 推送响应
 *
 * @version
 */
public class UMengPushResponse
{
	// SUCCESS/FAIL
	@JsonProperty("ret")
	private String ret;

	// 当"ret"为"SUCCESS"时，包含参数如下:
	@JsonProperty("data")
	private UMengDataResponse data;

	/**
	 * 获取ret
	 * 
	 * @return
	 */
	public String getRet()
	{
		return ret;
	}

	/**
	 * 设置ret
	 * 
	 * @param ret
	 */
	public void setRet(String ret)
	{
		this.ret = ret;
	}

	/**
	 * 获取data
	 * 
	 * @return
	 */
	public UMengDataResponse getData()
	{
		return data;
	}

	/**
	 * 设置data
	 * 
	 * @param data
	 */
	public void setData(UMengDataResponse data)
	{
		this.data = data;
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
		if (ret != null)
		{
			builder.append("ret\":\"");
			builder.append(ret);
			builder.append("\", \"");
		}
		if (data != null)
		{
			builder.append("data\":\"");
			builder.append(data);
		}
		builder.append("\"}");
		return builder.toString();
	}
}
