package com.gec.test;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.gec.po.User;

public class TestMain {

	public static void main( String[] args ) {
		
		//{ps} 如何启动 Hibernate ?
		//{ps} 如何通过 hibernate 操作数据库 ?
		//{ps} 创建一个 Hibernate 配置器, 自动去加载 classes\hibernate.cfg.xml 配置文件
		//     产生一个配置器，并封装配置信息到对象中。
		Configuration config = new Configuration().configure();
		Properties pros = config.getProperties();   //{ps} 获取属性
		
		//{ps} 创建一个注册服务的构建器, 再通过它向 hibernate 注册一个服务..
		//{ps} 4.21-4.2x 才会有, 4.3 又不存在 ..
		ServiceRegistry registry = new ServiceRegistryBuilder()
		.applySettings( pros )
		.buildServiceRegistry();
		
		//{ps} 创建一个会话工厂 ..
		SessionFactory factory = config.buildSessionFactory( registry );
		
		//{ps} 获取一个 Session 对象
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		User user = new User(); 
		user.setUserName("老王");
		user.setPassWord("123");
		user.setAge( 50 );
		user.setWeight( (float)60.0 );
		
		session.save( user );
		System.out.println("{debug} 数据保存成功 ...");
		
		tx.commit();      //{ps} 提交事务 ..
		session.close();   //{ps} 关闭会话 ..
		
		//factory.close();   //{ps} 程序已要退出了
	}
	
}
