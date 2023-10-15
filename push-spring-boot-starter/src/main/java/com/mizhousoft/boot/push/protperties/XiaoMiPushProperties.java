package com.mizhousoft.boot.push.protperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置
 *
 * @version
 */
@Component
@ConfigurationProperties(prefix = "push.xiaomi")
public class XiaoMiPushProperties
{
	// APP ID
	private String appId;

	// APP secret
	private volatile String appSecret;

	// intent格式
	private String intentFormat;

	// App的包名，多个以英文逗号拼接
	private String packageNames;

	/**
	 * 获取appId
	 * 
	 * @return
	 */
	public String getAppId()
	{
		return appId;
	}

	/**
	 * 设置appId
	 * 
	 * @param appId
	 */
	public void setAppId(String appId)
	{
		this.appId = appId;
	}

	/**
	 * 获取appSecret
	 * 
	 * @return
	 */
	public String getAppSecret()
	{
		return appSecret;
	}

	/**
	 * 设置appSecret
	 * 
	 * @param appSecret
	 */
	public void setAppSecret(String appSecret)
	{
		this.appSecret = appSecret;
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

	/**
	 * 获取packageNames
	 * 
	 * @return
	 */
	public String getPackageNames()
	{
		return packageNames;
	}

	/**
	 * 设置packageNames
	 * 
	 * @param packageNames
	 */
	public void setPackageNames(String packageNames)
	{
		this.packageNames = packageNames;
	}
}
