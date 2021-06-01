package com.mizhousoft.push.vivo;

import com.mizhousoft.push.exception.PushException;

/**
 * ViVo认证服务
 *
 * @version
 */
public interface ViVoAuthService
{
	String AUTH_URL = "https://api-push.vivo.com.cn/message/auth";

	/**
	 * 获取访问Token
	 * 
	 * @return
	 * @throws PushException
	 */
	String getAccessToken() throws PushException;
}
