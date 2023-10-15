package com.mizhousoft.push.vivo.constant;

/**
 * 常量
 *
 * @version
 */
public interface ViVoConstants
{
	// -----------------------跳转类型--------------

	// 打开APP首页
	int SKIPTYPE_APP_HOME_PAGE = 1;

	// 打开链接
	int SKIPTYPE_URL = 2;

	// 自定义
	int SKIPTYPE_CUSTOM = 3;

	// 打开app内指定页面
	int SKIPTYPE_APP_SPEC_PAGE = 4;

	// -------------------- 推送模式 ---------------

	// 正式推送
	int PUSH_MODE_OFFICIAL_PUSH = 0;

	// 测试推送
	int PUSH_MODE_TEST_PUSH = 1;

	// -------------------- 网络类型 ---------------

	// 正式推送
	int NETWORK_TYPE_UNLIMITED = -1;

	// wifi下发送
	int NETWORK_TYPE_WIFI = 1;

	// -------------------- 消息类型 ---------------

	// 运营类消息
	int CLASSIFICATION_OPERATION = 0;

	// 系统类消息
	int CLASSIFICATION_SYSTEM = 1;

	// -------------------- 消息分类 ---------------

	// 即时消息
	String SYSTEM_CATEGORY_IM = "IM";

	// 账号与资产
	String SYSTEM_CATEGORY_ACCOUNT = "ACCOUNT";

	// 日程待办
	String SYSTEM_CATEGORY_TODO = "TODO";

	// 设备信息
	String SYSTEM_CATEGORY_DEVICE_REMINDER = "DEVICE_REMINDER";

	// 订单与物流
	String SYSTEM_CATEGORY_ORDER = "ORDER";

	// 订阅提醒
	String SYSTEM_CATEGORY_SUBSCRIPTION = "SUBSCRIPTION";

	// 新闻
	String OPERATION_CATEGORY_NEWS = "NEWS";

	// 内容推荐
	String OPERATION_CATEGORY_CONTENT = "CONTENT";

	// 运营活动
	String OPERATION_CATEGORY_MARKETING = "MARKETING";

	// 社交动态
	String OPERATION_CATEGORY_SOCIAL = "SOCIAL";

	// -------------------- 通知类型 ---------------

	// 无
	int NOTIFYTYPE_NONE = 1;

	// 响铃
	int NOTIFYTYPE_RING = 2;

	// 振动
	int NOTIFYTYPE_VIBRATION = 3;

	// 响铃和振动
	int NOTIFYTYPE_RING_VIBRATION = 4;
	// -------------返回码---------

	// registration_id格式不正确
	int INVALID_REGISTRATION_ID = 10302;
}
