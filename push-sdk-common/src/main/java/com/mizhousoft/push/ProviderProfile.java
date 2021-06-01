package com.mizhousoft.push;

/**
 * 供应商配置
 *
 * @version
 */
public abstract class ProviderProfile
{
	// intent格式
	protected String intentFormat;

	public abstract PushProvider getPushProvider();

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
