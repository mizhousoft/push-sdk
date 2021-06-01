package com.mizhousoft.push.oppo.internal;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 推送响应
 *
 * @version
 */
public class BroadcastPushResponse
{
	// ID
	@JsonProperty("message_id")
	private String messageId;

	// 任务ID
	@JsonProperty("task_id")
	private String taskId;

	// 无效Token
	@JsonProperty("10000")
	private Set<String> invalidTokens;

	// 状态
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
	 * 获取taskId
	 * 
	 * @return
	 */
	public String getTaskId()
	{
		return taskId;
	}

	/**
	 * 设置taskId
	 * 
	 * @param taskId
	 */
	public void setTaskId(String taskId)
	{
		this.taskId = taskId;
	}

	/**
	 * 获取invalidTokens
	 * 
	 * @return
	 */
	public Set<String> getInvalidTokens()
	{
		return invalidTokens;
	}

	/**
	 * 设置invalidTokens
	 * 
	 * @param invalidTokens
	 */
	public void setInvalidTokens(Set<String> invalidTokens)
	{
		this.invalidTokens = invalidTokens;
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
