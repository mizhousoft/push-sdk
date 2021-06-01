package com.mizhousoft.push.oppo.internal;

/**
 * 通知
 *
 * @version
 */
public class OppoNotification
{
	// App开发者自定义消息Id
	// OPPO推送平台根据此ID做去重处理，对于广播推送相同app_message_id只会保存一次，对于单推相同app_message_id只会推送一次。
	private String appMessageId;

	// 通知栏样式
	private Integer style;

	// 大图id【style为3时，必填】,可在大图上传接口获取
	private String bigPictureId;

	// 通知图标id,可在图标上传接口获取
	private String smallPictureId;

	// 设置在通知栏展示的通知栏标题, 【字数限制1~50，中英文均以一个计算】
	private String title;

	// 子标题，设置在通知栏展示的通知栏标题, 【字数限制1~10，中英文均以一个计算】
	private String subTitle;

	// 设置在通知栏展示的通知的内容,必填
	private String content;

	// 点击动作类型：
	private Integer clickActionType;

	// 应用内页地址【click_action_type为1/4/时必填，长度500】
	private String clickActionActivity;

	// 网页地址或【click_action_type为2与5时必填，长度500】
	private String clickActionUrl;

	// 动作参数，打开应用内页或网页时传递给应用或网页【JSON格式，非必填】，字符数不能超过4K
	private String actionParameters;

	// 展示类型
	private Integer showTimeType;

	// 定时展示开始时间（根据time_zone转换成当地时间），时间的毫秒数
	private Long showStartTime;

	// 定时展示结束时间（根据time_zone转换成当地时间），时间的毫秒数
	private Long showEndTime;

	// 是否进离线消息,【非必填，默认为True】
	private Boolean offLine;

	// 离线消息的存活时间(time_to_live) (单位：秒), 【最长10天】
	private Integer offLineTtl;

	// 定时推送 (0, “即时”),(1, “定时”), 【只对全部用户推送生效】
	private Integer pushTimeType = Integer.valueOf(0);

	// 定时推送开始时间（根据time_zone转换成当地时间）, 【push_time_type 为1必填】，时间的毫秒数
	private Long pushStartTime;

	// 时区，默认值：（GMT+08:00）北京，香港，新加坡
	private String timeZone;

	// 是否定速推送,【非必填，默认值为false】
	private Boolean fixSpeed;

	// 定速速率 【fixSpeed为true时，必填】
	private Long fixSpeedRate;

	// 0：不限联网方式, 1：仅wifi推送；
	private Integer networkType;

	// *仅支持registrationId推送方式*
	// 应用接收消息到达回执的回调URL，字数限制200以内，中英文均以一个计算。
	private String callBackUrl;

	// App开发者自定义回执参数，字数限制100以内，中英文均以一个计算。
	private String callBackParameter;

	// 通知栏通道（NotificationChannel），从Android9开始发送通知消息必须要指定通道Id（如果是快应用，必须带置顶的通道Id:OPPO PUSH推送）
	private String channelId;

	// 限时展示(单位：秒)，消息在通知栏展示后开始计时，到达填写的相对应时间后自动从通知栏消失，默认是1天。时间范围6 * 60 * 60 s -- 48 * 60 * 60 s
	private Integer showTtl;

	// 每条消息在通知显示时的唯一标识。不携带时，PUSH自动为给每条消息生成一个唯一标识；不同的通知栏消息可以拥有相同的notifyId，实现新的消息覆盖上一条消息功能。
	private Integer notifyId;

	/**
	 * 获取appMessageId
	 * 
	 * @return
	 */
	public String getAppMessageId()
	{
		return appMessageId;
	}

	/**
	 * 设置appMessageId
	 * 
	 * @param appMessageId
	 */
	public void setAppMessageId(String appMessageId)
	{
		this.appMessageId = appMessageId;
	}

	/**
	 * 获取style
	 * 
	 * @return
	 */
	public Integer getStyle()
	{
		return style;
	}

