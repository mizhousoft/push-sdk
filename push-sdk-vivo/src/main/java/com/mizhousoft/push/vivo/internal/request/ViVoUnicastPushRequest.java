package com.mizhousoft.push.vivo.internal.request;

import java.util.Map;

/**
 * 单播推送请求
 *
 * @version
 */
public class ViVoUnicastPushRequest extends BaseViVoPushRequest
{
	// 应用订阅PUSH服务器得到的id 长度23个字符（regId，alias 两者需一个不为空，当两个不为空时，取regId）
	private String regId;

	// 别名 长度不超过40字符（regId，alias两者需一个不为空，当两个不为空时，取regId）
	private String alias;

	// 高级特性
	private Map<String, String> extra;

	// 推送模式 0：正式推送；1：测试推送，不填默认为0
	private Integer pushMode;

	/**
	 * 获取regId
	 * 
	 * @return
	 */
	public String getRegId()
	{
		return regId;
	}

	/**
	 * 设置regId
	 * 
	 * @param regId
	 */
	public void setRegId(String regId)
	{
		this.regId = regId;
	}

	/**
	 * 获取alias
	 * 
	 * @return
	 */
	public String getAlias()
	{
		return alias;
	}

	/**
	 * 设置alias
	 * 
	 * @param alias
	 */
	public void setAlias(String alias)
	{
		this.alias = alias;
	}

	/**
	 * 获取extra
	 * 
	 * @return
	 */
	public Map<String, String> getExtra()
	{
		return extra;
	}

	/**
	 * 设置extra
	 * 
	 * @param extra
	 */
	public void setExtra(Map<String, String> extra)
	{
		this.extra = extra;
	}

	/**
	 * 获取pushMode
	 * 
	 * @return
	 */
	public Integer getPushMode()
	{
		return pushMode;
	}

	/**
	 * 设置pushMode
	 * 
	 * @param pushMode
	 */
	public void setPushMode(Integer pushMode)
	{
		this.pushMode = pushMode;
	}
}
