package com.mizhousoft.push.union.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.collections4.SetUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mizhousoft.commons.restclient.service.RestClientService;
import com.mizhousoft.push.ProviderProfile;
import com.mizhousoft.push.ProviderPushService;
import com.mizhousoft.push.PushProvider;
import com.mizhousoft.push.apple.config.AppleProfile;
import com.mizhousoft.push.apple.impl.ApplePushServiceImpl;
import com.mizhousoft.push.exception.PushException;
import com.mizhousoft.push.huawei.config.HuaweiProfile;
import com.mizhousoft.push.huawei.impl.HuaweiPushServiceImpl;
import com.mizhousoft.push.oppo.config.OppoProfile;
import com.mizhousoft.push.oppo.impl.OppoPushServiceImpl;
import com.mizhousoft.push.request.MessageRequest;
import com.mizhousoft.push.request.NotificationRequest;
import com.mizhousoft.push.result.PushResult;
import com.mizhousoft.push.umeng.config.UMengProfile;
import com.mizhousoft.push.umeng.impl.UMengPushServiceImpl;
import com.mizhousoft.push.union.UnifiedPushService;
import com.mizhousoft.push.union.util.PushLogger;
import com.mizhousoft.push.vivo.config.ViVoProfile;
import com.mizhousoft.push.vivo.impl.ViVoPushServiceImpl;
import com.mizhousoft.push.xiaomi.config.XiaoMiProfile;
import com.mizhousoft.push.xiaomi.impl.XiaoMiPushServiceImpl;

/**
 * 统一的推送服务
 *
 * @version
 */
public class UnifiedPushServiceImpl implements UnifiedPushService
{
	private static final Logger LOG = LoggerFactory.getLogger(UnifiedPushServiceImpl.class);

	private Map<PushProvider, ProviderPushService> pushServiceMap = new HashMap<>(5);

