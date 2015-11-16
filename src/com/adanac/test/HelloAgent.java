package com.adanac.test;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import javax.swing.JDialog;

import com.sun.jdmk.comm.HtmlAdaptorServer;

/**
 * 创建一个Agent类
 * 
 * @author adanac@sina.com
 * @date 2015年11月16日
 * @version v1.0
 */
public class HelloAgent {
	public static void main(String[] args) throws Exception {
		// 创建了一个MBeanServer，用来做MBean的容器
		MBeanServer server = MBeanServerFactory.createMBeanServer();
		// 将Hello这个类注入到MBeanServer中，注入需要创建一个ObjectName类
		ObjectName helloName = new ObjectName("adanac:name=HelloWorldTest");
		server.registerMBean(new Hello(), helloName);

		// 此处 8082不是端口，而是参数
		ObjectName adapterName = new ObjectName("HelloAgent:name=htmladapter,port=8082");

		// 创建一个AdaptorServer，这个类将决定MBean的管理界面，这里用最普通的Html型界面。AdaptorServer其实也是一个MBean。
		HtmlAdaptorServer adapter = new HtmlAdaptorServer();
		server.registerMBean(adapter, adapterName);

		// 设置端口
		adapter.setPort(8091);
		adapter.start();
		System.out.println("start.....");
		// chengang:name=HelloWorld的名字是有一定规则的，格式为：“域名:name=MBean名称”，域名和MBean名称都可以任意取。
		// 运行HelloAgent，然后打开网页：http://localhost:8091/ ，
		// 单击“name=HelloWorld”链接进入。

		// 由于是为了演示保持程序处于运行状态，创建一个图形窗口
		javax.swing.JDialog dialog = new JDialog();
		dialog.setName("jmx test");
		dialog.setVisible(true);
	}
}
