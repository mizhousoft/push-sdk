package com.mizhousoft.boot.push;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.mizhousoft.push.request.MessageRequest;

/**
 * MessageBuilder
 *
 * @version
 */
public abstract class MessageBuilder
{
	public static MessageRequest build(String... tokens)
	{
		Set<String> tokenSet = new HashSet<>(2);
		for (String token : tokens)
		{
			tokenSet.add(token);
		}

		Map<String, String> dataMap = new HashMap<>();
		dataMap.put("test123", "test123");
		dataMap.put("abs", "https://developer.huawei.com/consumer/cn/service/josp/agc/index.html#/myProject/103527205/9249519184595935885");

		MessageRequest request = new MessageRequest();
		request.setTokens(tokenSet);
		request.setDataMap(dataMap);

		return request;
	}

}
