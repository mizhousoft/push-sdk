package com.mizhousoft.push.umeng.constant;

/**
 * 常量
 *
 * @version
 */
public interface UMengConstants
{
	// -------------------- 显示类型 ---------------

	// 通知
	String DISPLAY_TYPE_NOTIFICATION = "notification";

	// 消息
	String DISPLAY_TYPE_MESSAGE = "message";

	// -------------------- 消息类型 ---------------

	// 单播
	String MESSAGE_TYPE_UNICAST = "unicast";

	// 列播，要求不超过500个device_token
	String MESSAGE_TYPE_LISTCAST = "listcast";

	// 文件播，多个device_token可通过文件形式批量发送
	String MESSAGE_TYPE_FILECAST = "filecast";

	// 广播
	String MESSAGE_TYPE_BROADCAST = "broadcast";

	// 组播，按照filter筛选用户群,请参照filter参数
	String MESSAGE_TYPE_GROUPCAST = "groupcast";

	// 通过alias进行推送
	String MESSAGE_TYPE_CUSTOMIZEDCAST = "customizedcast";

	// -------------------- 点击通知类型 ---------------

	// 打开应用
	String CLICK_ACTION_GO_APP = "go_app";

	// 跳转到URL
	String CLICK_ACTION_GO_URL = "go_url";

	// 打开特定的activity
	String CLICK_ACTION_GO_ACTIVITY = "go_activity";

	// 用户自定义内容
	String CLICK_ACTION_GO_CUSTOM = "go_custom";

	// -------------------- 推送结果 ---------------

	// 推送成功
	String RESULT_SUCCEED = "SUCCESS";

	// 推送失败
	String RESULT_FAIL = "FAIL";
}
