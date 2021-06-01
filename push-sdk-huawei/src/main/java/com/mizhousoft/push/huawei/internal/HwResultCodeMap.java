package com.mizhousoft.push.huawei.internal;

import java.util.HashMap;
import java.util.Map;

/**
 * ResultCodeMap
 *
 * @version
 */
public class HwResultCodeMap
{
	private static final Map<String, String> codeMap = new HashMap<String, String>(20)
	{
		private static final long serialVersionUID = 6193823763554064295L;

		{
			put("80000000", "Success");
			put("80100000", "Some tokens are right, the others are illegal");
			put("80100001", "Parameters check error");
			put("80100002", "Token number should be one when send sys message");
			put("80100003", "Message structure error");
			put("80100004", "TTL is less than current time, please check");
			put("80100013", "Collapse_key is illegal, please check");
			put("80100016", "Message contians sensitive information, please check");
			put("80200001", "Oauth authentication error");
			put("80200003", "Oauth Token expired");
			put("80300002", "APP is forbidden to send");
			put("80300007", "Invalid Token");
			put("80300008", "The message body size exceeds the default value set by the system (4K)");
			put("80300010", "Tokens exceed the default value");
			put("81000001", "System inner error");
			put("82000001", "GroupKey or groupName error");
			put("82000002", "GroupKey and groupName do not match");
			put("82000003", "Token array is null");
			put("82000004", "Group do not exist");
			put("82000005", "Group do not belond to this app");
			put("82000006", "Token array or group number is transfinited");
			put("82000007", "Invalid topic");
			put("82000008", "Token array null or transfinited");
			put("82000009", "Topic num transfinited, at most 2000");
			put("82000010", "Some token is wrong");
			put("82000011", "Token is null");
			put("82000012", "Data storage location is not selected");
			put("82000013", "Data storage location does not match the actual data");
		}
	};

	public static boolean isSucceedCode(String code)
	{
		return "80000000".equals(code);
	}

	public static boolean isPartSucceedCode(String code)
	{
		return "80100000".equals(code);
	}

	public static boolean isAllIllegalTokenCode(String code)
	{
		return "80300007".equals(code);
	}

	public static String getCodeDescription(String code)
	{
		return codeMap.getOrDefault(code, "Unknown code");
	}
}
