package com.mizhousoft.boot.push.configuration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PreDestroy;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.mizhousoft.boot.push.protperties.ApplePushProperties;
import com.mizhousoft.boot.push.protperties.HauweiPushProperties;
import com.mizhousoft.boot.push.protperties.OppoPushProperties;
import com.mizhousoft.boot.push.protperties.ViVoPushProperties;
import com.mizhousoft.boot.push.protperties.XiaoMiPushProperties;
import com.mizhousoft.commons.restclient.service.RestClientService;
import com.mizhousoft.push.ProviderProfile;
import com.mizhousoft.push.PushProvider;
import com.mizhousoft.push.apple.config.AppleProfile;
import com.mizhousoft.push.exception.PushException;
import com.mizhousoft.push.huawei.config.HuaweiProfile;
import com.mizhousoft.push.oppo.config.OppoProfile;
import com.mizhousoft.push.union.UnifiedPushService;
import com.mizhousoft.push.union.impl.UnifiedPushServiceImpl;
import com.mizhousoft.push.vivo.config.ViVoProfile;
import com.mizhousoft.push.xiaomi.config.XiaoMiProfile;

/**
 * 配置
 *
 * @version
 */
@Configuration
public class PushConfiguration
{
	private static final Logger LOG = LoggerFactory.getLogger(PushConfiguration.class);

	String GENERIC_INTENT = "intent://com.mizhousoft.push/message?#Intent;scheme=mzspush;launchFlags=0x4000000;%s;end";

	String OPPO_INTENT = "mzspush://com.mizhousoft.push/message?%s";

	@Autowired
	private HauweiPushProperties hauweiPushProperties;

	@Autowired
	private OppoPushProperties oppoPushProperties;

	@Autowired
	private ViVoPushProperties viVoPushProperties;

	@Autowired
	private XiaoMiPushProperties xiaoMiPushProperties;

	@Autowired
	private ApplePushProperties applePushProperties;

	@Autowired
	private RestClientService restClientService;

	@Autowired
	private ResourceLoader resourceLoader;

	private UnifiedPushService unifiedPushService;

	@Bean
	public UnifiedPushService getUnifiedPushService() throws PushException
	{
		presetDefaultValue();

		Map<PushProvider, ProviderProfile> profileMap = buildProviderProfileMap();

		UnifiedPushServiceImpl unifiedPushService = new UnifiedPushServiceImpl(profileMap, restClientService);
		unifiedPushService.initialize();

		this.unifiedPushService = unifiedPushService;

		return unifiedPushService;
	}

	@PreDestroy
	public void destroy()
	{
		if (null != unifiedPushService)
		{
			try
			{
				unifiedPushService.release();
			}
			catch (PushException e)
			{
				LOG.error("Release push resource failed.", e);
			}
		}
	}

	private void presetDefaultValue()
	{
		if (StringUtils.isBlank(hauweiPushProperties.getIntentFormat()))
		{
			hauweiPushProperties.setIntentFormat(GENERIC_INTENT);
		}

		if (StringUtils.isBlank(oppoPushProperties.getIntentFormat()))
		{
			oppoPushProperties.setIntentFormat(OPPO_INTENT);
		}

		if (StringUtils.isBlank(viVoPushProperties.getIntentFormat()))
		{
			viVoPushProperties.setIntentFormat(GENERIC_INTENT);
		}

		if (StringUtils.isBlank(xiaoMiPushProperties.getIntentFormat()))
		{
			xiaoMiPushProperties.setIntentFormat(GENERIC_INTENT);
		}
	}

	private Map<PushProvider, ProviderProfile> buildProviderProfileMap() throws PushException
	{
		Map<PushProvider, ProviderProfile> profileMap = new HashMap<>(5);

		if (!StringUtils.isBlank(hauweiPushProperties.getAppId()))
		{
			HuaweiProfile huaweiProfile = new HuaweiProfile();
			huaweiProfile.setAppId(hauweiPushProperties.getAppId());
			huaweiProfile.setAppSecret(hauweiPushProperties.getAppSecret());
			huaweiProfile.setIntentFormat(hauweiPushProperties.getIntentFormat());
			profileMap.put(PushProvider.HUAWEI, huaweiProfile);
		}

		if (!StringUtils.isBlank(oppoPushProperties.getAppKey()))
		{
			OppoProfile oppoProfile = new OppoProfile();
			oppoProfile.setAppKey(oppoPushProperties.getAppKey());
			oppoProfile.setMasterSecret(oppoPushProperties.getMasterSecret());
			oppoProfile.setIntentFormat(oppoPushProperties.getIntentFormat());
			profileMap.put(PushProvider.OPPO, oppoProfile);
		}

		if (!StringUtils.isBlank(viVoPushProperties.getAppSecret()))
		{
			ViVoProfile vivoProfile = new ViVoProfile();
			vivoProfile.setAppId(viVoPushProperties.getAppId());
			vivoProfile.setAppSecret(viVoPushProperties.getAppSecret());
			vivoProfile.setAppKey(viVoPushProperties.getAppKey());
			vivoProfile.setIntentFormat(viVoPushProperties.getIntentFormat());
			vivoProfile.setSandbox(viVoPushProperties.isSandbox());
			profileMap.put(PushProvider.VIVO, vivoProfile);
		}

		if (!StringUtils.isBlank(xiaoMiPushProperties.getAppSecret()))
		{
			XiaoMiProfile xiaomiProfile = new XiaoMiProfile();
			xiaomiProfile.setAppId(xiaoMiPushProperties.getAppId());
			xiaomiProfile.setAppSecret(xiaoMiPushProperties.getAppSecret());
			xiaomiProfile.setIntentFormat(xiaoMiPushProperties.getIntentFormat());
			xiaomiProfile.setPackageNames(xiaoMiPushProperties.getPackageNames());
			profileMap.put(PushProvider.XIAOMI, xiaomiProfile);
		}

		if (!StringUtils.isBlank(applePushProperties.getBundleIdentifier()))
		{
			Resource resource = resourceLoader.getResource("classpath:" + applePushProperties.getPkcs8File());
			if (null != resource && resource.isFile())
			{
				try
				{
					File file = resource.getFile();
					AppleProfile appleProfile = new AppleProfile();
					appleProfile.setBundleIdentifier(applePushProperties.getBundleIdentifier());
					appleProfile.setKeyId(applePushProperties.getKeyId());
					appleProfile.setPkcs8File(file);
					appleProfile.setSandbox(applePushProperties.isSandbox());
					appleProfile.setTeamId(applePushProperties.getTeamId());

					profileMap.put(PushProvider.APPLE, appleProfile);
				}
				catch (IOException e)
				{
					throw new PushException(
					        "Load apple pkcs8 file failed, bundle identifier is " + applePushProperties.getBundleIdentifier(), e);
				}
			}
			else
			{
				LOG.error("Load apple pkcs8 file failed, bundle identifier is " + applePushProperties.getBundleIdentifier());
			}
		}

		return profileMap;
	}
}
