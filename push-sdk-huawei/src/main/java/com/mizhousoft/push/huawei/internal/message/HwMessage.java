package com.mizhousoft.push.huawei.internal.message;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Message
 *
 * @version
 */
public class HwMessage
{
	// 自定义消息负载，支持普通字符串或者JSON格式字符串。样例："your data"，"{'param1':'value1','param2':'value2'}"。
	@JsonProperty("data")
	private String data;

	// 通知栏消息内容
	@JsonProperty("notification")
	private HwNotification notification;

	// 安卓消息推送控制参数
	@JsonProperty("android")
	private HwAndroidConfig androidConfig;

	// 按照Token向目标用户推消息
	@JsonProperty("token")
	private Set<String> tokens = new HashSet<>();

	/**
	 * 获取data
	 * 
	 * @return
	 */
	public String getData()
	{
		return data;
	}

	/**
	 * 设置data
	 * 
	 * @param data
	 */
	public void setData(String data)
	{
		this.data = data;
	}

	/**
	 * 获取notification
	 * 
	 * @return
	 */
	public HwNotification getNotification()
	{
		return notification;
	}

	/**
	 * 设置notification
	 * 
	 * @param notification
	 */
	public void setNotification(HwNotification notification)
	{
		this.notification = notification;
	}

	/**
	 * 获取androidConfig
	 * 
	 * @return
	 */
	public HwAndroidConfig getAndroidConfig()
	{
		return androidConfig;
	}

	/**
	 * 设置androidConfig
	 * 
	 * @param androidConfig
	 */
	public void setAndroidConfig(HwAndroidConfig androidConfig)
	{
		this.androidConfig = androidConfig;
	}

	/**
	 * 获取tokens
	 * 
	 * @return
	 */
	public Set<String> getTokens()
	{
		return tokens;
	}

	/**
	 * 设置tokens
	 * 
	 * @param tokens
	 */
	public void setTokens(Set<String> tokens)
	{
		this.tokens = tokens;
	}
}
