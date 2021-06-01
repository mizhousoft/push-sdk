package com.mizhousoft.push.huawei.internal.android;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * LightSettings
 *
 * @version
 */
public class HwLightSettings
{
	public static final String LIGTH_DURATION_PATTERN = "\\d+|\\d+[sS]|\\d+.\\d{1,9}|\\d+.\\d{1,9}[sS]";

	// 呼吸灯颜色，当设置light_settings时，该字段必选。具体字段请参见Color结构体的定义。
	@JsonProperty("color")
	private HwColor color;

	// 呼吸灯点亮时间间隔，当设置light_settings时，该字段必选，格式按照“\d+|\d+[sS]|\d+.\d{1,9}|\d+.\d{1,9}[sS]”。
	@JsonProperty("light_on_duration")
	private String lightOnDuration;

	// 呼吸灯熄灭时间间隔，当设置light_settings时，该字段必选，格式按照“\d+|\d+[sS]|\d+.\d{1,9}|\d+.\d{1,9}[sS]”。
	@JsonProperty("light_off_duration")
	private String lightOffDuration;

	/**
	 * 获取color
	 * 
	 * @return
	 */
	public HwColor getColor()
	{
		return color;
	}

	/**
	 * 设置color
	 * 
	 * @param color
	 */
	public void setColor(HwColor color)
	{
		this.color = color;
	}

	/**
	 * 获取lightOnDuration
	 * 
	 * @return
	 */
	public String getLightOnDuration()
	{
		return lightOnDuration;
	}

	/**
	 * 设置lightOnDuration
	 * 
	 * @param lightOnDuration
	 */
	public void setLightOnDuration(String lightOnDuration)
	{
		this.lightOnDuration = lightOnDuration;
	}

	/**
	 * 获取lightOffDuration
	 * 
	 * @return
	 */
	public String getLightOffDuration()
	{
		return lightOffDuration;
	}

	/**
	 * 设置lightOffDuration
	 * 
	 * @param lightOffDuration
	 */
	public void setLightOffDuration(String lightOffDuration)
	{
		this.lightOffDuration = lightOffDuration;
	}
}
