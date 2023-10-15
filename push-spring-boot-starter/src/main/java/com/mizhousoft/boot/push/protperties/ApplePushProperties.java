package com.mizhousoft.boot.push.protperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 苹果推送配置
 *
 * @version
 */
@Component
@ConfigurationProperties(prefix = "push.apple")
public class ApplePushProperties
{
	// TeamId
	private String teamId;

	// Keys Id
	private volatile String keyId;

	// Keys 证书文件
	private String pkcs8File;

	// APP bundle identifier
	private String bundleIdentifier;

	// 是否测试环境
	private boolean sandbox;

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
	public String getPkcs8File()
	{
		return pkcs8File;
	}

	/**
	 * 设置pkcs8File
	 * 
	 * @param pkcs8File
	 */
	public void setPkcs8File(String pkcs8File)
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
