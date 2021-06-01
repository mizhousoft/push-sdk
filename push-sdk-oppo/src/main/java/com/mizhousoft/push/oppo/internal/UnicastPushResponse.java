package com.mizhousoft.push.oppo.internal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 推送响应
 *
 * @version
 */
public class UnicastPushResponse
{
	// ID
	@JsonProperty("messageId")
	private String messageId;

	@JsonProperty("status")
	private String status;

	/**
	 * 获取messageId
	 * 
	 * @return
	 */
	public String getMessageId()
	{
		return messageId;
	}

	/**
	 * 设置messageId
	 * 
	 * @param messageId
	 */
	public void setMessageId(String messageId)
	{
		this.messageId = messageId;
	}

	/**
	 * 获取status
	 * 
	 * @return
	 */
	public String getStatus()
	{
		return status;
	}

	/**
	 * 设置status
	 * 
	 * @param status
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}
}
