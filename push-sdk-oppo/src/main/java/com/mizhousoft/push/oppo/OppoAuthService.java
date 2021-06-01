package com.mizhousoft.push.oppo;

import com.mizhousoft.push.exception.PushException;
import com.mizhousoft.push.oppo.constant.OppoConstants;

/**
 * 认证服务
 *
 * @version
 */
public interface OppoAuthService
{
	String OAUTH2_TOKEN_URL = OppoConstants.OPPO_END_POINT + "/server/v1/auth";

	/**
	 * 获取访问Token
	 * 
	 * @return
	 * @throws PushException
	 */
	OppoAccessToken getAccessToken() throws PushException;
}