	public UnifiedPushServiceImpl(Map<PushProvider, ProviderProfile> profileMap, RestClientService restClientService)
	{
		ProviderProfile hwProfile = profileMap.get(PushProvider.HUAWEI);
		if (null != hwProfile)
		{
			HuaweiProfile profile = (HuaweiProfile) hwProfile;
			HuaweiPushServiceImpl huaweiPushService = new HuaweiPushServiceImpl(profile, restClientService);
			pushServiceMap.put(PushProvider.HUAWEI, huaweiPushService);

			LOG.info("Create Huawei push service, app id is {}.", profile.getAppId());
		}

		ProviderProfile oppoProfile = profileMap.get(PushProvider.OPPO);
		if (null != oppoProfile)
		{
			OppoProfile profile = (OppoProfile) oppoProfile;
			OppoPushServiceImpl oppoPushService = new OppoPushServiceImpl(profile, restClientService);
			pushServiceMap.put(PushProvider.OPPO, oppoPushService);

			LOG.info("Create Oppo push service, app key is {}.", profile.getAppKey());
		}

		ProviderProfile vivoProfile = profileMap.get(PushProvider.VIVO);
		if (null != vivoProfile)
		{
			ViVoProfile profile = (ViVoProfile) vivoProfile;
			ViVoPushServiceImpl viVoPushService = new ViVoPushServiceImpl(profile, restClientService);
			pushServiceMap.put(PushProvider.VIVO, viVoPushService);

			LOG.info("Create ViVo push service, app id is {}.", profile.getAppId());
		}

		ProviderProfile xiaomiProfile = profileMap.get(PushProvider.XIAOMI);
		if (null != xiaomiProfile)
		{
			XiaoMiProfile profile = (XiaoMiProfile) xiaomiProfile;
			XiaoMiPushServiceImpl xiaoMiPushService = new XiaoMiPushServiceImpl(profile, restClientService);
			pushServiceMap.put(PushProvider.XIAOMI, xiaoMiPushService);

			LOG.info("Create Xiaomi push service, app id is {}.", profile.getAppId());
		}

		ProviderProfile appleProfile = profileMap.get(PushProvider.APPLE);
		if (null != appleProfile)
		{
			AppleProfile profile = (AppleProfile) appleProfile;
			ApplePushServiceImpl applePushService = new ApplePushServiceImpl(profile);
			pushServiceMap.put(PushProvider.APPLE, applePushService);

			LOG.info("Create Apple push service, app id is {}.", profile.getBundleIdentifier());
		}

		ProviderProfile umengProfile = profileMap.get(PushProvider.UMENG);
		if (null != umengProfile)
		{
			UMengProfile profile = (UMengProfile) umengProfile;
			UMengPushServiceImpl umengPushService = new UMengPushServiceImpl(profile, restClientService);
			pushServiceMap.put(PushProvider.UMENG, umengPushService);

			LOG.info("Create UMeng push service, app id is {}.", profile.getAppId());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PushResult pushNotification(PushProvider provider, NotificationRequest request) throws PushException
	{
		if (null == provider)
		{
			LOG.warn("Provider push service not found, provider is null.");
			return null;
		}

		ProviderPushService pushService = pushServiceMap.get(provider);
		if (null == pushService)
		{
			LOG.warn("Provider push service not found, provider is {}.", provider);
			return null;
		}

		Map<String, Integer> tokenMap = request.getTokenMap();
		if (MapUtils.isEmpty(tokenMap))
		{
			return null;
		}

		if (pushService.isSupportMultiSend())
		{
			return doPushNotification(provider, request, pushService);
		}
		else
		{
			String traceId = null;
			Set<String> illegalTokens = new HashSet<>(10);

			Map<String, Integer> newTokenMap = new HashMap<>(tokenMap);
			Iterator<Entry<String, Integer>> iter = newTokenMap.entrySet().iterator();
			while (iter.hasNext())
			{
				Entry<String, Integer> entry = iter.next();

				request.getTokenMap().clear();
				request.getTokenMap().put(entry.getKey(), entry.getValue());

				PushResult singleResult = doPushNotification(provider, request, pushService);
				if (null == traceId)
				{
					traceId = singleResult.getTraceId();
				}

				Set<String> values = SetUtils.emptyIfNull(singleResult.getIllegalTokens());
				illegalTokens.addAll(values);
			}

			return new PushResult(traceId, illegalTokens);
		}
	}

	private PushResult doPushNotification(PushProvider provider, NotificationRequest request, ProviderPushService pushService)
	        throws PushException
	{
		try
		{
			PushResult result = pushService.pushNotification(request);

			PushLogger.log(provider, request, result);

			return result;
		}
		catch (PushException e)
		{
			throw e;
		}
		catch (Throwable e)
		{
			throw new PushException("Push notification failed.", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PushResult pushMessage(PushProvider provider, MessageRequest request) throws PushException
	{
		if (null == provider)
		{
			LOG.warn("Provider push service not found, provider is null.");
			return null;
		}

		ProviderPushService pushService = pushServiceMap.get(provider);
		if (null == pushService)
		{
			LOG.warn("Provider push service not found, provider is {}.", provider);
			return null;
		}

		try
		{
			PushResult result = pushService.pushMessage(request);
			return result;
		}
		catch (PushException e)
		{
			throw e;
		}
		catch (Throwable e)
		{
			throw new PushException("Push message failed.", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initialize() throws PushException
	{
		Iterator<Entry<PushProvider, ProviderPushService>> iter = pushServiceMap.entrySet().iterator();
		while (iter.hasNext())
		{
			Entry<PushProvider, ProviderPushService> entry = iter.next();
			ProviderPushService pushService = entry.getValue();

			pushService.initialize();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void release() throws PushException
	{
		Iterator<Entry<PushProvider, ProviderPushService>> iter = pushServiceMap.entrySet().iterator();
		while (iter.hasNext())
		{
			Entry<PushProvider, ProviderPushService> entry = iter.next();
			ProviderPushService pushService = entry.getValue();

			pushService.release();
		}
	}
}
