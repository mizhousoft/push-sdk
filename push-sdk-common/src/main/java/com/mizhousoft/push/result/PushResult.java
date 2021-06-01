package com.mizhousoft.push.result;

import java.util.HashSet;
import java.util.Set;

/**
 * 通知结果
 *
 * @version
 */
public class PushResult
{
	// 追踪ID
	private final String traceId;

	// 非法Token
	private final Set<String> illegalTokens;

	public PushResult(String traceId)
	{
		super();
		this.traceId = traceId;
		this.illegalTokens = new HashSet<>(0);
	}

	public PushResult(String traceId, Set<String> illegalTokens)
	{
		super();
		this.traceId = traceId;

		if (null == illegalTokens)
		{
			this.illegalTokens = new HashSet<>(0);
		}
		else
		{
			this.illegalTokens = illegalTokens;
		}
	}

	/**
	 * 获取traceId
	 * 
	 * @return
	 */
	public String getTraceId()
	{
		return traceId;
	}

	/**
	 * 获取illegalTokens
	 * 
	 * @return
	 */
	public Set<String> getIllegalTokens()
	{
		return illegalTokens;
	}
}
