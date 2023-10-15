package com.mizhousoft.boot.push.protperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置
 *
 * @version
 */
@Component
@ConfigurationProperties(prefix = "push.huawei")
public class HauweiPushProperties
{
	// appId
	private String appId;

	// appSecret
	private volatile String appSecret;

	// intent格式
	private String intentFormat;

	/**
	 * 获取appId
	 * @return
	 */
	public String getAppId()
	{
		return appId;
	}

	/**
	 * 设置appId
	 * @param appId
	 */
	public void setAppId(String appId)
	{
		this.appId = appId;
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
