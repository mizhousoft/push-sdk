package com.mizhousoft.push.huawei;

import com.mizhousoft.push.exception.PushException;

/**
 * 认证服务
 *
 * @version
 */
public interface HuaweiAuthService
{
	String OAUTH2_TOKEN_URL = "https://oauth-login.cloud.huawei.com/oauth2/v3/token";

	/**
	 * 获取访问Token
	 * 
	 * @return
	 * @throws PushException
	 */
	HuaweiAccessToken getAccessToken() throws PushException;
}
