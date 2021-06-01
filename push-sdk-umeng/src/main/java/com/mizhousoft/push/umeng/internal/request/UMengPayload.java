package com.mizhousoft.push.umeng.internal.request;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Payload
 *
 * @version
 */
public class UMengPayload
{
	// 必填，消息类型: notification(通知)、message(消息)
	@JsonProperty("displayType")
	private String displayType;

	// 必填，消息体
	// 当display_type=message时，body的内容只需填写custom字段
	// 当display_type=notification时，body包含如下参数:
	@JsonProperty("body")
	private UMengPayloadBody body;

	// 可选，JSON格式，用户自定义key-value。
	// 可以配合消息到达后，打开App/URL/Activity使用
	@JsonProperty("extra")
	private Map<String, String> extra;

	/**
	 * 获取displayType
	 * 
	 * @return
	 */
	public String getDisplayType()
	{
		return displayType;
	}

	/**
	 * 设置displayType
	 * 
	 * @param displayType
	 */
	public void setDisplayType(String displayType)
	{
		this.displayType = displayType;
	}

	/**
	 * 获取body
	 * 
	 * @return
	 */
	public UMengPayloadBody getBody()
	{
		return body;
	}

	/**
	 * 设置body
	 * 
	 * @param body
	 */
	public void setBody(UMengPayloadBody body)
	{
		this.body = body;
	}

	/**
	 * 获取extra
	 * 
	 * @return
	 */
	public Map<String, String> getExtra()
	{
		return extra;
	}

	/**
	 * 设置extra
	 * 
	 * @param extra
	 */
	public void setExtra(Map<String, String> extra)
	{
		this.extra = extra;
	}
}
