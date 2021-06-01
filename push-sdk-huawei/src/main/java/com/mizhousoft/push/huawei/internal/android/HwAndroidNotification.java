package com.mizhousoft.push.huawei.internal.android;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * AndroidNotification
 *
 * @version
 */
public class HwAndroidNotification
{
	public static final String COLOR_PATTERN = "^#[0-9a-fA-F]{6}$";

	public static final String URL_PATTERN = "^https.*";

	public static final String VIBRATE_PATTERN = "[0-9]+|[0-9]+[sS]|[0-9]+[.][0-9]{1,9}|[0-9]+[.][0-9]{1,9}[sS]";

	// 安卓通知栏消息标题
	// 如果此处设置了title则会覆盖message.notification.title字段，且发送通知栏消息时，此处title和message.notification.title两者最少需要设置一个。
	@JsonProperty("title")
	private String title;

	// 安卓通知栏消息内容
	// 如果此处设置了body则会覆盖message.notification.body字段，且发送通知栏消息时，此处body和message.notification.body两者最少需要设置一个。
	@JsonProperty("body")
	private String body;

	// 自定义通知栏左侧小图标，此处设置的图标文件必须存放在应用的/res/raw路径下，
	// 例如“/raw/ic_launcher”，对应应用本地的“/res/raw/ic_launcher.xxx”文件，
	// 支持的文件格式目前包括png、jpg。自定义小图标规格规范请参见通知图标规格。
	@JsonProperty("icon")
	private String icon;

	// 自定义通知栏按钮颜色，以#RRGGBB格式，其中RR代表红色的16进制色素，GG代表绿色的16进制色素，BB代表蓝色的16进制色素，样例：#FFEEFF。
	@JsonProperty("color")
	private String color;

	// 自定义消息通知铃声，在新创建渠道时有效，此处设置的铃声文件必须存放在应用的/res/raw路径下，例如设置为“/raw/shake”，对应应用本地的“/res/raw/shake.xxx”文件，支持的文件格式包括mp3、wav、mpeg等，如果不设置使用默认系统铃声。
	@JsonProperty("sound")
	private String sound;

	// 默认铃声控制开关
	// true：使用系统默认铃声
	// 使用sound自定义铃声
	@JsonProperty("default_sound")
	private boolean defaultSound;

	// 消息标签，同一应用下使用同一个消息标签的消息会相互覆盖，只展示最新的一条。
	@JsonProperty("tag")
	private String tag;

	// 消息点击行为，具体字段请参见ClickAction结构体的定义。
	// 如果是安卓通知栏消息时，则该参数必选。
	@JsonProperty("click_action")
	private HwClickAction clickAction;

	// 显示本地化body的StringId
	@JsonProperty("body_loc_key")
	private String bodyLocKey;

	// 本地化body的可变参数
	@JsonProperty("body_loc_args")
	private List<String> bodyLocArgs = new ArrayList<>();

	// 显示本地化title的StringId
	@JsonProperty("title_loc_key")
	private String titleLocKey;

	// 本地化title的可变参数
	@JsonProperty("title_loc_args")
	private List<String> titleLocArgs = new ArrayList<>();

	// 自Android O版本后可以支持通知栏自定义渠道，指定消息要展示在哪个通知渠道上
	@JsonProperty("channel_id")
	private String channelId;

	// 安卓通知栏消息简要描述。
	@JsonProperty("notify_summary")
	private String notifySummary;

	// 自定义通知栏消息右侧大图标URL，功能和message.notification.image字段一样，如果此处设置，则覆盖message.notification.image中的值。URL使用的协议必须是HTTPS协议，取值样例：https://example.com/image.png。
	@JsonProperty("image")
	private String image;

	// 通知栏样式
	@JsonProperty("style")
	private Integer style;

	// 安卓通知栏消息大文本标题
	@JsonProperty("big_title")
	private String bigTitle;

	// 安卓通知栏消息大文本内容，当style为1时必选，设置big_body后通知栏展示时，使用big_body而不用body。
	@JsonProperty("big_body")
	private String bigBody;

	// 消息展示时长，超过后自动清除，单位：毫秒。
	@JsonProperty("auto_clear")
	private Integer autoClear;

	// 每条消息在通知显示时的唯一标识。不携带时或者设置-1时，Push NC自动为给每条消息生成一个唯一标识；不同的通知栏消息可以拥有相同的notifyId，实现新的消息覆盖上一条消息功能。
	@JsonProperty("notify_id")
	private Integer notifyId;

	// 消息分组，例如发送10条带有同样group字段的消息，手机上只会展示该组消息中最新的一条和当前该组接收到的消息总数目，不会展示10条消息。
	@JsonProperty("group")
	private String group;

	// 安卓通知消息角标控制，具体字段请参见BadgeNotification结构体的定义。
	@JsonProperty("badge")
	private HwBadgeNotification badge;

