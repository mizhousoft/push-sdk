package com.mizhousoft.push.action;

/**
 * ClickAction
 *
 * @version
 */
public class ActionClickAction extends ClickAction
{
	// 设置通过action打开应用自定义页面时，本字段填写要打开的页面activity对应的action。
	private String action;

	/**
	 * 构造函数
	 *
	 * @param action
	 */
	public ActionClickAction(String action)
	{
		super();
		this.action = action;
	}

	/**
	 * 获取action
	 * 
	 * @return
	 */
	public String getAction()
	{
		return action;
	}

	/**
	 * 设置action
	 * 
	 * @param action
	 */
	public void setAction(String action)
	{
		this.action = action;
	}
}
