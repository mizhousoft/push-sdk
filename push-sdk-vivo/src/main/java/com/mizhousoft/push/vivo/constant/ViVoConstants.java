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
	int PUSH_MODE_OFFICIAL_PUSH = 1;

	// 测试推送
	int PUSH_MODE_TEST_PUSH = 2;

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
