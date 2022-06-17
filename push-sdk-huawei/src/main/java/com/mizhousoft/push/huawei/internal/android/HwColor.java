package com.mizhousoft.push.huawei.internal.android;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Color
 *
 * @version
 */
public class HwColor
{
	// RGB颜色中的alpha设置，默认值为1，取值范围[0,1]。
	@JsonProperty("alpha")
	private Float alpha = Float.valueOf(1.0f);

	// RGB颜色中的red设置，默认值为0，取值范围[0,1]。
	@JsonProperty("red")
	private Float red = Float.valueOf(0.0f);

	// RGB颜色中的green设置，默认值为0，取值范围[0,1]。
	@JsonProperty("green")
	private Float green = Float.valueOf(0.0f);

	// RGB颜色中的blue设置，默认值为0，取值范围[0,1]。
	@JsonProperty("blue")
	private Float blue = Float.valueOf(0.0f);

	/**
	 * 获取alpha
	 * 
	 * @return
	 */
	public Float getAlpha()
	{
		return alpha;
	}

	/**
	 * 设置alpha
	 * 
	 * @param alpha
	 */
	public void setAlpha(Float alpha)
	{
		this.alpha = alpha;
	}

	/**
	 * 获取red
	 * 
	 * @return
	 */
	public Float getRed()
	{
		return red;
	}

	/**
	 * 设置red
	 * 
	 * @param red
	 */
	public void setRed(Float red)
	{
		this.red = red;
	}

	/**
	 * 获取green
	 * 
	 * @return
	 */
	public Float getGreen()
	{
		return green;
	}

	/**
	 * 设置green
	 * 
	 * @param green
	 */
	public void setGreen(Float green)
	{
		this.green = green;
	}

	/**
	 * 获取blue
	 * 
	 * @return
	 */
	public Float getBlue()
	{
		return blue;
	}

	/**
	 * 设置blue
	 * 
	 * @param blue
	 */
	public void setBlue(Float blue)
	{
		this.blue = blue;
	}
}