	// 通知消息常驻标识，用户点击通知中心消息后，消息是否仍驻留在通知中心上
	@JsonProperty("auto_cancel")
	private boolean autoCancel;

	// 消息的排序时间，安卓通知栏消息根据这个值将消息排序，同时将转换后的时间在通知栏上显示
	@JsonProperty("when")
	private String when;

	// 安卓通知栏消息优先级，决定用户设备消息通知行为，取值如下：
	@JsonProperty("importance")
	private String importance;

	// 是否使用系统默认振动模式控制开关。
	@JsonProperty("use_default_vibrate")
	private boolean useDefaultVibrate;

	// 是否使用默认呼吸灯模式控制开关。
	@JsonProperty("use_default_light")
	private boolean useDefaultLight;

	// 安卓自定义通知消息振动模式
	@JsonProperty("vibrate_config")
	private List<String> vibrateConfig = new ArrayList<>();

	// 安卓通知栏消息可见性
	@JsonProperty("visibility")
	private String visibility;

	// 自定义呼吸灯模式
	@JsonProperty("light_settings")
	private HwLightSettings lightSettings;

	// 应用在前台时通知栏消息是否前台展示开关
	@JsonProperty("foreground_show")
	private boolean foregroundShow;

	// 当style为3时，Inbox样式的内容（必选），支持最大5条内容，每条最大长度1024
	@JsonProperty("inbox_content")
	private List<String> inboxContent;

	// 通知栏消息动作按钮，最多设置3个
	@JsonProperty("buttons")
	private List<HwButton> buttons;

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
	 * 获取color
	 * 
	 * @return
	 */
	public String getColor()
	{
		return color;
	}

