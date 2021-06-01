package com.mizhousoft.push.apple.impl;

import java.time.Instant;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eatthepath.pushy.apns.ApnsClient;
import com.eatthepath.pushy.apns.ApnsClientBuilder;
import com.eatthepath.pushy.apns.DeliveryPriority;
import com.eatthepath.pushy.apns.PushNotificationResponse;
import com.eatthepath.pushy.apns.PushType;
import com.eatthepath.pushy.apns.auth.ApnsSigningKey;
import com.eatthepath.pushy.apns.util.ApnsPayloadBuilder;
import com.eatthepath.pushy.apns.util.SimpleApnsPayloadBuilder;
import com.eatthepath.pushy.apns.util.SimpleApnsPushNotification;
import com.eatthepath.pushy.apns.util.concurrent.PushNotificationFuture;
import com.mizhousoft.push.action.ClickAction;
import com.mizhousoft.push.apple.ApplePushService;
import com.mizhousoft.push.apple.config.AppleProfile;
import com.mizhousoft.push.exception.PushException;
import com.mizhousoft.push.request.NotificationRequest;
import com.mizhousoft.push.result.PushResult;
import com.mizhousoft.push.validator.RequestValidator;

/**
 * 苹果推送服务
 *
 * @version
 */
public class ApplePushServiceImpl implements ApplePushService
{
	private static final Logger LOG = LoggerFactory.getLogger(ApplePushServiceImpl.class);

	// 凭证
	private AppleProfile profile;

	// ApnsClient
	private ApnsClient apnsClient;

	/**
	 * 构造函数
	 *
	 * @param profile
	 * @throws PushException
	 */
	public ApplePushServiceImpl(AppleProfile profile)
	{
		super();
		this.profile = profile;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isSupportMultiSend()
	{
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PushResult pushNotification(NotificationRequest request) throws PushException
	{
		RequestValidator.validate(request);

		Set<String> tokens = request.getTokens();
		if (tokens.size() != 1)
		{
			throw new PushException("Token too many, can not exceed 1.");
		}

		return sendOneNotification(request, tokens.iterator().next());
	}

	/**
	 * 发送单个
	 * 
	 * @param request
	 * @param token
	 * @return
	 * @throws PushException
	 */
	private PushResult sendOneNotification(NotificationRequest request, String token) throws PushException
	{
		try
		{
			final ApnsPayloadBuilder payloadBuilder = new SimpleApnsPayloadBuilder();
			payloadBuilder.setAlertTitle(request.getTitle());
			payloadBuilder.setAlertBody(request.getBody());
			payloadBuilder.setSound(SimpleApnsPayloadBuilder.DEFAULT_SOUND_FILENAME);

			ClickAction action = request.getClickAction();
			Map<String, Object> extProperties = action.getExtProperties();
			extProperties.forEach((key, value) -> payloadBuilder.addCustomProperty(key, value));

			final String payload = payloadBuilder.build();

			String topic = profile.getBundleIdentifier();

			SimpleApnsPushNotification pushNotification = new SimpleApnsPushNotification(token, topic, payload,
			        Instant.now().plus(SimpleApnsPushNotification.DEFAULT_EXPIRATION_PERIOD), DeliveryPriority.IMMEDIATE, PushType.ALERT,
			        null, null);

			PushNotificationFuture<SimpleApnsPushNotification, PushNotificationResponse<SimpleApnsPushNotification>> future = apnsClient
			        .sendNotification(pushNotification);

			final PushNotificationResponse<SimpleApnsPushNotification> response = future.get(10, TimeUnit.SECONDS);

			LOG.info("Push response is {}.", response);

			String traceId = response.getApnsId().toString();
			if (response.isAccepted())
			{
				return new PushResult(traceId);
			}
			else
			{
				String error = response.getRejectionReason();

				Instant instant = response.getTokenInvalidationTimestamp().orElse(null);
				if (null != instant)
				{
					error = error + ", token invalidation time is " + instant;
				}

				Set<String> illegalTokens = new HashSet<>(1);
				illegalTokens.add(token);
				return new PushResult(traceId, illegalTokens);
			}
		}
		catch (Exception e)
		{
			throw new PushException("Push notification failed.", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initialize() throws PushException
	{
		try
		{
			ApnsSigningKey signingKey = ApnsSigningKey.loadFromPkcs8File(profile.getPkcs8File(), profile.getTeamId(), profile.getKeyId());

			String host = profile.isSandbox() ? ApnsClientBuilder.DEVELOPMENT_APNS_HOST : ApnsClientBuilder.PRODUCTION_APNS_HOST;
			apnsClient = new ApnsClientBuilder().setApnsServer(host).setSigningKey(signingKey).build();
		}
		catch (Throwable e)
		{
			throw new PushException("Initialize apns client failed.", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void release() throws PushException
	{
		if (null != apnsClient)
		{
			CompletableFuture<Void> closeFuture = apnsClient.close();

			try
			{
				closeFuture.get(5, TimeUnit.SECONDS);
			}
			catch (Throwable e)
			{
				LOG.error("Close apns client failed.", e);
			}
		}
	}
}
