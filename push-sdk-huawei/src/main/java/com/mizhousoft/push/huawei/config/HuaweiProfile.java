package com.mizhousoft.push.huawei.config;

import com.mizhousoft.push.ProviderProfile;
import com.mizhousoft.push.PushProvider;

/**
 * 配置
 *
 * @version
 */
public class HuaweiProfile extends ProviderProfile
{
	// appId
	private String appId;

	// appSecret
	private String appSecret;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PushProvider getPushProvider()
	{
		return PushProvider.HUAWEI;
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
}
