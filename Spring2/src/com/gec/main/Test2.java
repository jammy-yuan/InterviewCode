package com.gec.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		Util util =(Util) ctx.getBean("util");
		System.out.println(util.getAddress());
	}

}
