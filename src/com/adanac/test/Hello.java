package com.adanac.test;

/**
 * Hello是一个需要被管理的类（普通类）
 * 包含在MBean中方法都将是可以被管理的。MBean起名是有规范的，就是原类名后加上MBean字样。
 * 
 * @author adanac@sina.com
 * @date 2015年11月16日
 * @version v1.0
 */
public class Hello implements HelloMBean {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void printHello() {
		System.out.println("Hello World, " + name);
	}

	public void printHello(String whoName) {
		System.out.println("Hello , " + whoName);
	}
}
