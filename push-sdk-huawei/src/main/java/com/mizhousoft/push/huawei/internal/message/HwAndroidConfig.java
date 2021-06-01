package com.mizhousoft.push.huawei.internal.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mizhousoft.push.huawei.internal.android.HwAndroidNotification;

/**
 * AndroidConfig
 *
 * @version
 */
public class HwAndroidConfig
{
	public static final String TTL_PATTERN = "\\d+|\\d+[sS]|\\d+.\\d{1,9}|\\d+.\\d{1,9}[sS]";

	// 用户设备离线时，Push服务器对离线消息缓存机制的控制方式，用户设备上线后缓存消息会再次下发
	@JsonProperty("collapse_key")
	private Integer collapseKey;

	// 透传消息投递优先级
	@JsonProperty("urgency")
	private String urgency;

	// 标识高优先级透传消息的特殊场景
	@JsonProperty("category")
	private String category;

	// 消息缓存时间，单位是秒。
	@JsonProperty("ttl")
	private String ttl;

	// 批量任务消息标识，消息回执时会返回给应用服务器，应用服务器可以识别bi_tag对消息的下发情况进行统计分析。
	@JsonProperty("bi_tag")
	private String biTag;

	// 快应用发送透传消息时，指定小程序的模式类型，小程序有两种模式开发态和生产态
	@JsonProperty("fast_app_target")
	private Integer fastAppTargetType;

	// 自定义消息负载，此处如果设置了data，则会覆盖message.data字段。
	@JsonProperty("data")
	private String data;

	// 安卓通知栏消息结构体
	@JsonProperty("notification")
	private HwAndroidNotification notification;

	/**
	 * 获取collapseKey
	 * 
	 * @return
	 */
	public Integer getCollapseKey()
	{
		return collapseKey;
	}

	/**
	 * 设置collapseKey
	 * 
	 * @param collapseKey
	 */
	public void setCollapseKey(Integer collapseKey)
	{
		this.collapseKey = collapseKey;
	}

	/**
	 * 获取urgency
	 * 
	 * @return
	 */
	public String getUrgency()
	{
		return urgency;
	}

	/**
	 * 设置urgency
	 * 
	 * @param urgency
	 */
	public void setUrgency(String urgency)
	{
		this.urgency = urgency;
	}

	/**
	 * 获取category
	 * 
	 * @return
	 */
	public String getCategory()
	{
		return category;
	}

	/**
	 * 设置category
	 * 
	 * @param category
	 */
	public void setCategory(String category)
	{
		this.category = category;
	}

	/**
	 * 获取ttl
	 * 
	 * @return
	 */
	public String getTtl()
	{
		return ttl;
	}

	/**
	 * 设置ttl
	 * 
	 * @param ttl
	 */
	public void setTtl(String ttl)
	{
		this.ttl = ttl;
	}

	/**
	 * 获取biTag
	 * 
	 * @return
	 */
	public String getBiTag()
	{
		return biTag;
	}

	/**
	 * 设置biTag
	 * 
	 * @param biTag
	 */
	public void setBiTag(String biTag)
	{
		this.biTag = biTag;
	}

	/**
	 * 获取fastAppTargetType
	 * 
	 * @return
	 */
	public Integer getFastAppTargetType()
	{
		return fastAppTargetType;
	}

	/**
	 * 设置fastAppTargetType
	 * 
	 * @param fastAppTargetType
	 */
	public void setFastAppTargetType(Integer fastAppTargetType)
	{
		this.fastAppTargetType = fastAppTargetType;
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

	/**
	 * 获取notification
	 * 
	 * @return
	 */
	public HwAndroidNotification getNotification()
	{
		return notification;
	}

	/**
	 * 设置notification
	 * 
	 * @param notification
	 */
	public void setNotification(HwAndroidNotification notification)
	{
		this.notification = notification;
	}
}
