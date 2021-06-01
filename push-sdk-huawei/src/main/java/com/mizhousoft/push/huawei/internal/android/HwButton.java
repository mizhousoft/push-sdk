package com.mizhousoft.push.huawei.internal.android;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Button
 *
 * @version
 */
public class HwButton
{
	// 按钮名称，最大长度40。
	@JsonProperty("name")
	private String name;

	// 按钮动作类型
	@JsonProperty("action_type")
	private Integer actionType;

	// 打开自定义页面的方式
	@JsonProperty("intent_type")
	private Integer intentType;

	// 当action_type为1，此字段按照intent_type字段设置应用页面的uri或者action
	// 当action_type为2，此字段设置打开指定网页的URL，URL使用的协议必须是HTTPS协议
	@JsonProperty("intent")
	private String intent;

	// 最大长度1024。当字段action_type为0或1时，该字段用于在点击按钮后给应用透传数据，选填，
	// 格式必须为key-value形式：{"key1":"value1","key2":"value2",…}。
	// 当action_type为4时，此字段必选，为分享的内容。
	@JsonProperty("data")
	private String data;

	/**
	 * 获取name
	 * 
	 * @return
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * 设置name
	 * 
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * 获取actionType
	 * 
	 * @return
	 */
	public Integer getActionType()
	{
		return actionType;
	}

	/**
	 * 设置actionType
	 * 
	 * @param actionType
	 */
	public void setActionType(Integer actionType)
	{
		this.actionType = actionType;
	}

	/**
	 * 获取intentType
	 * 
	 * @return
	 */
	public Integer getIntentType()
	{
		return intentType;
	}

	/**
	 * 设置intentType
	 * 
	 * @param intentType
	 */
	public void setIntentType(Integer intentType)
	{
		this.intentType = intentType;
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
	 * 获取data
	 * 
	 * @return
	 */
	public String getData()
	{
		return data;
	}

	/**
	 * 设置data
	 * 
	 * @param data
	 */
	public void setData(String data)
	{
		this.data = data;
	}

}
