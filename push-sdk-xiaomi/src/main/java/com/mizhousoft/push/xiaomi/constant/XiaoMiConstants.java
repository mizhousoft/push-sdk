package com.mizhousoft.push.xiaomi.constant;

/**
 * 常量
 *
 * @version
 */
public interface XiaoMiConstants
{
	// 透传消息
	int PASS_THROUGH_PASS = 1;

	// 通知栏消息
	int PASS_THROUGH_NOTIFICATION = 0;

	// 使用所有
	int NOTIFY_TYPE_ALL = -1;

	// 使用默认提示音提示
	int NOTIFY_TYPE_SOUND = 1;

	// 使用默认震动提示
	int NOTIFY_TYPE_VIBRATE = 2;

	// 使用默认led灯光提示
	int NOTIFY_TYPE_LIGHTS = 4;

	// 弹出通知栏消息
	String NOTIFY_FOREGROUND_OPEN = "1";

	// 不会弹出通知栏消息
	String NOTIFY_FOREGROUND_CLOSE = "0";

	// 通知栏点击后打开app的Launcher Activity。
	String NOTIFY_EFFECT_LAUNCHER_ACTIVITY = "1";

	// 通知栏点击后打开app的任一Activity（开发者还需要传入extra.intent_uri）。
	String NOTIFY_EFFECT_ANY_ACTIVITY = "2";

	// 通知栏点击后打开网页（开发者还需要传入extra.web_uri）。
	String NOTIFY_EFFECT_WEB = "3";

	// 发送消息失败
	int SEND_MESSAGE_FAILURE = 20301;
}
