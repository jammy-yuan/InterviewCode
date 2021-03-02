package com.gec.test;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gec.po.User;

public class BaseMain {
	protected SessionFactory factory = null;
	protected Transaction tx = null;
	protected Session session = null;
	
	@Before
	public void createFactory(){
		//{ps} 创建一个 Hibernate 配置器, 自动去加载 classes\hibernate.cfg.xml 配置文件
		//     产生一个配置器，并封装配置信息到对象中。
		Configuration config = new Configuration().configure();
		Properties pros = config.getProperties();   //{ps} 获取属性
		
		//{ps} 创建一个注册服务的构建器, 再通过它向 hibernate 注册一个服务..
		//{ps} 4.21-4.2x 才会有, 4.3 这种操作已被删除。
		ServiceRegistry registry = new ServiceRegistryBuilder()
		.applySettings( pros )
		.buildServiceRegistry();
		
		//{ps} 创建一个会话工厂 ..
		factory = config.buildSessionFactory( registry );
		
		session = factory.openSession();
		tx = session.beginTransaction();
		System.out.println("{debug} 拿到事务 ...");
	}
	
	@After
	public void closeResource(){
		System.out.println("{debug} 提交了事务 ...");
		tx.commit();          //{ps} 提交事务 ..
		//session.close();      //{ps} 关闭会话 ..
		//factory.close();   //{ps} 程序已要退出了
	}
}
