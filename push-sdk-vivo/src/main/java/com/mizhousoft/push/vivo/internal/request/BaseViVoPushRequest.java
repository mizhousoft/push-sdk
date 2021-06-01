package com.mizhousoft.push.vivo.internal.request;

import java.util.Map;

/**
 * 推送请求
 *
 * @version
 */
public class BaseViVoPushRequest
{
	// 通知类型
	private int notifyType;

	// 通知标题（用于通知栏消息） 最大20个汉字（一个汉字等于两个英文字符，即最大不超过40个英文字符）
	private String title;

	// 通知内容（用于通知栏消息） 最大50个汉字（一个汉字等于两个英文字符，即最大不超过100个英文字符）
	private String content;

	// 消息保留时长 单位：秒，取值至少60秒，最长7天。当值为空时，默认一天
	private Integer timeToLive;

	// 点击跳转类型 1：打开APP首页 2：打开链接 3：自定义 4:打开app内指定页面
	private int skipType;

	// 跳转内容
	// 跳转类型为2时，跳转内容最大1000个字符，跳转类型为3或4时，跳转内容最大1024个字符，skipType传3需要在onNotificationMessageClicked回调函数中自己写处理逻辑。
	private String skipContent;

	// 网络方式 -1：不限，1：wifi下发送，不填默认为-1
	private Integer networkType;

	// 客户端自定义键值对 自定义key和Value键值对个数不能超过10个，且长度不能超过1024字符,
	// key和Value键值对总长度不能超过1024字符。app可以按照客户端SDK接入文档获取该键值对
	private Map<String, String> clientCustomMap;

	// 用户请求唯一标识 最大64字符
	private String requestId;

	// 消息类型 0：运营类消息，1：系统类消息。不填默认为0
	private Integer classification;

	/**
	 * 获取notifyType
	 * 
	 * @return
	 */
	public int getNotifyType()
	{
		return notifyType;
	}

	/**
	 * 设置notifyType
	 * 
	 * @param notifyType
	 */
	public void setNotifyType(int notifyType)
	{
		this.notifyType = notifyType;
	}

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
	 * 获取content
	 * 
	 * @return
	 */
	public String getContent()
	{
		return content;
	}

	/**
	 * 设置content
	 * 
	 * @param content
	 */
	public void setContent(String content)
	{
		this.content = content;
	}

	/**
	 * 获取timeToLive
	 * 
	 * @return
	 */
	public Integer getTimeToLive()
	{
		return timeToLive;
	}

	/**
	 * 设置timeToLive
	 * 
	 * @param timeToLive
	 */
	public void setTimeToLive(Integer timeToLive)
	{
		this.timeToLive = timeToLive;
	}

	/**
	 * 获取skipType
	 * 
	 * @return
	 */
	public int getSkipType()
	{
		return skipType;
	}

	/**
	 * 设置skipType
	 * 
	 * @param skipType
	 */
	public void setSkipType(int skipType)
	{
		this.skipType = skipType;
	}

	/**
	 * 获取skipContent
	 * 
	 * @return
	 */
	public String getSkipContent()
	{
		return skipContent;
	}

	/**
	 * 设置skipContent
	 * 
	 * @param skipContent
	 */
	public void setSkipContent(String skipContent)
	{
		this.skipContent = skipContent;
	}

	/**
	 * 获取networkType
	 * 
	 * @return
	 */
	public Integer getNetworkType()
	{
		return networkType;
	}

	/**
	 * 设置networkType
	 * 
	 * @param networkType
	 */
	public void setNetworkType(Integer networkType)
	{
		this.networkType = networkType;
	}

	/**
	 * 获取clientCustomMap
	 * 
	 * @return
	 */
	public Map<String, String> getClientCustomMap()
	{
		return clientCustomMap;
	}

	/**
	 * 设置clientCustomMap
	 * 
	 * @param clientCustomMap
	 */
	public void setClientCustomMap(Map<String, String> clientCustomMap)
	{
		this.clientCustomMap = clientCustomMap;
	}

	/**
	 * 获取requestId
	 * 
	 * @return
	 */
	public String getRequestId()
	{
		return requestId;
	}

	/**
	 * 设置requestId
	 * 
	 * @param requestId
	 */
	public void setRequestId(String requestId)
	{
		this.requestId = requestId;
	}

	/**
	 * 获取classification
	 * 
	 * @return
	 */
	public Integer getClassification()
	{
		return classification;
	}

	/**
	 * 设置classification
	 * 
	 * @param classification
	 */
	public void setClassification(Integer classification)
	{
		this.classification = classification;
	}
}
