package com.mizhousoft.push.xiaomi.internal.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 数据结果
 *
 * @version
 */
public class MiDataResponse
{
	// ID
	@JsonProperty("id")
	private String id;

	// ID，多个以英文逗号拼接
	@JsonProperty("bad_regids")
	private String badRegIds;

	@JsonProperty("day_acked")
	private String dayAcked;

	@JsonProperty("day_quota")
	private String dayQuota;

	/**
	 * 获取id
	 * 
	 * @return
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * 设置id
	 * 
	 * @param id
	 */
	public void setId(String id)
	{
		this.id = id;
	}

	/**
	 * 获取badRegIds
	 * 
	 * @return
	 */
	public String getBadRegIds()
	{
		return badRegIds;
	}

	/**
	 * 设置badRegIds
	 * 
	 * @param badRegIds
	 */
	public void setBadRegIds(String badRegIds)
	{
		this.badRegIds = badRegIds;
	}

	/**
	 * 获取dayAcked
	 * 
	 * @return
	 */
	public String getDayAcked()
	{
		return dayAcked;
	}

	/**
	 * 设置dayAcked
	 * 
	 * @param dayAcked
	 */
	public void setDayAcked(String dayAcked)
	{
		this.dayAcked = dayAcked;
	}

	/**
	 * 获取dayQuota
	 * 
	 * @return
	 */
	public String getDayQuota()
	{
		return dayQuota;
	}

	/**
	 * 设置dayQuota
	 * 
	 * @param dayQuota
	 */
	public void setDayQuota(String dayQuota)
	{
		this.dayQuota = dayQuota;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("{\"");
		if (id != null)
		{
			builder.append("id\":\"");
			builder.append(id);
			builder.append("\", \"");
		}
		if (badRegIds != null)
		{
			builder.append("badRegIds\":\"");
			builder.append(badRegIds);
			builder.append("\", \"");
		}
		if (dayAcked != null)
		{
			builder.append("dayAcked\":\"");
			builder.append(dayAcked);
			builder.append("\", \"");
		}
		if (dayQuota != null)
		{
			builder.append("dayQuota\":\"");
			builder.append(dayQuota);
		}
		builder.append("\"}");
		return builder.toString();
	}
}
