package com.mizhousoft.push.union.util;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mizhousoft.commons.lang.SetUtils;
import com.mizhousoft.push.PushProvider;
import com.mizhousoft.push.request.NotificationRequest;
import com.mizhousoft.push.result.PushResult;

/**
 * 推送日子
 *
 * @version
 */
public abstract class PushLogger
{
	private static final Logger LOG = LoggerFactory.getLogger("Push");

	private static final String VERSION = "v1";

	private static final String DELIMITER = "|";

	private static final String T = "T";

	private static final String F = "F";

	public static void log(PushProvider provider, NotificationRequest request, PushResult result)
	{
		String traceId = StringUtils.defaultString(result.getTraceId());
		String channelId = request.getChannelId();

		Set<String> tokens = request.getTokens();
		Set<String> illegalTokens = SetUtils.emptyIfNull(result.getIllegalTokens());

		List<String> succeedTokens = tokens.stream().filter(item -> !illegalTokens.contains(item)).collect(Collectors.toList());

		Map<String, Integer> tokenMap = request.getTokenMap();

		for (String succeedToken : succeedTokens)
		{
			Integer userId = tokenMap.get(succeedToken);

			StringBuilder buf = new StringBuilder();
			buf.append(VERSION).append(DELIMITER).append(provider.getValue()).append(DELIMITER).append(userId).append(DELIMITER).append(T)
			        .append(DELIMITER).append(traceId).append(DELIMITER).append(channelId);

			LOG.info(buf.toString());
		}

		for (String illegalToken : illegalTokens)
		{
			Integer userId = tokenMap.get(illegalToken);

			StringBuilder buf = new StringBuilder();
			buf.append(VERSION).append(DELIMITER).append(provider.getValue()).append(DELIMITER).append(userId).append(DELIMITER).append(F)
			        .append(DELIMITER).append(traceId).append(DELIMITER).append(channelId);

			LOG.info(buf.toString());
		}
	}
}
