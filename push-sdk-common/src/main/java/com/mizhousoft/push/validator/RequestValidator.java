package com.mizhousoft.push.validator;

import com.mizhousoft.push.action.ClickAction;
import com.mizhousoft.push.action.IntentClickAction;
import com.mizhousoft.push.exception.PushException;
import com.mizhousoft.push.request.NotificationRequest;
import com.mizhousoft.push.util.PushAsserts;

/**
 * 校验器
 *
 * @version
 */
public abstract class RequestValidator
{
	public static void validate(NotificationRequest request) throws PushException
	{
		PushAsserts.notEmpty(request.getTitle(), "Request title is null.");
		PushAsserts.notEmpty(request.getBody(), "Request body is null.");
		PushAsserts.notEmpty(request.getTokens(), "Request tokens is null.");
		PushAsserts.notNull(request.getClickAction(), "Request clickAction is null.");

		ClickAction action = request.getClickAction();
		if (action instanceof IntentClickAction)
		{
			PushAsserts.notEmpty(action.getExtProperties(), "Request payload is null.");
		}
		else
		{
			throw new PushException("Action not support.");
		}
	}
}
