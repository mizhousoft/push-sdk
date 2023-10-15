package com.mizhousoft.push;

/**
 * 消息类目类型
 *
 */
public interface MessageCategory
{

	// 即时消息
	String CATEGORY_IM = "IM";

	// 账号与资产
	String CATEGORY_ACCOUNT = "ACCOUNT";

	// 日程待办
	String CATEGORY_TODO = "TODO";

	// 设备信息
	String CATEGORY_DEVICE_REMINDER = "DEVICE_REMINDER";

	// 订单与物流
	String CATEGORY_ORDER = "ORDER";

	// 订阅提醒
	String CATEGORY_SUBSCRIPTION = "SUBSCRIPTION";

	// 新闻
	String CATEGORY_NEWS = "NEWS";

	// 内容推荐
	String CATEGORY_CONTENT = "CONTENT";

	// 运营活动
	String CATEGORY_MARKETING = "MARKETING";

	// 社交动态
	String CATEGORY_SOCIAL = "SOCIAL";
}
