package com.mizhousoft.push.vivo;

import com.mizhousoft.push.ProviderPushService;

/**
 * 推送服务
 *
 * @version
 */
public interface ViVoPushService extends ProviderPushService
{
	String UNICAST_PUSH_URL = "https://api-push.vivo.com.cn/message/send";

	String BROADCAST_TASK_URL = "https://api-push.vivo.com.cn/message/saveListPayload";

	String BROADCAST_PUSH_URL = "https://api-push.vivo.com.cn/message/pushToList";
}
