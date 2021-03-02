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
		//{ps} ��������������һ�� Bean ����
		//ctx.getBean( UserController.class );
		
		//{ps} ���� BeanID ������ Bean ����
		//BeanID ��ʲô ?
		//@Controller
		//{ps} Ĭ��ʹ����������Ϊ:  BeanID
		//public class UserController { }
		UserController con = (UserController)ctx.getBean("userController");
		con.login("andy", "123");
	}

	private static void print(Object obj) {
		System.out.println("{debug}"+ obj);
	}
	
}
