package com.mizhousoft.push.vivo;

import java.util.HashMap;
import java.util.Map;

/**
 * ResultCodeMap
 *
 * @version
 */
public class ViVoResultCodeMap
{
	private static final Map<Integer, String> codeMap = new HashMap<Integer, String>(20)
	{
		private static final long serialVersionUID = 6193823763554064295L;

		{
			put(10200, "appId is null.");
			put(10200, "appKey is null.");
			put(10200, "appKey is illegal.");
			put(10200, "timestamp is null.");
			put(10200, "sign is null.");
			put(10200, "appId does not exist.");
			put(10206, "sign is wrong.");
			put(10207, "timestamp is illegal.");
			put(10250, "The authentication interface exceeds the limit on the number of calls.");
		}
	};

	public static String getDescription(Integer code)
	{
		return codeMap.getOrDefault(code, "Unknown code");
	}
}