	/**
	 * 设置color
	 * 
	 * @param color
	 */
	public void setColor(String color)
	{
		this.color = color;
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
	 * 获取defaultSound
	 * 
	 * @return
	 */
	public boolean isDefaultSound()
	{
		return defaultSound;
	}

	/**
	 * 设置defaultSound
	 * 
	 * @param defaultSound
	 */
	public void setDefaultSound(boolean defaultSound)
	{
		this.defaultSound = defaultSound;
	}

	/**
	 * 获取tag
	 * 
	 * @return
	 */
	public String getTag()
	{
		return tag;
	}

	/**
	 * 设置tag
	 * 
	 * @param tag
	 */
	public void setTag(String tag)
	{
		this.tag = tag;
	}

	/**
	 * 获取clickAction
	 * 
	 * @return
	 */
	public HwClickAction getClickAction()
	{
		return clickAction;
	}

	/**
	 * 设置clickAction
	 * 
	 * @param clickAction
	 */
	public void setClickAction(HwClickAction clickAction)
	{
		this.clickAction = clickAction;
	}

	/**
	 * 获取bodyLocKey
	 * 
	 * @return
	 */
	public String getBodyLocKey()
	{
		return bodyLocKey;
	}

	/**
	 * 设置bodyLocKey
	 * 
	 * @param bodyLocKey
	 */
	public void setBodyLocKey(String bodyLocKey)
	{
		this.bodyLocKey = bodyLocKey;
	}

	/**
	 * 获取bodyLocArgs
	 * 
	 * @return
	 */
	public List<String> getBodyLocArgs()
	{
		return bodyLocArgs;
	}

	/**
	 * 设置bodyLocArgs
	 * 
	 * @param bodyLocArgs
	 */
	public void setBodyLocArgs(List<String> bodyLocArgs)
	{
		this.bodyLocArgs = bodyLocArgs;
	}

	/**
	 * 获取titleLocKey
	 * 
	 * @return
	 */
	public String getTitleLocKey()
	{
		return titleLocKey;
	}

	/**
	 * 设置titleLocKey
	 * 
	 * @param titleLocKey
	 */
	public void setTitleLocKey(String titleLocKey)
	{
		this.titleLocKey = titleLocKey;
	}

	/**
	 * 获取titleLocArgs
	 * 
	 * @return
	 */
	public List<String> getTitleLocArgs()
	{
		return titleLocArgs;
	}

	/**
	 * 设置titleLocArgs
	 * 
	 * @param titleLocArgs
	 */
	public void setTitleLocArgs(List<String> titleLocArgs)
	{
		this.titleLocArgs = titleLocArgs;
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
	 * 获取notifySummary
	 * 
	 * @return
	 */
	public String getNotifySummary()
	{
		return notifySummary;
	}

	/**
	 * 设置notifySummary
	 * 
	 * @param notifySummary
	 */
	public void setNotifySummary(String notifySummary)
	{
		this.notifySummary = notifySummary;
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
	 * 获取bigTitle
	 * 
	 * @return
	 */
	public String getBigTitle()
	{
		return bigTitle;
	}

	/**
	 * 设置bigTitle
	 * 
	 * @param bigTitle
	 */
	public void setBigTitle(String bigTitle)
	{
		this.bigTitle = bigTitle;
	}

	/**
	 * 获取bigBody
	 * 
	 * @return
	 */
	public String getBigBody()
	{
		return bigBody;
	}

	/**
	 * 设置bigBody
	 * 
	 * @param bigBody
	 */
	public void setBigBody(String bigBody)
	{
		this.bigBody = bigBody;
	}

	/**
	 * 获取autoClear
	 * 
	 * @return
	 */
	public Integer getAutoClear()
	{
		return autoClear;
	}

	/**
	 * 设置autoClear
	 * 
	 * @param autoClear
	 */
	public void setAutoClear(Integer autoClear)
	{
		this.autoClear = autoClear;
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
	 * 获取group
	 * 
	 * @return
	 */
	public String getGroup()
	{
		return group;
	}

	/**
	 * 设置group
	 * 
	 * @param group
	 */
	public void setGroup(String group)
	{
		this.group = group;
	}

	/**
	 * 获取badge
	 * 
	 * @return
	 */
	public HwBadgeNotification getBadge()
	{
		return badge;
	}

	/**
	 * 设置badge
	 * 
	 * @param badge
	 */
	public void setBadge(HwBadgeNotification badge)
	{
		this.badge = badge;
	}

	/**
	 * 获取autoCancel
	 * 
	 * @return
	 */
	public boolean isAutoCancel()
	{
		return autoCancel;
	}

	/**
	 * 设置autoCancel
	 * 
	 * @param autoCancel
	 */
	public void setAutoCancel(boolean autoCancel)
	{
		this.autoCancel = autoCancel;
	}

	/**
	 * 获取when
	 * 
	 * @return
	 */
	public String getWhen()
	{
		return when;
	}

	/**
	 * 设置when
	 * 
	 * @param when
	 */
	public void setWhen(String when)
	{
		this.when = when;
	}

	/**
	 * 获取importance
	 * 
	 * @return
	 */
	public String getImportance()
	{
		return importance;
	}

	/**
	 * 设置importance
	 * 
	 * @param importance
	 */
	public void setImportance(String importance)
	{
		this.importance = importance;
	}

	/**
	 * 获取useDefaultVibrate
	 * 
	 * @return
	 */
	public boolean isUseDefaultVibrate()
	{
		return useDefaultVibrate;
	}

	/**
	 * 设置useDefaultVibrate
	 * 
	 * @param useDefaultVibrate
	 */
	public void setUseDefaultVibrate(boolean useDefaultVibrate)
	{
		this.useDefaultVibrate = useDefaultVibrate;
	}

	/**
	 * 获取useDefaultLight
	 * 
	 * @return
	 */
	public boolean isUseDefaultLight()
	{
		return useDefaultLight;
	}

	/**
	 * 设置useDefaultLight
	 * 
	 * @param useDefaultLight
	 */
	public void setUseDefaultLight(boolean useDefaultLight)
	{
		this.useDefaultLight = useDefaultLight;
	}

	/**
	 * 获取vibrateConfig
	 * 
	 * @return
	 */
	public List<String> getVibrateConfig()
	{
		return vibrateConfig;
	}

	/**
	 * 设置vibrateConfig
	 * 
	 * @param vibrateConfig
	 */
	public void setVibrateConfig(List<String> vibrateConfig)
	{
		this.vibrateConfig = vibrateConfig;
	}

	/**
	 * 获取visibility
	 * 
	 * @return
	 */
	public String getVisibility()
	{
		return visibility;
	}

	/**
	 * 设置visibility
	 * 
	 * @param visibility
	 */
	public void setVisibility(String visibility)
	{
		this.visibility = visibility;
	}

	/**
	 * 获取lightSettings
	 * 
	 * @return
	 */
	public HwLightSettings getLightSettings()
	{
		return lightSettings;
	}

	/**
	 * 设置lightSettings
	 * 
	 * @param lightSettings
	 */
	public void setLightSettings(HwLightSettings lightSettings)
	{
		this.lightSettings = lightSettings;
	}

	/**
	 * 获取foregroundShow
	 * 
	 * @return
	 */
	public boolean isForegroundShow()
	{
		return foregroundShow;
	}

	/**
	 * 设置foregroundShow
	 * 
	 * @param foregroundShow
	 */
	public void setForegroundShow(boolean foregroundShow)
	{
		this.foregroundShow = foregroundShow;
	}

	/**
	 * 获取inboxContent
	 * 
	 * @return
	 */
	public List<String> getInboxContent()
	{
		return inboxContent;
	}

	/**
	 * 设置inboxContent
	 * 
	 * @param inboxContent
	 */
	public void setInboxContent(List<String> inboxContent)
	{
		this.inboxContent = inboxContent;
	}

	/**
	 * 获取buttons
	 * 
	 * @return
	 */
	public List<HwButton> getButtons()
	{
		return buttons;
	}

	/**
	 * 设置buttons
	 * 
	 * @param buttons
	 */
	public void setButtons(List<HwButton> buttons)
	{
		this.buttons = buttons;
	}
}
