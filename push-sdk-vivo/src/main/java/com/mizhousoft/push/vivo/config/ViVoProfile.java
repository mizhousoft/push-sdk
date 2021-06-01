package com.mizhousoft.push.vivo.config;

import com.mizhousoft.push.ProviderProfile;
import com.mizhousoft.push.PushProvider;

/**
 * 配置
 *
 * @version
 */
public class ViVoProfile extends ProviderProfile
{
	// APP ID
	private int appId;

	// APP Key
	private String appKey;

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
		return PushProvider.VIVO;
	}

	/**
	 * 获取appId
	 * 
	 * @return
	 */
	public int getAppId()
	{
		return appId;
	}

	/**
	 * 设置appId
	 * 
	 * @param appId
	 */
	public void setAppId(int appId)
	{
		this.appId = appId;
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
