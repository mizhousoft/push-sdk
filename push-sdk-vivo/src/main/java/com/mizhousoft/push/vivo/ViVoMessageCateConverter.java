package com.mizhousoft.push.vivo;

import com.mizhousoft.push.MessageCategory;
import com.mizhousoft.push.vivo.constant.ViVoConstants;

/**
 * 消息转换器
 *
 */
public abstract class ViVoMessageCateConverter
{
	public static String convert(String requestData)
	{
		if (MessageCategory.CATEGORY_IM.equals(requestData))
		{
			return ViVoConstants.SYSTEM_CATEGORY_IM;
		}
		else if (MessageCategory.CATEGORY_ACCOUNT.equals(requestData))
		{
			return ViVoConstants.SYSTEM_CATEGORY_ACCOUNT;
		}
		else if (MessageCategory.CATEGORY_TODO.equals(requestData))
		{
			return ViVoConstants.SYSTEM_CATEGORY_TODO;
		}
		else if (MessageCategory.CATEGORY_DEVICE_REMINDER.equals(requestData))
		{
			return ViVoConstants.SYSTEM_CATEGORY_DEVICE_REMINDER;
		}
		else if (MessageCategory.CATEGORY_ORDER.equals(requestData))
		{
			return ViVoConstants.SYSTEM_CATEGORY_ORDER;
		}
		else if (MessageCategory.CATEGORY_SUBSCRIPTION.equals(requestData))
		{
			return ViVoConstants.SYSTEM_CATEGORY_SUBSCRIPTION;
		}
		else if (MessageCategory.CATEGORY_NEWS.equals(requestData))
		{
			return ViVoConstants.OPERATION_CATEGORY_NEWS;
		}
		else if (MessageCategory.CATEGORY_CONTENT.equals(requestData))
		{
			return ViVoConstants.OPERATION_CATEGORY_CONTENT;
		}
		else if (MessageCategory.CATEGORY_MARKETING.equals(requestData))
		{
			return ViVoConstants.OPERATION_CATEGORY_MARKETING;
		}
		else if (MessageCategory.CATEGORY_SOCIAL.equals(requestData))
		{
			return ViVoConstants.OPERATION_CATEGORY_SOCIAL;
		}
		else
		{
			return ViVoConstants.OPERATION_CATEGORY_SOCIAL;
		}
	}
}
