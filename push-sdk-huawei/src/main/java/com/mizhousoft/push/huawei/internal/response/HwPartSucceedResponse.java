package com.mizhousoft.push.huawei.internal.response;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 部分成功响应
 *
 * @version
 */
public class HwPartSucceedResponse
{
	// 成功数量
	@JsonProperty("success")
	private int successNum;

	// 失败数量
	@JsonProperty("failure")
	private int failureNum;

	// 非法Token
	@JsonProperty("illegal_tokens")
	private Set<String> illegalTokens;

	/**
	 * 获取successNum
	 * 
	 * @return
	 */
	public int getSuccessNum()
	{
		return successNum;
	}

	/**
	 * 设置successNum
	 * 
	 * @param successNum
	 */
	public void setSuccessNum(int successNum)
	{
		this.successNum = successNum;
	}

	/**
	 * 获取failureNum
	 * 
	 * @return
	 */
	public int getFailureNum()
	{
		return failureNum;
	}

	/**
	 * 设置failureNum
	 * 
	 * @param failureNum
	 */
	public void setFailureNum(int failureNum)
	{
		this.failureNum = failureNum;
	}

	/**
	 * 获取illegalTokens
	 * @return
	 */
	public Set<String> getIllegalTokens()
	{
		return illegalTokens;
	}

	/**
	 * 设置illegalTokens
	 * @param illegalTokens
	 */
	public void setIllegalTokens(Set<String> illegalTokens)
	{
		this.illegalTokens = illegalTokens;
	}
}
