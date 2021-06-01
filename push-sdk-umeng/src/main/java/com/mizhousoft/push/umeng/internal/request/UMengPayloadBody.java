package com.mizhousoft.push.umeng.internal.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Payload Body
 *
 * @version
 */
public class UMengPayloadBody
{
	// 必填，通知标题
	@JsonProperty("title")
	private String title;

	// 必填，通知文字描述
	@JsonProperty("text")
	private String text;

	// 自定义通知图标:
	// 可选，状态栏图标ID，R.drawable.[smallIcon]，
	// 如果没有，默认使用应用图标
	// 图片要求为24*24dp的图标，或24*24px放在drawable-mdpi下
	// 注意四周各留1个dp的空白像素
	@JsonProperty("icon")
	private String icon;

	// 可选，通知栏拉开后左侧图标ID，R.drawable.[largeIcon]
	// 图片要求为64*64dp的图标
	// 可设计一张64*64px放在drawable-mdpi下
	// 注意图片四周留空，不至于显示太拥挤
	@JsonProperty("largeIcon")
	private String largeIcon;

	// 可选，通知栏大图标的URL链接。该字段的优先级大于largeIcon
	// 厂商通道消息，目前只支持华为，链接需要以https开头不符合此要求则通过华为通道下发时不展示该图标。[华为推送](https://developer.huawei.com/consumer/cn/doc/development/HMSCore-References-V5/https-send-api-0000001050986197-V5#ZH-CN_TOPIC_0000001050986197__section165641411103315
	// "华为推送")搜索“图片”即可找到关于该参数的说明
	// 该字段要求以http或者https开头，图片建议不大于100KB。
	@JsonProperty("img")
	private String img;

	// 消息下方展示大图，支持自有通道消息展示
	// 厂商通道展示大图目前仅支持小米,要求图片为固定876*324px,仅处理在友盟推送后台上传的图片。如果上传的图片不符合小米的要求，则通过小米通道下发的消息不展示该图片，其他要求请参考小米推送文档[小米富媒体推送](https://dev.mi.com/console/doc/detail?pId=1278#_3_3
	// "小米富媒体推送")
	@JsonProperty("expand_image")
	private String expandImage;

	// 自定义通知声音:
	// 可选，通知声音，R.raw.[sound]
	// 如果该字段为空，采用SDK默认的声音，即res/raw/下的
	// umeng_push_notification_default_sound声音文件。如果SDK默认声音文件不存在，则使用系统默认Notification提示音
	@JsonProperty("sound")
	private String sound;

	// 自定义通知样式:
	// 可选，默认为0，用于标识该通知采用的样式。使用该参数时
	// 开发者必须在SDK里面实现自定义通知栏样式
	@JsonProperty("builder_id")
	private String builderId;

	// 通知到达设备后的提醒方式(注意，"true/false"为字符串):
	// 可选，收到通知是否震动，默认为"true"
	@JsonProperty("play_vibrate")
	private String playVibrate;

	// 可选，收到通知是否闪灯，默认为"true"
	@JsonProperty("play_lights")
	private String playLights;

	// 可选，收到通知是否发出声音，默认为"true"
	@JsonProperty("play_sound")
	private String playSound;

	// 点击"通知"的后续行为(默认为打开app):
	// 可选，默认为"go_app"，值可以为:
	// "go_app":打开应用
	// "go_url":跳转到URL
	// "go_activity":打开特定的activity
	// "go_custom":用户自定义内容
	@JsonProperty("after_open")
	private String afterOpen;

	// 当after_open=go_url时，必填
	// 通知栏点击后跳转的URL，要求以http或者https开头
	@JsonProperty("url")
	private String url;

	// 当after_open=go_activity时，必填。
	// 通知栏点击后打开的Activity
	@JsonProperty("activity")
	private String activity;

