package com.mizhousoft.push.oppo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 结果
 *
 * @version
 */
public class OppoGenericResponse<T>
{
	// 结果码
	@JsonProperty("code")
	protected int code;

	// 描述
	@JsonProperty("message")
	protected String message;

	// 数据
	@JsonProperty("data")
	private T data;

	/**
	 * 获取code
	 * 
	 * @return
	 */
	public int getCode()
	{
		return code;
	}

	/**
	 * 设置code
	 * 
	 * @param code
	 */
	public void setCode(int code)
	{
		this.code = code;
	}

	/**
	 * 获取message
	 * 
	 * @return
	 */
	public String getMessage()
	{
		return message;
	}

	/**
	 * 设置message
	 * 
	 * @param message
	 */
	public void setMessage(String message)
	{
		this.message = message;
	}

	/**
	 * 获取data
	 * 
	 * @return
	 */
	public T getData()
	{
		return data;
	}

	/**
	 * 设置data
	 * 
	 * @param data
	 */
	public void setData(T data)
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
		builder.append("{\"code\":\"");
		builder.append(code);
		builder.append("\", \"");
		if (message != null)
		{
			builder.append("message\":\"");
			builder.append(message);
		}
		builder.append("\"}");
		return builder.toString();
	}
}
