package com.mizhousoft.push.huawei.internal.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 推送消息响应
 *
 * @version
 */
public class HwMessagePushResponse
{
	// 错误码
	@JsonProperty("code")
	private String code;

	// 错误码描述
	@JsonProperty("msg")
	private String msg;

	// 请求标识
	@JsonProperty("requestId")
	private String requestId;

	/**
	 * 获取code
	 * 
	 * @return
	 */
	public String getCode()
	{
		return code;
	}

	/**
	 * 设置code
	 * 
	 * @param code
	 */
	public void setCode(String code)
	{
		this.code = code;
	}

	/**
	 * 获取msg
	 * 
	 * @return
	 */
	public String getMsg()
	{
		return msg;
	}

	/**
	 * 设置msg
	 * 
	 * @param msg
	 */
	public void setMsg(String msg)
	{
		this.msg = msg;
	}

	/**
	 * 获取requestId
	 * 
	 * @return
	 */
	public String getRequestId()
	{
		return requestId;
	}

	/**
	 * 设置requestId
	 * 
	 * @param requestId
	 */
	public void setRequestId(String requestId)
	{
		this.requestId = requestId;
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
		if (code != null)
		{
			builder.append("code\":\"");
			builder.append(code);
			builder.append("\", \"");
		}
		if (msg != null)
		{
			builder.append("msg\":\"");
			builder.append(msg);
			builder.append("\", \"");
		}
		if (requestId != null)
		{
			builder.append("requestId\":\"");
			builder.append(requestId);
		}
		builder.append("\"}");
		return builder.toString();
	}
}
