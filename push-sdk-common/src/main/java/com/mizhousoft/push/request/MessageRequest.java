package com.mizhousoft.push.request;

import java.util.Map;
import java.util.Set;

/**
 * 推送消息请求
 *
 * @version
 */
public class MessageRequest
{
	// 数据集合
	private Map<String, String> dataMap;

	// 设备token
	private Set<String> tokens;

	/**
	 * 获取dataMap
	 * 
	 * @return
	 */
	public Map<String, String> getDataMap()
	{
		return dataMap;
	}

	/**
	 * 设置dataMap
	 * 
	 * @param dataMap
	 */
	public void setDataMap(Map<String, String> dataMap)
	{
		this.dataMap = dataMap;
	}

	/**
	 * 获取tokens
	 * 
	 * @return
	 */
	public Set<String> getTokens()
	{
		return tokens;
	}

	/**
	 * 设置tokens
	 * 
	 * @param tokens
	 */
	public void setTokens(Set<String> tokens)
	{
		this.tokens = tokens;
	}
}
