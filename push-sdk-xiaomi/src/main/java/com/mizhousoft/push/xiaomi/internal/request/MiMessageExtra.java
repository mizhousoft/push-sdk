package com.mizhousoft.push.xiaomi.internal.request;

/**
 * 消息扩展
 *
 * @version
 */
public class MiMessageExtra
{
	public static final String SOUND_URI = "extra.sound_uri";

	public static final String TICKER = "extra.ticker";

	public static final String NOTIFY_FOREGROUND = "extra.notify_foreground";

	public static final String NOTIFY_EFFECT = "extra.notify_effect";

	public static final String INTENT_URI = "extra.intent_uri";

	public static final String WEB_URI = "extra.web_uri";

	public static final String FLOW_CONTROL = "extra.flow_control";

	public static final String JOBKEY = "extra.jobkey";

	public static final String LOCALE = "extra.locale";

	public static final String MODEL = "extra.model";

	public static final String MODEL_NOT_IN = "extra.model_not_in";

	public static final String APP_VERSION = "extra.app_version";

	public static final String APP_VERSION_NOT_IN = "extra.app_version_not_in";

	public static final String ONLY_SEND_ONCE = "extra.only_send_once";

	// 可选项，自定义通知栏消息铃声
	private String soundUri;

	// 可选项，开启通知消息在状态栏滚动显示。
	private String ticker;

	// 可选项，开启/关闭app在前台时的通知弹出
	private String foreground;

	// 可选项，预定义通知栏消息的点击行为
	private String effect;

	// 可选项，打开当前app的任一组件。
	private String intentUri;

	// 可选项，打开某一个网页。
	private String webUri;

	// 可选项，控制是否需要进行平缓发送。默认不支持。value代表平滑推送的速度。
	// 注：服务端支持最低3000/s的qps。也就是说，如果将平滑推送设置为1000，那么真实的推送速度是3000/s。
	private Integer flowControl;

	// 可选项，使用推送批次（JobKey）功能聚合消息。
	// 客户端会按照jobkey去重，即相同jobkey的消息只展示第一条，其他的消息会被忽略。
	// 合法的jobkey由数字（[0-9]），大小写字母（[a-zA-Z]），下划线（_）和中划线（-）组成，长度不大于12个字符，且不能以下划线(_)开头。
	private String jobkey;

	// 可选项，可以接收消息的设备的语言范围，用逗号分隔。
	private String locale;

	// 可选项，可以收到消息的设备的机型范围，逗号分隔。
	private String model;

	// 可选项，无法收到消息的设备的机型范围，逗号分隔。
	private String modelNotIn;

	// 可以接收消息的app版本号，用逗号分割
	private String appVersion;

	// 无法接收消息的app版本号，用逗号分割。
	private String appVersionNotIn;

	// 可选项，extra.only_send_once的值设置为1，表示该消息仅在设备在线时发送一次，不缓存离线消息进行多次下发。
	private String onlySendOnce;

	/**
	 * 获取soundUri
	 * 
	 * @return
	 */
	public String getSoundUri()
	{
		return soundUri;
	}

	/**
	 * 设置soundUri
	 * 
	 * @param soundUri
	 */
	public void setSoundUri(String soundUri)
	{
		this.soundUri = soundUri;
	}

	/**
	 * 获取ticker
	 * 
	 * @return
	 */
	public String getTicker()
	{
		return ticker;
	}

	/**
	 * 设置ticker
	 * 
	 * @param ticker
	 */
	public void setTicker(String ticker)
	{
		this.ticker = ticker;
	}

	/**
	 * 获取foreground
	 * 
	 * @return
	 */
	public String getForeground()
	{
		return foreground;
	}

	/**
	 * 设置foreground
	 * 
	 * @param foreground
	 */
	public void setForeground(String foreground)
	{
		this.foreground = foreground;
	}

	/**
	 * 获取effect
	 * 
	 * @return
	 */
	public String getEffect()
	{
		return effect;
	}

	/**
	 * 设置effect
	 * 
	 * @param effect
	 */
	public void setEffect(String effect)
	{
		this.effect = effect;
	}

	/**
	 * 获取intentUri
	 * 
	 * @return
	 */
	public String getIntentUri()
	{
		return intentUri;
	}

	/**
	 * 设置intentUri
	 * 
	 * @param intentUri
	 */
	public void setIntentUri(String intentUri)
	{
		this.intentUri = intentUri;
	}

	/**
	 * 获取webUri
	 * 
	 * @return
	 */
	public String getWebUri()
	{
		return webUri;
	}

	/**
	 * 设置webUri
	 * 
	 * @param webUri
	 */
	public void setWebUri(String webUri)
	{
		this.webUri = webUri;
	}

	/**
	 * 获取flowControl
	 * 
	 * @return
	 */
	public Integer getFlowControl()
	{
		return flowControl;
	}

	/**
	 * 设置flowControl
	 * 
	 * @param flowControl
	 */
	public void setFlowControl(Integer flowControl)
	{
		this.flowControl = flowControl;
	}

	/**
	 * 获取jobkey
	 * 
	 * @return
	 */
	public String getJobkey()
	{
		return jobkey;
	}

	/**
	 * 设置jobkey
	 * 
	 * @param jobkey
	 */
	public void setJobkey(String jobkey)
	{
		this.jobkey = jobkey;
	}

	/**
	 * 获取locale
	 * 
	 * @return
	 */
	public String getLocale()
	{
		return locale;
	}

	/**
	 * 设置locale
	 * 
	 * @param locale
	 */
	public void setLocale(String locale)
	{
		this.locale = locale;
	}

	/**
	 * 获取model
	 * 
	 * @return
	 */
	public String getModel()
	{
		return model;
	}

	/**
	 * 设置model
	 * 
	 * @param model
	 */
	public void setModel(String model)
	{
		this.model = model;
	}

	/**
	 * 获取modelNotIn
	 * 
	 * @return
	 */
	public String getModelNotIn()
	{
		return modelNotIn;
	}

	/**
	 * 设置modelNotIn
	 * 
	 * @param modelNotIn
	 */
	public void setModelNotIn(String modelNotIn)
	{
		this.modelNotIn = modelNotIn;
	}

	/**
	 * 获取appVersion
	 * 
	 * @return
	 */
	public String getAppVersion()
	{
		return appVersion;
	}

	/**
	 * 设置appVersion
	 * 
	 * @param appVersion
	 */
	public void setAppVersion(String appVersion)
	{
		this.appVersion = appVersion;
	}

	/**
	 * 获取appVersionNotIn
	 * 
	 * @return
	 */
	public String getAppVersionNotIn()
	{
		return appVersionNotIn;
	}

	/**
	 * 设置appVersionNotIn
	 * 
	 * @param appVersionNotIn
	 */
	public void setAppVersionNotIn(String appVersionNotIn)
	{
		this.appVersionNotIn = appVersionNotIn;
	}

	/**
	 * 获取onlySendOnce
	 * 
	 * @return
	 */
	public String getOnlySendOnce()
	{
		return onlySendOnce;
	}

	/**
	 * 设置onlySendOnce
	 * 
	 * @param onlySendOnce
	 */
	public void setOnlySendOnce(String onlySendOnce)
	{
		this.onlySendOnce = onlySendOnce;
	}
}
