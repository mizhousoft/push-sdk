package com.mizhousoft.push.action;

/**
 * ClickAction
 *
 * @version
 */
public class UrlClickAction extends ClickAction
{
	// 设置打开特定URL，本字段填写需要打开的URL，URL使用的协议必须是HTTPS协议
	private String url;

	/**
	 * 构造函数
	 *
	 * @param url
	 */
	public UrlClickAction(String url)
	{
		super();
		this.url = url;
	}

	/**
	 * 获取url
	 * 
	 * @return
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * 设置url
	 * 
	 * @param url
	 */
	public void setUrl(String url)
	{
		this.url = url;
	}
}
