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
		//{ps} ����һ�� Hibernate ������, �Զ�ȥ���� classes\hibernate.cfg.xml �����ļ�
		//     ����һ��������������װ������Ϣ�������С�
		Configuration config = new Configuration().configure();
		Properties pros = config.getProperties();   //{ps} ��ȡ����
		
		//{ps} ����һ��ע�����Ĺ�����, ��ͨ������ hibernate ע��һ������..
		//{ps} 4.21-4.2x �Ż���, 4.3 ���ֲ����ѱ�ɾ����
		ServiceRegistry registry = new ServiceRegistryBuilder()
		.applySettings( pros )
		.buildServiceRegistry();
		
		//{ps} ����һ���Ự���� ..
		factory = config.buildSessionFactory( registry );
		
		session = factory.openSession();
		tx = session.beginTransaction();
		System.out.println("{debug} �õ����� ...");
	}
	
	@After
	public void closeResource(){
		System.out.println("{debug} �ύ������ ...");
		tx.commit();          //{ps} �ύ���� ..
		//session.close();      //{ps} �رջỰ ..
		//factory.close();   //{ps} ������Ҫ�˳���
	}
}
