package com.mizhousoft.push.umeng.config;

import com.mizhousoft.push.ProviderProfile;
import com.mizhousoft.push.PushProvider;

/**
 * 配置
 *
 * @version
 */
public class UMengProfile extends ProviderProfile
{
	// APP ID
	private String appId;

	// APP secret
	private String appSecret;

	// 是否测试环境
	private boolean sandbox;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PushProvider getPushProvider()
	{
		return PushProvider.UMENG;
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
	 * 获取sandbox
	 * 
	 * @return
	 */
	public boolean isSandbox()
	{
		return sandbox;
	}

	/**
	 * 设置sandbox
	 * 
	 * @param sandbox
	 */
	public void setSandbox(boolean sandbox)
	{
		this.sandbox = sandbox;
	}
}
