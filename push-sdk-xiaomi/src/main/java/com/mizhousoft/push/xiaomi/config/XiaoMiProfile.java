package com.mizhousoft.push.xiaomi.config;

import com.mizhousoft.push.ProviderProfile;
import com.mizhousoft.push.PushProvider;

/**
 * 配置
 *
 * @version
 */
public class XiaoMiProfile extends ProviderProfile
{
	// APP ID
	private String appId;

	// APP secret
	private String appSecret;

	// App的包名，多个以英文逗号拼接
	private String packageNames;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PushProvider getPushProvider()
	{
		return PushProvider.XIAOMI;
	}

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
