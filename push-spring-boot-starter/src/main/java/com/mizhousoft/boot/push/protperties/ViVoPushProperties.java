package com.mizhousoft.boot.push.protperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置
 *
 * @version
 */
@Component
@ConfigurationProperties(prefix = "push.vivo")
public class ViVoPushProperties
{
	// APP ID
	private int appId;

	// APP Key
	private String appKey;

	// APP secret
	private volatile String appSecret;

	// 是否测试环境
	private boolean sandbox;

	// intent格式
	private String intentFormat;

	/**
	 * 获取appId
	 * @return
	 */
	public int getAppId()
	{
		return appId;
	}

	/**
	 * 设置appId
	 * @param appId
	 */
	public void setAppId(int appId)
	{
		this.appId = appId;
	}

	/**
	 * 获取appKey
	 * @return
	 */
	public String getAppKey()
	{
		return appKey;
	}

	/**
	 * 设置appKey
	 * @param appKey
	 */
	public void setAppKey(String appKey)
	{
		this.appKey = appKey;
	}

	/**
	 * 获取appSecret
	 * @return
	 */
	public String getAppSecret()
	{
		return appSecret;
	}

	/**
	 * 设置appSecret
	 * @param appSecret
	 */
	public void setAppSecret(String appSecret)
	{
		this.appSecret = appSecret;
	}

	/**
	 * 获取sandbox
	 * @return
	 */
	public boolean isSandbox()
	{
		return sandbox;
	}

	/**
	 * 设置sandbox
	 * @param sandbox
	 */
	public void setSandbox(boolean sandbox)
	{
		this.sandbox = sandbox;
	}

	/**
	 * 获取intentFormat
	 * @return
	 */
	public String getIntentFormat()
	{
		return intentFormat;
	}

	/**
	 * 设置intentFormat
	 * @param intentFormat
	 */
	public void setIntentFormat(String intentFormat)
	{
		this.intentFormat = intentFormat;
	}
}
