package com.mizhousoft.push.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.util.UriUtils;

/**
 * 工具类
 *
 * @version
 */
public abstract class IntentUtils
{
	public static String formatIntent(String intentFormat, Map<String, Object> extProperties)
	{
		Map<String, Object> newMap = new HashMap<>(extProperties.size());
		extProperties.forEach((key, value) -> newMap.put("S." + key, value));

		Map<String, String> encodeValues = UriUtils.encodeUriVariables(newMap);

		String query = StringUtils.join(encodeValues.entrySet().iterator(), ";");
		String intent = String.format(intentFormat, query);

		return intent;
	}

	public static String formatOppoIntent(String intentFormat, Map<String, Object> extProperties)
	{
		Map<String, String> encodeValues = UriUtils.encodeUriVariables(extProperties);

		String query = StringUtils.join(encodeValues.entrySet().iterator(), "&");
		String intent = String.format(intentFormat, query);

		return intent;
	}
}
