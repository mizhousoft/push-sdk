package com.mizhousoft.push.apple.config;

import java.io.File;

import com.mizhousoft.push.ProviderProfile;
import com.mizhousoft.push.PushProvider;

/**
 * 配置
 *
 * @version
 */
public class AppleProfile extends ProviderProfile
{
	// TeamId
	private String teamId;

	// Keys Id
	private String keyId;

	// Keys 证书文件
	private File pkcs8File;

	// APP bundle identifier
	private String bundleIdentifier;

	// 是否测试环境
	private boolean sandbox;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PushProvider getPushProvider()
	{
		return PushProvider.APPLE;
	}

	/**
	 * 获取teamId
	 * 
	 * @return
	 */
	public String getTeamId()
	{
		return teamId;
	}

	/**
	 * 设置teamId
	 * 
	 * @param teamId
	 */
	public void setTeamId(String teamId)
	{
		this.teamId = teamId;
	}

	/**
	 * 获取keyId
	 * 
	 * @return
	 */
	public String getKeyId()
	{
		return keyId;
	}

	/**
	 * 设置keyId
	 * 
	 * @param keyId
	 */
	public void setKeyId(String keyId)
	{
		this.keyId = keyId;
	}

	/**
	 * 获取pkcs8File
	 * 
	 * @return
	 */
	public File getPkcs8File()
	{
		return pkcs8File;
	}

	/**
	 * 设置pkcs8File
	 * 
	 * @param pkcs8File
	 */
	public void setPkcs8File(File pkcs8File)
	{
		this.pkcs8File = pkcs8File;
	}

	/**
	 * 获取bundleIdentifier
	 * 
	 * @return
	 */
	public String getBundleIdentifier()
	{
		return bundleIdentifier;
	}

	/**
	 * 设置bundleIdentifier
	 * 
	 * @param bundleIdentifier
	 */
	public void setBundleIdentifier(String bundleIdentifier)
	{
		this.bundleIdentifier = bundleIdentifier;
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
