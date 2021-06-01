package com.mizhousoft.push.huawei;

import com.mizhousoft.push.ProviderPushService;

/**
 * 推送服务
 *
 * @version
 */
public interface HuaweiPushService extends ProviderPushService
{
	String PUSH_URL = "https://push-api.cloud.huawei.com/v1/%s/messages:send";
}
