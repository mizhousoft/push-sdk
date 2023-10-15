package com.mizhousoft.boot.push;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.push.PushProvider;
import com.mizhousoft.push.exception.PushException;
import com.mizhousoft.push.request.NotificationRequest;
import com.mizhousoft.push.result.PushResult;
import com.mizhousoft.push.union.UnifiedPushService;

/**
 * ViVoPushServiceImpl Test
 *
 * @version
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
public class TestViVoPushServiceImpl
{
	@Autowired
	private UnifiedPushService unifiedPushService;

	private PushProvider pushProvider = PushProvider.VIVO;

	private String token = "16089525960272241575710";

	@Test
	public void pushNotification() throws JSONException
	{
		NotificationRequest request = NotificationBuilder.build(token);

		try
		{
			PushResult result = unifiedPushService.pushNotification(pushProvider, request);

			Assertions.assertNotNull(result.getTraceId());
		}
		catch (PushException e)
		{
			Assertions.fail(e.getMessage());
		}
	}

	@Test
	public void pushNotifications() throws JSONException
	{
		String errorToken1 = "IQAAAACy05W_WlYU9cryX1-QfnYGA";
		NotificationRequest request = NotificationBuilder.build(token, errorToken1);

		try
		{
			PushResult result = unifiedPushService.pushNotification(pushProvider, request);

			Assertions.assertNotNull(result.getTraceId());
		}
		catch (PushException e)
		{
			Assertions.fail(e.getMessage());
		}
	}

	@Test
	public void pushErrorNotification() throws JSONException
	{
		String errorToken = "IQAAAACy05W_WlYU9cryX1-QfnYGA";
		NotificationRequest request = NotificationBuilder.build(errorToken);

		try
		{
			PushResult result = unifiedPushService.pushNotification(pushProvider, request);

			Assertions.assertNotNull(result.getTraceId());
		}
		catch (PushException e)
		{
			Assertions.fail(e.getMessage());
		}
	}

	@Test
	public void pushErrorNotifications() throws JSONException
	{
		String errorToken1 = "IQAAAACy05W_WlYU9cryX1-QfnYGA";
		String errorToken2 = "IQAAAACy05W_WlYU9cryX2-QfnYGA";
		NotificationRequest request = NotificationBuilder.build(errorToken1, errorToken2);

		try
		{
			PushResult result = unifiedPushService.pushNotification(pushProvider, request);

			Assertions.assertNotNull(result.getTraceId());
		}
		catch (PushException e)
		{
			Assertions.fail(e.getMessage());
		}
	}
}
