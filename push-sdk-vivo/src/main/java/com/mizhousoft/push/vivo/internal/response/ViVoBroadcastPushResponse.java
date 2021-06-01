package com.mizhousoft.push.vivo.internal.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 响应
 *
 * @version
 */
public class ViVoBroadcastPushResponse extends ViVoBaseResponse
{
	// 非法用户
	@JsonProperty("invalidUsers")
	private List<ViVoInvalidUser> invalidUsers;

	public List<String> getIllegalTokens()
	{
		List<String> list = new ArrayList<>(0);
		if (null != invalidUsers)
		{
			invalidUsers.forEach(item -> {
				if (ViVoInvalidUser.NOTIFICATION_CLOSE != item.getStatus())
				{
					list.add(item.getUserId());
				}
			});
		}

		return list;
	}

	/**
	 * 获取invalidUsers
	 * 
	 * @return
	 */
	public List<ViVoInvalidUser> getInvalidUsers()
	{
		return invalidUsers;
	}

	/**
	 * 设置invalidUsers
	 * 
	 * @param invalidUsers
	 */
	public void setInvalidUsers(List<ViVoInvalidUser> invalidUsers)
	{
		this.invalidUsers = invalidUsers;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("{\"result\":\"");
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
