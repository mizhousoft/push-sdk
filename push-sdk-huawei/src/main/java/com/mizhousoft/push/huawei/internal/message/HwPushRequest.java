package com.mizhousoft.push.huawei.internal.message;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 推送请求
 *
 * @version
 */
public class HwPushRequest
{
	// 控制当前是否为测试消息，测试消息只做格式合法性校验，不会推送给用户设备
	@JsonProperty("validate_only")
	private boolean validateOnly;

	@JsonProperty("message")
	private HwMessage message;

	/**
	 * 获取validateOnly
	 * 
	 * @return
	 */
	public boolean isValidateOnly()
	{
		return validateOnly;
	}

	/**
	 * 设置validateOnly
	 * 
	 * @param validateOnly
	 */
	public void setValidateOnly(boolean validateOnly)
	{
		this.validateOnly = validateOnly;
	}

	/**
	 * 获取message
	 * 
	 * @return
	 */
	public HwMessage getMessage()
	{
		return message;
	}

	/**
	 * 设置message
	 * 
	 * @param message
	 */
	public void setMessage(HwMessage message)
	{
		this.message = message;
	}
}
