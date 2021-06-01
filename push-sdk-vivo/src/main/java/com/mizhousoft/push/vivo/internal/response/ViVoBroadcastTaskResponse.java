package com.mizhousoft.push.vivo.internal.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 响应
 *
 * @version
 */
public class ViVoBroadcastTaskResponse extends ViVoBaseResponse
{
	// 任务ID
	@JsonProperty("taskId")
	private String taskId;

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
