package com.mizhousoft.push.vivo.internal.request;

/**
 * 广播消息体请求
 *
 * @version
 */
public class ViVoBroadcastTaskRequest extends BaseViVoPushRequest
{
	// 推送模式 0：正式推送；1：测试推送，不填默认为0
	private Integer pushMode;

	/**
	 * 获取pushMode
	 * @return
	 */
	public Integer getPushMode()
	{
		return pushMode;
	}

	/**
	 * 设置pushMode
	 * @param pushMode
	 */
	public void setPushMode(Integer pushMode)
	{
		this.pushMode = pushMode;
	}
}
