package com.mizhousoft.push.huawei.internal.message;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Notification
 *
 * @version
 */
public class HwNotification
{
	// 通知栏消息的标题
	@JsonProperty("title")
	private String title;

	// 通知栏消息的内容
	@JsonProperty("body")
	private String body;

	// 用户自定义的通知栏消息右侧大图标URL，如果不设置，则不展示通知栏右侧图标。
	// URL使用的协议必须是HTTPS协议，取值样例：https://example.com/image.png。
	// 图标文件须小于512KB，图标建议规格大小：40dp x 40dp，弧角大小为8dp，超出建议规格大小的图标会存在图片压缩或显示不全的情况。
	@JsonProperty("image")
	private String image;

	/**
	 * 获取title
	 * 
	 * @return
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * 设置title
	 * 
	 * @param title
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	/**
	 * 获取body
	 * 
	 * @return
	 */
	public String getBody()
	{
		return body;
	}

	/**
	 * 设置body
	 * 
	 * @param body
	 */
	public void setBody(String body)
	{
		this.body = body;
	}

	/**
	 * 获取image
	 * 
	 * @return
	 */
	public String getImage()
	{
		return image;
	}

	/**
	 * 设置image
	 * 
	 * @param image
	 */
	public void setImage(String image)
	{
		this.image = image;
	}
}
