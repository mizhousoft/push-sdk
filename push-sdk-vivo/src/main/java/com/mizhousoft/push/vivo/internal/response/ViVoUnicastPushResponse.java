package com.mizhousoft.push.vivo.internal.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 响应
 *
 * @version
 */
public class ViVoUnicastPushResponse extends ViVoBaseResponse
{
	// 任务ID
	@JsonProperty("taskId")
	private String taskId;

	// 非法用户
	@JsonProperty("invalidUser")
	private ViVoInvalidUser invalidUser;

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
	 * 获取invalidUser
	 * 
	 * @return
	 */
	public ViVoInvalidUser getInvalidUser()
	{
		return invalidUser;
	}

	/**
	 * 设置invalidUser
	 * 
	 * @param invalidUser
	 */
	public void setInvalidUser(ViVoInvalidUser invalidUser)
	{
		this.invalidUser = invalidUser;
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
		if (taskId != null)
		{
			builder.append("taskId\":\"");
			builder.append(taskId);
			builder.append("\", \"");
		}
		if (invalidUser != null)
		{
			builder.append("invalidUser\":\"");
			builder.append(invalidUser);
			builder.append("\", \"");
		}
		builder.append("result\":\"");
		builder.append(result);
		builder.append("\", \"");
		if (desc != null)
		{
			builder.append("desc\":\"");
			builder.append(desc);
		}
		builder.append("\"}");
		return builder.toString();
	}
}
