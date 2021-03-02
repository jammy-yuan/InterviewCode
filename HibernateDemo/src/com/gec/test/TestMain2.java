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

public class TestMain2 {
	SessionFactory factory = null;
	Transaction tx = null;
	Session session = null;
	
	@Before
	public void createFactory(){
		//{ps} ����һ�� Hibernate ������, �Զ�ȥ���� classes\hibernate.cfg.xml �����ļ�
		//     ����һ��������������װ������Ϣ�������С�
		Configuration config = new Configuration().configure();
		Properties pros = config.getProperties();   //{ps} ��ȡ����
		
		//{ps} ����һ��ע�����Ĺ�����, ��ͨ������ hibernate ע��һ������..
		//{ps} 4.21-4.2x �Ż���, 4.3 �ֲ����� ..
		ServiceRegistry registry = new ServiceRegistryBuilder()
		.applySettings( pros )
		.buildServiceRegistry();
		
		//{ps} ����һ���Ự���� ..
		factory = config.buildSessionFactory( registry );
	}
	
	@After
	public void closeResource(){
		System.out.println("{debug} closeResource();");
		tx.commit();          //{ps} �ύ���� ..
		session.close();      //{ps} �رջỰ ..
		//factory.close();   //{ps} ������Ҫ�˳���
	}
	
	@Test
	public void testGet(){
		session = factory.openSession();
		tx = session.beginTransaction();
		User user = (User)session.get( User.class, 1 );
		System.out.println( "[053] testGet()" );
		//Class clazz = user.getClass();
		//System.out.println( "{debug} �����ֽ��� = "+ clazz );
		//System.out.println( "user = "+ user );
	}
	
	//@Test
	public void testLoad(){
		session = factory.openSession();
		tx = session.beginTransaction();
		User user = (User)session.load( User.class, 2 );
		System.out.println( "[061] testLoad()" );
		Class clazz = user.getClass();
		System.out.println( "{debug} �����ֽ��� = "+ clazz );
		System.out.println( "[load] user = "+ user.getUserName() );
	}
	
	public static void main(String[] args) {
		TestMain2 main = new TestMain2();
		main.createFactory();
		//main.testGet();
		main.testLoad();
		main.closeResource();
	}

}
