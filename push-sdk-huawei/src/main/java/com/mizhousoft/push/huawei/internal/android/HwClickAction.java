package com.mizhousoft.push.huawei.internal.android;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ClickAction
 *
 * @version
 */
public class HwClickAction
{
	public static final String PATTERN = "^https.*";

	// 消息点击行为类型
	@JsonProperty("type")
	private Integer type;

	// 自定义页面中intent的实现
	@JsonProperty("intent")
	private String intent;

	// 设置打开特定URL，本字段填写需要打开的URL，URL使用的协议必须是HTTPS协议
	@JsonProperty("url")
	private String url;

	// 设置通过action打开应用自定义页面时，本字段填写要打开的页面activity对应的action。
	@JsonProperty("action")
	private String action;

	/**
	 * 获取type
	 * 
	 * @return
	 */
	public Integer getType()
	{
		return type;
	}

	/**
	 * 设置type
	 * 
	 * @param type
	 */
	public void setType(Integer type)
	{
		this.type = type;
	}

	/**
	 * 获取intent
	 * 
	 * @return
	 */
	public String getIntent()
	{
		return intent;
	}

	/**
	 * 设置intent
	 * 
	 * @param intent
	 */
	public void setIntent(String intent)
	{
		this.intent = intent;
	}

	/**
	 * 获取url
	 * 
	 * @return
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * 设置url
	 * 
	 * @param url
	 */
	public void setUrl(String url)
	{
		this.url = url;
	}

	/**
	 * 获取action
	 * 
	 * @return
	 */
	public String getAction()
	{
		return action;
	}

	/**
	 * 设置action
	 * 
	 * @param action
	 */
	public void setAction(String action)
	{
		this.action = action;
	}
}
