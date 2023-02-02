package com.mizhousoft.push;

/**
 * Push供应商
 *
 * @version
 */
public enum PushProvider
{
    // 华为
	HUAWEI("huawei"),
    // OPPO
	OPPO("oppo"),
    // VIVO
	VIVO("vivo"),
    // 小米
	XIAOMI("xiaomi"),
    // 苹果
	APPLE("apple");

	/**
	 * 构造函数
	 *
	 * @param val
	 */
	private PushProvider(String val)
	{
		this.value = val;
	}

	/**
	 * 值
	 */
	private final String value;

	/**
	 * 获取value
	 * 
	 * @return
	 */
	public String getValue()
	{
		return value;
	}

	public boolean isSelf(String val)
	{
		return (this.value.equals(val));
	}

	/**
	 * 获取状态
	 * 
	 * @param data
	 * @return
	 */
	public static PushProvider get(String data)
	{
		PushProvider[] values = PushProvider.values();
		for (PushProvider value : values)
		{
			if (value.getValue().equals(data))
			{
				return value;
			}
		}

		return null;
	}
}
