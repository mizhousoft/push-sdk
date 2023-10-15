package com.mizhousoft.boot.push.protperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置
 *
 * @version
 */
@Component
@ConfigurationProperties(prefix = "push.oppo")
public class OppoPushProperties
{
	// appKey
	private String appKey;

	// masterSecret
	private volatile String masterSecret;

	// intent格式
	private String intentFormat;

	/**
	 * 获取appKey
	 * 
	 * @return
	 */
	public String getAppKey()
	{
		return appKey;
	}

	/**
	 * 设置appKey
	 * 
	 * @param appKey
	 */
	public void setAppKey(String appKey)
	{
		this.appKey = appKey;
	}

	/**
	 * 获取masterSecret
	 * 
	 * @return
	 */
	public String getMasterSecret()
	{
		return masterSecret;
	}

	/**
	 * 设置masterSecret
	 * 
	 * @param masterSecret
	 */
	public void setMasterSecret(String masterSecret)
	{
		this.masterSecret = masterSecret;
	}

	/**
	 * 获取intentFormat
	 * 
	 * @return
	 */
	public String getIntentFormat()
	{
		return intentFormat;
	}

	/**
	 * 设置intentFormat
	 * 
	 * @param intentFormat
	 */
	public void setIntentFormat(String intentFormat)
	{
		this.intentFormat = intentFormat;
	}
}
