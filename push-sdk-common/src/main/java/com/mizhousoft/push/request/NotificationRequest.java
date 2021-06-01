package com.mizhousoft.push.request;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.mizhousoft.push.NotificationType;
import com.mizhousoft.push.action.ClickAction;

/**
 * 推送通知请求
 *
 * @version
 */
public class NotificationRequest
{
	// 设备token, <Token, UserId>
	private final Map<String, Integer> tokenMap;

	// 通知栏消息的标题
	private String title;

	// 通知栏消息的内容
	private String body;

	// 通道ID
	private String channelId;

	// 点击动作
	private ClickAction clickAction;

	// 通知类型
	private NotificationType notificationType = NotificationType.SYSTEM;

	/**
	 * 构造函数
	 *
	 * @param userId
	 * @param token
	 */
	public NotificationRequest(int userId, String token)
	{
		super();

		this.tokenMap = new HashMap<>();
		tokenMap.put(token, userId);
	}

	/**
	 * 构造函数
	 *
	 * @param tokenMap
	 */
	public NotificationRequest(Map<String, Integer> tokenMap)
	{
		super();
		this.tokenMap = tokenMap;
	}

	/**
	 * 获取tokenMap
	 * 
	 * @return
	 */
	public Map<String, Integer> getTokenMap()
	{
		return tokenMap;
	}

	/**
	 * 获取title
	 * 
	 * @return
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * 设置title
	 * 
	 * @param title
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	/**
	 * 获取body
	 * 
	 * @return
	 */
	public String getBody()
	{
		return body;
	}

	/**
	 * 设置body
	 * 
	 * @param body
	 */
	public void setBody(String body)
	{
		this.body = body;
	}

	/**
	 * 获取channelId
	 * 
	 * @return
	 */
	public String getChannelId()
	{
		return channelId;
	}

	/**
	 * 设置channelId
	 * 
	 * @param channelId
	 */
	public void setChannelId(String channelId)
	{
		this.channelId = channelId;
	}

	/**
	 * 获取tokens
	 * 
	 * @return
	 */
	public Set<String> getTokens()
	{
		return tokenMap.keySet();
	}

	/**
	 * 获取clickAction
	 * 
	 * @return
	 */
	public ClickAction getClickAction()
	{
		return clickAction;
	}

	/**
	 * 设置clickAction
	 * 
	 * @param clickAction
	 */
	public void setClickAction(ClickAction clickAction)
	{
		this.clickAction = clickAction;
	}

	/**
	 * 获取notificationType
	 * 
	 * @return
	 */
	public NotificationType getNotificationType()
	{
		return notificationType;
	}

	/**
	 * 设置notificationType
	 * 
	 * @param notificationType
	 */
	public void setNotificationType(NotificationType notificationType)
	{
		this.notificationType = notificationType;
	}
}
