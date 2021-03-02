package com.gec.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gec.main.User;

	public class TestMain {
		
		public static void main(String[] args) {
			ApplicationContext ctx = new ClassPathXmlApplicationContext(
					"beans.xml" );
			System.out.println("{debug} �����������ʼ������  ..");
			User user = (User)ctx.getBean("user");
			System.out.println( "user="+ user );
		}
		
	}



//{ps} ���� IoC ���� (BeanFactory)
//��������� beans.xml ? �Զ��� classes Ŀ¼�¼����ļ�

//User user = (User)ctx.getBean("user");
//BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");
//{ps} ���� Bean ��������ʹ������л�ȡһ���������..
//{ps} ctx.getBean( User.class );

//{ps} ̽����û�а���ĳ�� Bean
//factory.containsBean("BeanId");
//System.out.println( user );


//{ps} ���� BeanID �������л�ȡһ���������..
//User user = (User)ctx.getBean( User.class );
//System.out.println( user );

//String[] names = ctx.getBeanDefinitionNames();
//for (String name : names) {
//	System.out.println("name:"+ name);
//}