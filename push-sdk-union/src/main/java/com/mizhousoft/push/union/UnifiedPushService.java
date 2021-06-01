package com.mizhousoft.push.union;

import com.mizhousoft.push.PushProvider;
import com.mizhousoft.push.exception.PushException;
import com.mizhousoft.push.request.MessageRequest;
import com.mizhousoft.push.request.NotificationRequest;
import com.mizhousoft.push.result.PushResult;

/**
 * 统一的推送服务
 *
 * @version
 */
public interface UnifiedPushService
{
	/**
	 * 推送通知
	 * 
	 * @param provider
	 * @param request
	 * @return
	 * @throws PushException
	 */
	PushResult pushNotification(PushProvider provider, NotificationRequest request) throws PushException;

	/**
	 * 推送消息
	 * 
	 * @param provider
	 * @param request
	 * @return
	 * @throws PushException
	 */
	PushResult pushMessage(PushProvider provider, MessageRequest request) throws PushException;

	/**
	 * 初始化
	 * 
	 * @throws PushException
	 */
	void initialize() throws PushException;

	/**
	 * 释放资源
	 * 
	 * @throws PushException
	 */
	void release() throws PushException;
}
