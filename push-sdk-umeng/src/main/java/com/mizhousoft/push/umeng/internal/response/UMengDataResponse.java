package com.mizhousoft.push.umeng.internal.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 数据响应
 *
 * @version
 */
public class UMengDataResponse
{
	// 单播类消息(type为unicast、listcast、customizedcast且不带file_id)返回：
	@JsonProperty("msg_id")
	private String msgId;

	// 任务类消息(type为broadcast、groupcast、filecast、customizedcast且file_id不为空)返回：
	@JsonProperty("task_id")
	private String taskId;

	// 当"ret"为"FAIL"时，包含参数如下:
	// 错误码，详见附录I
	@JsonProperty("error_code")
	private String errorCode;

	// 错误信息
	@JsonProperty("error_msg")
	private String errorMsg;

	/**
	 * 获取msgId
	 * 
	 * @return
	 */
	public String getMsgId()
	{
		return msgId;
	}

	/**
	 * 设置msgId
	 * 
	 * @param msgId
	 */
	public void setMsgId(String msgId)
	{
		this.msgId = msgId;
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
	 * 获取errorCode
	 * 
	 * @return
	 */
	public String getErrorCode()
	{
		return errorCode;
	}

	/**
	 * 设置errorCode
	 * 
	 * @param errorCode
	 */
	public void setErrorCode(String errorCode)
	{
		this.errorCode = errorCode;
	}

	/**
	 * 获取errorMsg
	 * 
	 * @return
	 */
	public String getErrorMsg()
	{
		return errorMsg;
	}

	/**
	 * 设置errorMsg
	 * 
	 * @param errorMsg
	 */
	public void setErrorMsg(String errorMsg)
	{
		this.errorMsg = errorMsg;
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
		if (msgId != null)
		{
			builder.append("msgId\":\"");
			builder.append(msgId);
			builder.append("\", \"");
		}
		if (taskId != null)
		{
			builder.append("taskId\":\"");
			builder.append(taskId);
			builder.append("\", \"");
		}
		if (errorCode != null)
		{
			builder.append("errorCode\":\"");
			builder.append(errorCode);
			builder.append("\", \"");
		}
		if (errorMsg != null)
		{
			builder.append("errorMsg\":\"");
			builder.append(errorMsg);
		}
		builder.append("\"}");
		return builder.toString();
	}
}
