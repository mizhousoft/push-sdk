package com.mizhousoft.push.oppo;

import com.mizhousoft.push.ProviderPushService;
import com.mizhousoft.push.oppo.constant.OppoConstants;

/**
 * 推送服务
 *
 * @version
 */
public interface OppoPushService extends ProviderPushService
{
	String UNICAST_PUSH_URL = OppoConstants.OPPO_END_POINT + "/server/v1/message/notification/unicast";

	String BROADCAST_TASK_URL = OppoConstants.OPPO_END_POINT + "/server/v1/message/notification/save_message_content";

	String BROADCAST_PUSH_URL = OppoConstants.OPPO_END_POINT + "/server/v1/message/notification/broadcast";
}
