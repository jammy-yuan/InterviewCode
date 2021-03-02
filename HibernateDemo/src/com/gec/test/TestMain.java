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
		
		//{ps} ������� Hibernate ?
		//{ps} ���ͨ�� hibernate �������ݿ� ?
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
		SessionFactory factory = config.buildSessionFactory( registry );
		
		//{ps} ��ȡһ�� Session ����
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		User user = new User(); 
		user.setUserName("����");
		user.setPassWord("123");
		user.setAge( 50 );
		user.setWeight( (float)60.0 );
		
		session.save( user );
		System.out.println("{debug} ���ݱ���ɹ� ...");
		
		tx.commit();      //{ps} �ύ���� ..
		session.close();   //{ps} �رջỰ ..
		
		//factory.close();   //{ps} ������Ҫ�˳���
	}
	
}