	/**
	 * 设置style
	 * 
	 * @param style
	 */
	public void setStyle(Integer style)
	{
		this.style = style;
	}

	/**
	 * 获取bigPictureId
	 * 
	 * @return
	 */
	public String getBigPictureId()
	{
		return bigPictureId;
	}

	/**
	 * 设置bigPictureId
	 * 
	 * @param bigPictureId
	 */
	public void setBigPictureId(String bigPictureId)
	{
		this.bigPictureId = bigPictureId;
	}

	/**
	 * 获取smallPictureId
	 * 
	 * @return
	 */
	public String getSmallPictureId()
	{
		return smallPictureId;
	}

	/**
	 * 设置smallPictureId
	 * 
	 * @param smallPictureId
	 */
	public void setSmallPictureId(String smallPictureId)
	{
		this.smallPictureId = smallPictureId;
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
	 * 获取subTitle
	 * 
	 * @return
	 */
	public String getSubTitle()
	{
		return subTitle;
	}

	/**
	 * 设置subTitle
	 * 
	 * @param subTitle
	 */
	public void setSubTitle(String subTitle)
	{
		this.subTitle = subTitle;
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
	 * 获取clickActionType
	 * 
	 * @return
	 */
	public Integer getClickActionType()
	{
		return clickActionType;
	}

	/**
	 * 设置clickActionType
	 * 
	 * @param clickActionType
	 */
	public void setClickActionType(Integer clickActionType)
	{
		this.clickActionType = clickActionType;
	}

	/**
	 * 获取clickActionActivity
	 * 
	 * @return
	 */
	public String getClickActionActivity()
	{
		return clickActionActivity;
	}

	/**
	 * 设置clickActionActivity
	 * 
	 * @param clickActionActivity
	 */
	public void setClickActionActivity(String clickActionActivity)
	{
		this.clickActionActivity = clickActionActivity;
	}

	/**
	 * 获取clickActionUrl
	 * 
	 * @return
	 */
	public String getClickActionUrl()
	{
		return clickActionUrl;
	}

	/**
	 * 设置clickActionUrl
	 * 
	 * @param clickActionUrl
	 */
	public void setClickActionUrl(String clickActionUrl)
	{
		this.clickActionUrl = clickActionUrl;
	}

	/**
	 * 获取actionParameters
	 * 
	 * @return
	 */
	public String getActionParameters()
	{
		return actionParameters;
	}

	/**
	 * 设置actionParameters
	 * 
	 * @param actionParameters
	 */
	public void setActionParameters(String actionParameters)
	{
		this.actionParameters = actionParameters;
	}

	/**
	 * 获取showTimeType
	 * 
	 * @return
	 */
	public Integer getShowTimeType()
	{
		return showTimeType;
	}

	/**
	 * 设置showTimeType
	 * 
	 * @param showTimeType
	 */
	public void setShowTimeType(Integer showTimeType)
	{
		this.showTimeType = showTimeType;
	}

	/**
	 * 获取showStartTime
	 * 
	 * @return
	 */
	public Long getShowStartTime()
	{
		return showStartTime;
	}

	/**
	 * 设置showStartTime
	 * 
	 * @param showStartTime
	 */
	public void setShowStartTime(Long showStartTime)
	{
		this.showStartTime = showStartTime;
	}

	/**
	 * 获取showEndTime
	 * 
	 * @return
	 */
	public Long getShowEndTime()
	{
		return showEndTime;
	}

	/**
	 * 设置showEndTime
	 * 
	 * @param showEndTime
	 */
	public void setShowEndTime(Long showEndTime)
	{
		this.showEndTime = showEndTime;
	}

	/**
	 * 获取offLine
	 * 
	 * @return
	 */
	public Boolean getOffLine()
	{
		return offLine;
	}

	/**
	 * 设置offLine
	 * 
	 * @param offLine
	 */
	public void setOffLine(Boolean offLine)
	{
		this.offLine = offLine;
	}

	/**
	 * 获取offLineTtl
	 * 
	 * @return
	 */
	public Integer getOffLineTtl()
	{
		return offLineTtl;
	}

	/**
	 * 设置offLineTtl
	 * 
	 * @param offLineTtl
	 */
	public void setOffLineTtl(Integer offLineTtl)
	{
		this.offLineTtl = offLineTtl;
	}

	/**
	 * 获取pushTimeType
	 * 
	 * @return
	 */
	public Integer getPushTimeType()
	{
		return pushTimeType;
	}

	/**
	 * 设置pushTimeType
	 * 
	 * @param pushTimeType
	 */
	public void setPushTimeType(Integer pushTimeType)
	{
		this.pushTimeType = pushTimeType;
	}

	/**
	 * 获取pushStartTime
	 * 
	 * @return
	 */
	public Long getPushStartTime()
	{
		return pushStartTime;
	}

	/**
	 * 设置pushStartTime
	 * 
	 * @param pushStartTime
	 */
	public void setPushStartTime(Long pushStartTime)
	{
		this.pushStartTime = pushStartTime;
	}

	/**
	 * 获取timeZone
	 * 
	 * @return
	 */
	public String getTimeZone()
	{
		return timeZone;
	}

	/**
	 * 设置timeZone
	 * 
	 * @param timeZone
	 */
	public void setTimeZone(String timeZone)
	{
		this.timeZone = timeZone;
	}

	/**
	 * 获取fixSpeed
	 * 
	 * @return
	 */
	public Boolean getFixSpeed()
	{
		return fixSpeed;
	}

	/**
	 * 设置fixSpeed
	 * 
	 * @param fixSpeed
	 */
	public void setFixSpeed(Boolean fixSpeed)
	{
		this.fixSpeed = fixSpeed;
	}

	/**
	 * 获取fixSpeedRate
	 * 
	 * @return
	 */
	public Long getFixSpeedRate()
	{
		return fixSpeedRate;
	}

	/**
	 * 设置fixSpeedRate
	 * 
	 * @param fixSpeedRate
	 */
	public void setFixSpeedRate(Long fixSpeedRate)
	{
		this.fixSpeedRate = fixSpeedRate;
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
	 * 获取callBackUrl
	 * 
	 * @return
	 */
	public String getCallBackUrl()
	{
		return callBackUrl;
	}

	/**
	 * 设置callBackUrl
	 * 
	 * @param callBackUrl
	 */
	public void setCallBackUrl(String callBackUrl)
	{
		this.callBackUrl = callBackUrl;
	}

	/**
	 * 获取callBackParameter
	 * 
	 * @return
	 */
	public String getCallBackParameter()
	{
		return callBackParameter;
	}

	/**
	 * 设置callBackParameter
	 * 
	 * @param callBackParameter
	 */
	public void setCallBackParameter(String callBackParameter)
	{
		this.callBackParameter = callBackParameter;
	}

	/**
	 * 获取channelId
	 * 
	 * @return
	 */
	public String getChannelId()
	{
		return channelId;
	}

	/**
	 * 设置channelId
	 * 
	 * @param channelId
	 */
	public void setChannelId(String channelId)
	{
		this.channelId = channelId;
	}

	/**
	 * 获取showTtl
	 * 
	 * @return
	 */
	public Integer getShowTtl()
	{
		return showTtl;
	}

	/**
	 * 设置showTtl
	 * 
	 * @param showTtl
	 */
	public void setShowTtl(Integer showTtl)
	{
		this.showTtl = showTtl;
	}

	/**
	 * 获取notifyId
	 * 
	 * @return
	 */
	public Integer getNotifyId()
	{
		return notifyId;
	}

	/**
	 * 设置notifyId
	 * 
	 * @param notifyId
	 */
	public void setNotifyId(Integer notifyId)
	{
		this.notifyId = notifyId;
	}
}
