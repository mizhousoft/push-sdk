package com.mizhousoft.push.umeng;

import java.util.Map;

import com.mizhousoft.push.request.NotificationRequest;

/**
 * 推送通知请求
 *
 * @version
 */
public class UMengNotificationRequest extends NotificationRequest
{
	// alias的类型
	private String aliasType;

	/**
	 * 构造函数
	 *
	 * @param userId
	 * @param token
	 */
	public UMengNotificationRequest(int userId, String token)
	{
		super(userId, token);
	}

	/**
	 * 构造函数
	 *
	 * @param tokenMap
	 */
	public UMengNotificationRequest(Map<String, Integer> tokenMap)
	{
		super(tokenMap);
	}

	/**
	 * 获取aliasType
	 * 
	 * @return
	 */
	public String getAliasType()
	{
		return aliasType;
	}

	/**
	 * 设置aliasType
	 * 
	 * @param aliasType
	 */
	public void setAliasType(String aliasType)
	{
		this.aliasType = aliasType;
	}
}
