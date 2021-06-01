package com.mizhousoft.push.oppo.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.mizhousoft.push.oppo.constant.OppoConstants;
import com.mizhousoft.push.oppo.internal.OppoNotification;

/**
 * 工具类
 *
 * @version
 */
public abstract class OppoMessageUtils
{
	public static Map<String, Object> buildNotificationParams(OppoNotification notification)
	{
		Map<String, Object> parameters = new HashMap<String, Object>(32);

		parameters.put(OppoConstants.PARAM_TITLE, notification.getTitle());
		parameters.put(OppoConstants.PARAM_CONTENT, notification.getContent());

		if (notification.getStyle() != null)
		{
			parameters.put(OppoConstants.PARAM_STYLE, notification.getStyle());
		}

		if (!StringUtils.isBlank(notification.getBigPictureId()))
		{
			parameters.put(OppoConstants.PARAM_BIG_PICTURE_ID, notification.getBigPictureId());
		}

		if (!StringUtils.isBlank(notification.getSmallPictureId()))
		{
			parameters.put(OppoConstants.PARAM_SMALL_PICTURE_ID, notification.getSmallPictureId());
		}

		if (!StringUtils.isBlank(notification.getSubTitle()))
		{
			parameters.put(OppoConstants.PARAM_SUB_TITLE, notification.getSubTitle());
		}

		if (notification.getChannelId() != null)
		{
			parameters.put(OppoConstants.PARAM_CHANNEL_ID, notification.getChannelId());
		}

		if (!StringUtils.isBlank(notification.getAppMessageId()))
		{
			parameters.put(OppoConstants.PARAM_APP_MESSAGE_ID, notification.getAppMessageId());
		}

		if (notification.getClickActionType() != null)
		{
			parameters.put(OppoConstants.PARAM_CLICK_ACTION_TYPE, notification.getClickActionType());
		}

		if (!StringUtils.isBlank(notification.getClickActionActivity()))
		{
			parameters.put(OppoConstants.PARAM_CLICK_ACTION_ACTIVITY, notification.getClickActionActivity());
		}

		if (!StringUtils.isBlank(notification.getClickActionUrl()))
		{
			parameters.put(OppoConstants.PARAM_CLICK_ACTION_URL, notification.getClickActionUrl());
		}

		if (!StringUtils.isBlank(notification.getActionParameters()))
		{
			parameters.put(OppoConstants.PARAM_ACTION_PARAMETERS, notification.getActionParameters());
		}

		if (notification.getShowTimeType() != null)
		{
			parameters.put(OppoConstants.PARAM_SHOW_TIME_TYPE, notification.getShowTimeType());
		}

		if (notification.getShowStartTime() != null)
		{
			parameters.put(OppoConstants.PARAM_SHOW_START_TIME, notification.getShowStartTime());
		}

		if (notification.getShowEndTime() != null)
		{
			parameters.put(OppoConstants.PARAM_SHOW_END_TIME, notification.getShowEndTime());
		}

		if (notification.getOffLine() != null)
		{
			parameters.put(OppoConstants.PARAM_OFF_LINE, notification.getOffLine());
		}

		if (notification.getOffLineTtl() != null)
		{
			parameters.put(OppoConstants.PARAM_OFF_LINE_TTL, notification.getOffLineTtl());
		}

		if (notification.getPushTimeType() != null)
		{
			parameters.put(OppoConstants.PARAM_PUSH_TIME_TYPE, notification.getPushTimeType());
		}

		if (!StringUtils.isBlank(notification.getTimeZone()))
		{
			parameters.put(OppoConstants.PARAM_TIME_ZONE, notification.getTimeZone());
		}

		if (notification.getNetworkType() != null)
		{
			parameters.put(OppoConstants.PARAM_NETWORK_TYPE, notification.getNetworkType());
		}

		if (!StringUtils.isBlank(notification.getCallBackUrl()))
		{
			parameters.put(OppoConstants.PARAM_CALL_BACK_URL, notification.getCallBackUrl());
		}

		if (!StringUtils.isBlank(notification.getCallBackParameter()))
		{
			parameters.put(OppoConstants.PARAM_CALL_BACK_PARAMETER, notification.getCallBackParameter());
		}

		if (notification.getShowTtl() != null)
		{
			parameters.put(OppoConstants.PARAM_SHOW_TTL, notification.getShowTtl());
		}

		if (notification.getNotifyId() != null)
		{
			parameters.put(OppoConstants.PARAM_NOTIFY_ID, notification.getNotifyId());
		}

		return parameters;
	}
}
