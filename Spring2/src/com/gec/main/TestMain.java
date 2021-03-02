package com.gec.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gec.main.User;

	public class TestMain {
		
		public static void main(String[] args) {
			ApplicationContext ctx = new ClassPathXmlApplicationContext(
					"beans.xml" );
			System.out.println("{debug} 容器启动与初始化结束  ..");
			User user = (User)ctx.getBean("user");
			System.out.println( "user="+ user );
		}
		
	}



//{ps} 创建 IoC 容器 (BeanFactory)
//从哪里加载 beans.xml ? 自动从 classes 目录下加载文件

//User user = (User)ctx.getBean("user");
//BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");
//{ps} 按照 Bean 对象的类型从容器中获取一个对象出来..
//{ps} ctx.getBean( User.class );

//{ps} 探测有没有包含某个 Bean
//factory.containsBean("BeanId");
//System.out.println( user );


//{ps} 按照 BeanID 从容器中获取一个对象出来..
//User user = (User)ctx.getBean( User.class );
//System.out.println( user );

//String[] names = ctx.getBeanDefinitionNames();
//for (String name : names) {
//	System.out.println("name:"+ name);
//}