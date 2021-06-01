package com.mizhousoft.push.oppo.constant;

/**
 * 常量
 *
 * @version
 */
public interface OppoConstants
{
	// Endpoint
	String OPPO_END_POINT = "https://api.push.oppomobile.com";

	// -------------目标类型---------

	// registration_id
	int TARGET_TYPE_REGISTRATION_ID = 2;

	// 别名
	int TARGET_TYPE_ALIAS = 5;

	// 标签
	int TARGET_TYPE_TAG = 6;

	// -------------样式---------

	// 标准样式，字数限制200以内（兼容API文档以前定义，实际手机端通知栏消息只能展示50字数）
	int NOTIFICATION_STYLE_STANDARD = 1;

	// 长文本样式，限制128个以内
	int NOTIFICATION_STYLE_LONG_TEXT = 2;

	// 大图样式，字数限制50以内，中英文均以一个计算
	int NOTIFICATION_STYLE_BIG_PIC = 3;

	// -------------点击动作类型---------

	// 启动应用
	int CLICK_ACTION_OPEN_APP = 0;

	// 打开应用内页（activity的intent action）
	int CLICK_ACTION_OPEN_INTENT_ACTION = 1;

	// 打开网页
	int CLICK_ACTION_OPEN_WEB = 2;

	// 打开应用内页（activity）
	int CLICK_ACTION_OPEN_ACTION = 4;

	// Intent scheme URL
	int CLICK_ACTION_OPEN_INTENT_SCHEME = 5;

	// -------------展示类型---------

	// 展示类型，即时
	int SHOWTIMETYPE_IMMEDIATE = 0;

	// 展示类型，定时
	int SHOWTIMETYPE_TIMING = 1;

	// -------------参数---------

	String PARAM_TOKEN = "auth_token";

	String PARAM_APP_KEY = "app_key";

	String PARAM_SIGN = "sign";

	String PARAM_TIMESTAMP = "timestamp";

	String PARAM_MESSAGE_ID = "message_id";

	String PARAM_TARGET_TYPE = "target_type";

	String PARAM_TARGET_VALUE = "target_value";

	String PARAM_NOTIFICATION = "notification";

	String PARAM_MESSAGE = "message";

	String PARAM_MESSAGES = "messages";

	String PARAM_CHANNEL_ID = "channel_id";

	String PARAM_CHANNEL_GROUP_ID = "channel_group_id";

	String PARAM_TITLE = "title";

	String PARAM_APP_MESSAGE_ID = "app_message_id";

	String PARAM_SUB_TITLE = "sub_title";

	String PARAM_CONTENT = "content";

	String PARAM_CLICK_ACTION_TYPE = "click_action_type";

	String PARAM_CLICK_ACTION_ACTIVITY = "click_action_activity";

	String PARAM_CLICK_ACTION_URL = "click_action_url";

	String PARAM_ACTION_PARAMETERS = "action_parameters";

	String PARAM_SHOW_TIME_TYPE = "show_time_type";

	String PARAM_SHOW_START_TIME = "show_start_time";

	String PARAM_SHOW_END_TIME = "show_end_time";

	String PARAM_OFF_LINE = "off_line";

	String PARAM_OFF_LINE_TTL = "off_line_ttl";

	String PARAM_PUSH_TIME_TYPE = "push_time_type";

	String PARAM_PUSH_START_TIME = "push_start_time";

	String PARAM_TIME_ZONE = "time_zone";

	String PARAM_FIX_SPEED = "fix_speed";

	String PARAM_FIX_SPEED_RATE = "fix_speed_rate";

	String PARAM_NETWORK_TYPE = "network_type";

	String PARAM_CALL_BACK_URL = "call_back_url";

	String PARAM_CALL_BACK_PARAMETER = "call_back_parameter";

	String PARAM_STYLE = "style";

	String PARAM_BIG_PICTURE_ID = "big_picture_id";

	String PARAM_SMALL_PICTURE_ID = "small_picture_id";

	String PARAM_PICTURE_TTL = "picture_ttl";

	String PARAM_SHOW_TTL = "show_ttl";

	String PARAM_NOTIFY_ID = "notify_id";

	// -------------返回码---------

	// registration_id格式不正确
	int INVALID_REGISTRATION_ID = 10000;

}
