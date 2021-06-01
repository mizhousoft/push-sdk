package com.mizhousoft.push.action;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * ClickAction
 *
 * @version
 */
public abstract class ClickAction
{
	// 扩展数据
	private final HashMap<String, Object> extProperties = new HashMap<>(10);

	/**
	 * 增加扩展数据
	 * 
	 * @param key
	 * @param value
	 */
	public void addExtProperty(final String key, final Object value)
	{
		extProperties.put(key, value);
	}

	/**
	 * 获取extProperties
	 * 
	 * @return
	 */
	public Map<String, Object> getExtProperties()
	{
		return Collections.unmodifiableMap(extProperties);
	}
}
