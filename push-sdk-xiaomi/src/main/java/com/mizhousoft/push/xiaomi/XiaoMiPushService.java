package com.mizhousoft.push.xiaomi;

import com.mizhousoft.push.ProviderPushService;

/**
 * 小米推送服务
 *
 * @version
 */
public interface XiaoMiPushService extends ProviderPushService
{
	String PUSH_URL = "https://api.xmpush.xiaomi.com/v3/message/regid";

}
