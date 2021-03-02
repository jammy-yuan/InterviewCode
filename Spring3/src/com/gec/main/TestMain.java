package com.gec.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.gec.controller.UserController;
import com.gec.domain.Body;

public class TestMain {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"beans.xml" );
		//{ps} 按照类型来查找一个 Bean 对象
		//ctx.getBean( UserController.class );
		
		//{ps} 按照 BeanID 来查找 Bean 对象
		//BeanID 是什么 ?
		//@Controller
		//{ps} 默认使用类名来作为:  BeanID
		//public class UserController { }
		UserController con = (UserController)ctx.getBean("userController");
		con.login("andy", "123");
	}

	private static void print(Object obj) {
		System.out.println("{debug}"+ obj);
	}
	
}
