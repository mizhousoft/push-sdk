package com.mizhousoft.push.umeng.internal.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 消息请求
 *
 * @version
 */
public class UMengMessageRequest
{
	// 必填，应用唯一标识
	@JsonProperty("appkey")
	private String appKey;

	// 必填，时间戳，10位或者13位均可，时间戳有效期为10分钟
	@JsonProperty("timestamp")
	private String timestamp;

	// 必填，消息发送类型,其值可以为:
	// unicast-单播
	// listcast-列播，要求不超过500个device_token
	// filecast-文件播，多个device_token可通过文件形式批量发送
	// broadcast-广播
	// groupcast-组播，按照filter筛选用户群,请参照filter参数
	// customizedcast，通过alias进行推送，包括以下两种case:
	// -alias:对单个或者多个alias进行推送
	// -file_id:将alias存放到文件后，根据file_id来推送
	@JsonProperty("type")
	private String type;

	// 当type=unicast时,必填,表示指定的单个设备
	// 当type=listcast时,必填,要求不超过500个,以英文逗号分隔
	@JsonProperty("device_tokens")
	private String deviceTokens;

	// 当type=customizedcast时,必填
	// alias的类型, alias_type可由开发者自定义
	@JsonProperty("alias_type")
	private String aliasType;

	// 当type=customizedcast时,选填(此参数和file_id二选一)
	// 开发者填写自己的alias,要求不超过500个alias,多个alias以英文逗号间隔
	@JsonProperty("alias")
	private String alias;

	// 当type=filecast时，必填，file内容为多条device_token，以回车符分割
	// 当type=customizedcast时，选填(此参数和alias二选一)
	// file内容为多条alias，以回车符分隔。注意同一个文件内的alias所对应的alias_type必须和接口参数alias_type一致
	// 使用文件播需要先调用文件上传接口获取file_id，参照"文件上传"
	@JsonProperty("file_id")
	private String fileId;

	// 可选，true正式模式，false测试模式。默认为true
	// 测试模式只对“广播”、“组播”类消息生效，其他类型的消息任务（如“文件播”）不会走测试模式
	// 测试模式只会将消息发给测试设备。测试设备需要到web上添加
	// Android:测试设备属于正式设备的一个子集
	@JsonProperty("production_mode")
	private String productionMode;

	// 可选，发送消息描述，建议填写
	@JsonProperty("description")
	private String description;

	// 可选，默认为false。当为true时，表示华为、小米、oppo、vivo、魅族的设备离线时可使用厂商通道下发
	@JsonProperty("mipush")
	private String miPush;

	// 可选，系统弹窗，只有display_type=notification有效，mipush值为true时生效，表示走系统通道时打开指定页面acitivity的完整包路径。
	@JsonProperty("miActivity")
	private String miActivity;

	// 必填，JSON格式，具体消息内容(Android最大为1840B)
	@JsonProperty("payload")
	private UMengPayload payload;

	/**
	 * 获取appKey
	 * 
	 * @return
	 */
	public String getAppKey()
	{
		return appKey;
	}

	/**
	 * 设置appKey
	 * 
	 * @param appKey
	 */
	public void setAppKey(String appKey)
	{
		this.appKey = appKey;
	}

	/**
	 * 获取timestamp
	 * 
	 * @return
	 */
	public String getTimestamp()
	{
		return timestamp;
	}

	/**
	 * 设置timestamp
	 * 
	 * @param timestamp
	 */
	public void setTimestamp(String timestamp)
	{
		this.timestamp = timestamp;
	}

	/**
	 * 获取type
	 * 
	 * @return
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * 设置type
	 * 
	 * @param type
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 * 获取deviceTokens
	 * 
	 * @return
	 */
	public String getDeviceTokens()
	{
		return deviceTokens;
	}

	/**
	 * 设置deviceTokens
	 * 
	 * @param deviceTokens
	 */
	public void setDeviceTokens(String deviceTokens)
	{
		this.deviceTokens = deviceTokens;
	}

	/**
	 * 获取aliasType
	 * 
	 * @return
	 */
	public String getAliasType()
	{
		return aliasType;
	}

	/**
	 * 设置aliasType
	 * 
	 * @param aliasType
	 */
	public void setAliasType(String aliasType)
	{
		this.aliasType = aliasType;
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
	 * 获取fileId
	 * 
	 * @return
	 */
	public String getFileId()
	{
		return fileId;
	}

	/**
	 * 设置fileId
	 * 
	 * @param fileId
	 */
	public void setFileId(String fileId)
	{
		this.fileId = fileId;
	}

	/**
	 * 获取productionMode
	 * 
	 * @return
	 */
	public String getProductionMode()
	{
		return productionMode;
	}

	/**
	 * 设置productionMode
	 * 
	 * @param productionMode
	 */
	public void setProductionMode(String productionMode)
	{
		this.productionMode = productionMode;
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
	 * 获取miPush
	 * 
	 * @return
	 */
	public String getMiPush()
	{
		return miPush;
	}

	/**
	 * 设置miPush
	 * 
	 * @param miPush
	 */
	public void setMiPush(String miPush)
	{
		this.miPush = miPush;
	}

	/**
	 * 获取miActivity
	 * 
	 * @return
	 */
	public String getMiActivity()
	{
		return miActivity;
	}

	/**
	 * 设置miActivity
	 * 
	 * @param miActivity
	 */
	public void setMiActivity(String miActivity)
	{
		this.miActivity = miActivity;
	}

	/**
	 * 获取payload
	 * 
	 * @return
	 */
	public UMengPayload getPayload()
	{
		return payload;
	}

	/**
	 * 设置payload
	 * 
	 * @param payload
	 */
	public void setPayload(UMengPayload payload)
	{
		this.payload = payload;
	}
}