	// 当display_type=message时,必填
	// 当display_type=notification且after_open=go_custom时，必填
	// 用户自定义内容，可以为字符串或者JSON格式。
	@JsonProperty("custom")
	private String custom;

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
	 * 获取text
	 * 
	 * @return
	 */
	public String getText()
	{
		return text;
	}

	/**
	 * 设置text
	 * 
	 * @param text
	 */
	public void setText(String text)
	{
		this.text = text;
	}

	/**
	 * 获取icon
	 * 
	 * @return
	 */
	public String getIcon()
	{
		return icon;
	}

	/**
	 * 设置icon
	 * 
	 * @param icon
	 */
	public void setIcon(String icon)
	{
		this.icon = icon;
	}

	/**
	 * 获取largeIcon
	 * 
	 * @return
	 */
	public String getLargeIcon()
	{
		return largeIcon;
	}

	/**
	 * 设置largeIcon
	 * 
	 * @param largeIcon
	 */
	public void setLargeIcon(String largeIcon)
	{
		this.largeIcon = largeIcon;
	}

	/**
	 * 获取img
	 * 
	 * @return
	 */
	public String getImg()
	{
		return img;
	}

	/**
	 * 设置img
	 * 
	 * @param img
	 */
	public void setImg(String img)
	{
		this.img = img;
	}

	/**
	 * 获取expandImage
	 * 
	 * @return
	 */
	public String getExpandImage()
	{
		return expandImage;
	}

	/**
	 * 设置expandImage
	 * 
	 * @param expandImage
	 */
	public void setExpandImage(String expandImage)
	{
		this.expandImage = expandImage;
	}

	/**
	 * 获取sound
	 * 
	 * @return
	 */
	public String getSound()
	{
		return sound;
	}

	/**
	 * 设置sound
	 * 
	 * @param sound
	 */
	public void setSound(String sound)
	{
		this.sound = sound;
	}

	/**
	 * 获取builderId
	 * 
	 * @return
	 */
	public String getBuilderId()
	{
		return builderId;
	}

	/**
	 * 设置builderId
	 * 
	 * @param builderId
	 */
	public void setBuilderId(String builderId)
	{
		this.builderId = builderId;
	}

	/**
	 * 获取playVibrate
	 * 
	 * @return
	 */
	public String getPlayVibrate()
	{
		return playVibrate;
	}

	/**
	 * 设置playVibrate
	 * 
	 * @param playVibrate
	 */
	public void setPlayVibrate(String playVibrate)
	{
		this.playVibrate = playVibrate;
	}

	/**
	 * 获取playLights
	 * 
	 * @return
	 */
	public String getPlayLights()
	{
		return playLights;
	}

	/**
	 * 设置playLights
	 * 
	 * @param playLights
	 */
	public void setPlayLights(String playLights)
	{
		this.playLights = playLights;
	}

	/**
	 * 获取playSound
	 * 
	 * @return
	 */
	public String getPlaySound()
	{
		return playSound;
	}

	/**
	 * 设置playSound
	 * 
	 * @param playSound
	 */
	public void setPlaySound(String playSound)
	{
		this.playSound = playSound;
	}

	/**
	 * 获取afterOpen
	 * 
	 * @return
	 */
	public String getAfterOpen()
	{
		return afterOpen;
	}

	/**
	 * 设置afterOpen
	 * 
	 * @param afterOpen
	 */
	public void setAfterOpen(String afterOpen)
	{
		this.afterOpen = afterOpen;
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
	 * 获取activity
	 * 
	 * @return
	 */
	public String getActivity()
	{
		return activity;
	}

	/**
	 * 设置activity
	 * 
	 * @param activity
	 */
	public void setActivity(String activity)
	{
		this.activity = activity;
	}

	/**
	 * 获取custom
	 * 
	 * @return
	 */
	public String getCustom()
	{
		return custom;
	}

	/**
	 * 设置custom
	 * 
	 * @param custom
	 */
	public void setCustom(String custom)
	{
		this.custom = custom;
	}
}
