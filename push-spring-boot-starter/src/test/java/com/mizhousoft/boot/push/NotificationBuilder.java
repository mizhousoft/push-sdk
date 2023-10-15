package com.mizhousoft.boot.push;

import java.util.HashMap;
import java.util.Map;

import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.push.MessageCategory;
import com.mizhousoft.push.action.ClickAction;
import com.mizhousoft.push.action.IntentClickAction;
import com.mizhousoft.push.request.NotificationRequest;

/**
 * NotificationBuilder
 *
 * @version
 */
public abstract class NotificationBuilder
{
	public static final String TITLE = "问答新评论提醒";

	public static final String BODY = "你发布的问答有了新的评论，请及时查看哦";

	public static final String CHANNEL_ID = "pre213";

	public static NotificationRequest build(String... tokens) throws JSONException
	{
		int userId = 1;
		Map<String, Integer> tokenMap = new HashMap<>(2);
		for (String token : tokens)
		{
			tokenMap.put(token, userId);

			userId = userId + 1;
		}

		NotificationRequest request = new NotificationRequest();
		request.setTokenMap(tokenMap);
		request.setTitle(TITLE);
		request.setBody(BODY);
		request.setChannelId(CHANNEL_ID);
		request.setCategory(MessageCategory.CATEGORY_SOCIAL);

		ClickAction clickAction = new IntentClickAction();

		Map<String, Object> dataMap = buildBody();
		dataMap.forEach((key, value) -> clickAction.addExtProperty(key, value));

		request.setClickAction(clickAction);

		return request;
	}

	private static Map<String, Object> buildBody()
	{
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("actionUrl",
		        "https://developer.huawei.com/consumer/cn/doc/development/HMSCore-References-V5/https-send-api-0000001050986197-V5#ZH-CN_TOPIC_0000001050986197__section8686112674319");
		dataMap.put("type", 2);
		dataMap.put("company", "mizhousoft");

		return dataMap;
	}
}
