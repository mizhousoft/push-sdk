package com.mizhousoft.push.oppo.config;

import com.mizhousoft.push.ProviderProfile;
import com.mizhousoft.push.PushProvider;

/**
 * 配置
 *
 * @version
 */
public class OppoProfile extends ProviderProfile
{
	// appKey
	private String appKey;

	// masterSecret
	private volatile String masterSecret;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PushProvider getPushProvider()
	{
		return PushProvider.OPPO;
	}

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
}
