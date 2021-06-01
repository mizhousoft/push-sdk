package com.mizhousoft.push.vivo.internal.request;

import java.util.Set;

/**
 * 广播推送请求
 *
 * @version
 */
public class ViVoBroadcastPushRequest
{
	// regId列表 个数大于等于2，小于等于1000，regId长度23个字符（regIds，aliases 两者需一个不为空，两个不为空，取regIds）
	private Set<String> regIds;

	// 别名列表个数大于等于2，小于等于1000，长度不超过40字符（regIds，aliases 两者需一个不为空，两个不为空，取regIds）
	private Set<String> aliases;

	// 公共消息任务号，取saveListPayload返回的taskId
	private String taskId;

	// 请求唯一标识，最大64字符
	private String requestId;

	// 推送模式 0：正式推送；1：测试推送，不填默认为0
	private Integer pushMode;

	/**
	 * 获取regIds
	 * 
	 * @return
	 */
	public Set<String> getRegIds()
	{
		return regIds;
	}

	/**
	 * 设置regIds
	 * 
	 * @param regIds
	 */
	public void setRegIds(Set<String> regIds)
	{
		this.regIds = regIds;
	}

	/**
	 * 获取aliases
	 * 
	 * @return
	 */
	public Set<String> getAliases()
	{
		return aliases;
	}

	/**
	 * 设置aliases
	 * 
	 * @param aliases
	 */
	public void setAliases(Set<String> aliases)
	{
		this.aliases = aliases;
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
	 * 获取pushMode
	 * 
	 * @return
	 */
	public Integer getPushMode()
	{
		return pushMode;
	}

	/**
	 * 设置pushMode
	 * 
	 * @param pushMode
	 */
	public void setPushMode(Integer pushMode)
	{
		this.pushMode = pushMode;
	}
}
