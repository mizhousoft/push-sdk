package com.mizhousoft.push.xiaomi.internal.request;

/**
 * 消息请求
 *
 * @version
 */
public class MiMessageRequest
{
	public static final String PAYLOAD = "payload";

	public static final String RESTRICTED_PACKAGE_NAME = "restricted_package_name";

	public static final String PASS_THROUGH = "pass_through";

	public static final String TITLE = "title";

	public static final String DESCRIPTION = "description";

	public static final String NOTIFY_TYPE = "notify_type";

	public static final String TIME_TO_LIVE = "time_to_live";

	public static final String TIME_TO_SEND = "time_to_send";

	public static final String NOTIFY_ID = "notify_id";

	public static final String REGISTRATION_ID = "registration_id";

	// 消息的内容。（注意：需要对payload字符串做urlencode处理）
	private String payload;

	// App的包名。备注：V2版本支持一个包名，V3版本支持多包名（中间用逗号分割）。
	private String restrictedPackageNames;

	// 消息类型
	private Integer passThrough;

	// 通知栏展示的通知的标题，不允许全是空白字符，长度小于50，
	private String title;

	// 通知栏展示的通知的描述，不允许全是空白字符，长度小于128
	private String description;

	// 通知类型
	private Integer notifyType;

	// 可选项。如果用户离线，设置消息在服务器保存的时间，单位：ms。服务器默认最长保留两周。
	private Long timeToLive;

	// 可选项。定时发送消息。用自1970年1月1日以来00:00:00.0 UTC时间表示（以毫秒为单位的时间）。注：仅支持七天内的定时消息。
	private Long timeToSend;

	// 可选项。默认情况下，通知栏只显示一条推送消息。
	// 如果通知栏要显示多条推送消息，需要针对不同的消息设置不同的notify_id（相同notify_id的通知栏消息会覆盖之前的）。
	private Integer notifyId;

	// 根据registration_id，发送消息到指定设备上。
	// 可以提供多个registration_id，发送给一组设备，不同的registration_id之间用“,”分割。
	private String regId;

	// 扩展信息
	private MiMessageExtra extra;

	/**
	 * 获取payload
	 * 
	 * @return
	 */
	public String getPayload()
	{
		return payload;
	}

	/**
	 * 设置payload
	 * 
	 * @param payload
	 */
	public void setPayload(String payload)
	{
		this.payload = payload;
	}

	/**
	 * 获取restrictedPackageNames
	 * 
	 * @return
	 */
	public String getRestrictedPackageNames()
	{
		return restrictedPackageNames;
	}

	/**
	 * 设置restrictedPackageNames
	 * 
	 * @param restrictedPackageNames
	 */
	public void setRestrictedPackageNames(String restrictedPackageNames)
	{
		this.restrictedPackageNames = restrictedPackageNames;
	}

	/**
	 * 获取passThrough
	 * 
	 * @return
	 */
	public Integer getPassThrough()
	{
		return passThrough;
	}

	/**
	 * 设置passThrough
	 * 
	 * @param passThrough
	 */
	public void setPassThrough(Integer passThrough)
	{
		this.passThrough = passThrough;
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
	 * 获取description
	 * 
	 * @return
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * 设置description
	 * 
	 * @param description
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * 获取notifyType
	 * 
	 * @return
	 */
	public Integer getNotifyType()
	{
		return notifyType;
	}

	/**
	 * 设置notifyType
	 * 
	 * @param notifyType
	 */
	public void setNotifyType(Integer notifyType)
	{
		this.notifyType = notifyType;
	}

	/**
	 * 获取timeToLive
	 * 
	 * @return
	 */
	public Long getTimeToLive()
	{
		return timeToLive;
	}

	/**
	 * 设置timeToLive
	 * 
	 * @param timeToLive
	 */
	public void setTimeToLive(Long timeToLive)
	{
		this.timeToLive = timeToLive;
	}

	/**
	 * 获取timeToSend
	 * 
	 * @return
	 */
	public Long getTimeToSend()
	{
		return timeToSend;
	}

	/**
	 * 设置timeToSend
	 * 
	 * @param timeToSend
	 */
	public void setTimeToSend(Long timeToSend)
	{
		this.timeToSend = timeToSend;
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

	/**
	 * 获取regId
	 * 
	 * @return
	 */
	public String getRegId()
	{
		return regId;
	}

	/**
	 * 设置regId
	 * 
	 * @param regId
	 */
	public void setRegId(String regId)
	{
		this.regId = regId;
	}

	/**
	 * 获取extra
	 * 
	 * @return
	 */
	public MiMessageExtra getExtra()
	{
		return extra;
	}

	/**
	 * 设置extra
	 * 
	 * @param extra
	 */
	public void setExtra(MiMessageExtra extra)
	{
		this.extra = extra;
	}
}
