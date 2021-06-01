package com.mizhousoft.push.oppo.internal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 推送响应
 *
 * @version
 */
public class BroadcastTaskResponse
{
	// ID
	@JsonProperty("message_id")
	private String messageId;

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
}
