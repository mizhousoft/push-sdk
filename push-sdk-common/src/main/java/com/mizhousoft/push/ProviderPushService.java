package com.mizhousoft.push;

import com.mizhousoft.push.exception.PushException;
import com.mizhousoft.push.request.MessageRequest;
import com.mizhousoft.push.request.NotificationRequest;
import com.mizhousoft.push.result.PushResult;

/**
 * 供应商推送服务
 *
 * @version
 */
public interface ProviderPushService
{
	/**
	 * 是否支持多个发送
	 * 
	 * @return
	 */
	boolean isSupportMultiSend();

	/**
	 * 推送通知
	 * 
	 * @param request
	 * @return
	 * @throws PushException
	 */
	PushResult pushNotification(NotificationRequest request) throws PushException;

	/**
	 * 推送消息
	 * 
	 * @param request
	 * @return
	 * @throws PushException
	 */
	default PushResult pushMessage(MessageRequest request) throws PushException
	{
		return null;
	}

	/**
	 * 初始化
	 * 
	 * @throws PushException
	 */
	default void initialize() throws PushException
	{

	}

	/**
	 * 释放资源
	 * 
	 * @throws PushException
	 */
	default void release() throws PushException
	{

	}
}
