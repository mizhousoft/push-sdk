package com.mizhousoft.push.huawei.internal.android;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * BadgeNotification
 * 发送消息同时设置应用角标数字，“class“必填，“add_num”和”set_num”参数选填。
 * 若“add_num”和“set_num”都设置为空，则应用角标数字默认加1。
 *
 * @version
 */
public class HwBadgeNotification
{
	// 应用角标累加数字非应用角标实际显示数字，为大于0小于100的整数。
	@JsonProperty("add_num")
	private Integer addNum;

	// 应用入口Activity类全路径。
	// 样例：com.example.hmstest.MainActivity
	@JsonProperty("class")
	private String badgeClass;

	// 角标设置数字，大于等于0小于100的整数。如果set_num与add_num同时存在时，以set_num为准。
	@JsonProperty("set_num")
	private Integer setNum;

	/**
	 * 获取addNum
	 * 
	 * @return
	 */
	public Integer getAddNum()
	{
		return addNum;
	}

	/**
	 * 设置addNum
	 * 
	 * @param addNum
	 */
	public void setAddNum(Integer addNum)
	{
		this.addNum = addNum;
	}

	/**
	 * 获取badgeClass
	 * 
	 * @return
	 */
	public String getBadgeClass()
	{
		return badgeClass;
	}

	/**
	 * 设置badgeClass
	 * 
	 * @param badgeClass
	 */
	public void setBadgeClass(String badgeClass)
	{
		this.badgeClass = badgeClass;
	}

	/**
	 * 获取setNum
	 * 
	 * @return
	 */
	public Integer getSetNum()
	{
		return setNum;
	}

	/**
	 * 设置setNum
	 * 
	 * @param setNum
	 */
	public void setSetNum(Integer setNum)
	{
		this.setNum = setNum;
	}
}
