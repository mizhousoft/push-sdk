package com.mizhousoft.push.xiaomi.internal.response;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 推送结果
 *
 * @version
 */
public class MiMessagePushResponse
{
	// 结果，"ok" 表示成功，,"error" 表示失败
	@JsonProperty("result")
	private String result;

	// 对发送消息失败原因的解释。
	@JsonProperty("description")
	private String description;

	// 原因
	@JsonProperty("reason")
	private String reason;

	// 本身就是一个json字符串（其中id字段的值就是消息的Id）。
	@JsonProperty("data")
	private MiDataResponse data;

	// 0表示成功，非0表示失败。
	@JsonProperty("code")
	private int code;

	// 详细信息。
	@JsonProperty("info")
	private String info;

	// 追踪ID
	@JsonProperty("trace_id")
	private String traceId;

	public Set<String> getIllegalTokens()
	{
		Set<String> result = new HashSet<>(0);

		if (null != data)
		{
			String badRegIds = data.getBadRegIds();
			if (null != badRegIds)
			{
				String[] ids = badRegIds.split(",");
				List<String> list = Arrays.asList(ids);
				result.addAll(list);
			}
		}

		return result;
	}

	/**
	 * 获取result
	 * 
	 * @return
	 */
	public String getResult()
	{
		return result;
	}

	/**
	 * 设置result
	 * 
	 * @param result
	 */
	public void setResult(String result)
	{
		this.result = result;
	}

	/**
	 * 获取description
	 * 
	 * @return
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * 设置description
	 * 
	 * @param description
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * 获取code
	 * 
	 * @return
	 */
	public int getCode()
	{
		return code;
	}

	/**
	 * 设置code
	 * 
	 * @param code
	 */
	public void setCode(int code)
	{
		this.code = code;
	}

	/**
	 * 获取info
	 * 
	 * @return
	 */
	public String getInfo()
	{
		return info;
	}

	/**
	 * 设置info
	 * 
	 * @param info
	 */
	public void setInfo(String info)
	{
		this.info = info;
	}

	/**
	 * 获取reason
	 * 
	 * @return
	 */
	public String getReason()
	{
		return reason;
	}

	/**
	 * 设置reason
	 * 
	 * @param reason
	 */
	public void setReason(String reason)
	{
		this.reason = reason;
	}

	/**
	 * 获取data
	 * 
	 * @return
	 */
	public MiDataResponse getData()
	{
		return data;
	}

	/**
	 * 设置data
	 * 
	 * @param data
	 */
	public void setData(MiDataResponse data)
	{
		this.data = data;
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
	 * 设置traceId
	 * 
	 * @param traceId
	 */
	public void setTraceId(String traceId)
	{
		this.traceId = traceId;
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
		if (result != null)
		{
			builder.append("result\":\"");
			builder.append(result);
			builder.append("\", \"");
		}
		if (description != null)
		{
			builder.append("description\":\"");
			builder.append(description);
			builder.append("\", \"");
		}
		if (data != null)
		{
			builder.append("data\":\"");
			builder.append(data);
			builder.append("\", \"");
		}
		builder.append("code\":\"");
		builder.append(code);
		builder.append("\", \"");
		if (info != null)
		{
			builder.append("info\":\"");
			builder.append(info);
			builder.append("\", \"");
		}
		if (traceId != null)
		{
			builder.append("traceId\":\"");
			builder.append(traceId);
		}
		builder.append("\"}");
		return builder.toString();
	}
}
