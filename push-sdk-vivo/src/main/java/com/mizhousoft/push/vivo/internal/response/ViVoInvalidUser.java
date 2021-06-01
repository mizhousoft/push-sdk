package com.mizhousoft.push.vivo.internal.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 非法用户
 *
 * @version
 */
public class ViVoInvalidUser
{
	// userId不存在
	public static final int USER_NOT_FOUND = 1;

	// 卸载或者关闭了通知
	public static final int NOTIFICATION_CLOSE = 2;

	// 90天不在线
	public static final int OFFLINE_90_DAYS = 3;

	// 非测试用户
	public static final int NOT_TEST_USER = 4;

	// 状态
	@JsonProperty("status")
	private int status;

	// 用户ID
	@JsonProperty("userid")
	private String userId;

	/**
	 * 获取status
	 * 
	 * @return
	 */
	public int getStatus()
	{
		return status;
	}

	/**
	 * 设置status
	 * 
	 * @param status
	 */
	public void setStatus(int status)
	{
		this.status = status;
	}

	/**
	 * 获取userId
	 * 
	 * @return
	 */
	public String getUserId()
	{
		return userId;
	}

	/**
	 * 设置userId
	 * 
	 * @param userId
	 */
	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("{\"status\":\"");
		builder.append(status);
		builder.append("\", \"");
		if (userId != null)
		{
			builder.append("userId\":\"");
			builder.append(userId);
		}
		builder.append("\"}");
		return builder.toString();
	}
}
