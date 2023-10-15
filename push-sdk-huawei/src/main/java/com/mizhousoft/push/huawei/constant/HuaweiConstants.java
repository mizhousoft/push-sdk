package com.mizhousoft.push.huawei.constant;

/**
 * 常量
 *
 * @version
 */
public interface HuaweiConstants
{
	// -------------------Android通知栏消息可见性-------------------

	// 锁屏时收到通知栏消息，显示消息内容。
	String VISIBILITY_PUBLIC = "PUBLIC";

	// 锁屏时收到通知栏消息，不提示收到通知消息。
	String VISIBILITY_SECRET = "SECRET";

	// 设置了锁屏密码，“锁屏通知”（导航：“设置 > 通知 > 隐藏通知内容”）选择“隐藏通知内容”时收到通知消息，不显示消息内容。
	String VISIBILITY_PRIVATE = "PRIVATE";

	// -------------------Android通知栏消息优先级-------------------

	// 一般（静默）消息
	String IMPORTANCE_LOW = "LOW";

	// 重要消息
	String IMPORTANCE_NORMAL = "NORMAL";

	// 非常重要消息
	String IMPORTANCE_HIGH = "HIGH";

	// -------------------点击通知动作-------------------

	// 打开应用自定义页面
	int CLICK_ACTION_OPEN_CUST_ACTIVITY = 1;

	// 点击后打开特定URL
	int CLICK_ACTION_OPEN_CUST_URL = 2;

	// 点击后打开应用App
	int CLICK_ACTION_OPEN_APP = 3;

	// -------------------消息类型-------------------

	// 即时聊天
	String CATEGORY_IM = "IM";

	// 音视频通话
	String CATEGORY_VOIP = "VOIP";

	// 订阅
	String CATEGORY_SUBSCRIPTION = "SUBSCRIPTION";

	// 出行
	String CATEGORY_TRAVEL = "TRAVEL";

	// 健康
	String CATEGORY_HEALTH = "HEALTH";

	// 工作事项提醒
	String CATEGORY_WORK = "WORK";

	// 帐号动态
	String CATEGORY_ACCOUNT = "ACCOUNT";

	// 订单&物流
	String CATEGORY_EXPRESS = "EXPRESS";

	// 财务
	String CATEGORY_FINANCE = "FINANCE";

	// 设备提醒
	String CATEGORY_DEVICE_REMINDER = "DEVICE_REMINDER";

	// 邮件
	String CATEGORY_MAIL = "MAIL";

	// 语音播报（仅透传消息支持）
	String CATEGORY_PLAY_VOICE = "PLAY_VOICE";

	// 内容推荐、新闻、财经动态、生活资讯、社交动态、调研、产品促销、功能推荐、运营活动（仅对内容进行标识，不会加快消息发送）
	String CATEGORY_MARKETING = "MARKETING";

	// -------------------点击通知动作-------------------

	// 默认样式
	int STYLE_DEFAULE = 0;

	// 大文本样式
	int STYLE_BIG_TEXT = 1;

	// Inbox样式
	int STYLE_INBOX = 3;
}
