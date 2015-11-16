package com.adanac.test;

/**
 * 要管理Hello则必须创建一个相应MBean
 * 
 * @author adanac@sina.com
 * @date 2015年11月16日
 * @version v1.0
 */
public interface HelloMBean {
	public String getName();

	public void setName(String name);

	public void printHello();

	public void printHello(String whoName);
}
