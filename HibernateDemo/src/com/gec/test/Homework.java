package com.gec.test;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.gec.po.User;

public class Homework {
	public static void main(String[] args) {
		Configuration config = new Configuration().configure();
		Properties pro = config.getProperties();
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(pro).buildServiceRegistry();
		SessionFactory factory = config.buildSessionFactory(registry);
		Session session = factory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		
		User user = new User(); 
		user.setUserName("老王");
		user.setPassWord("123");
		user.setAge( 50 );
		user.setWeight( (float)60.0 );
		
		session.save( user );
		System.out.println("{debug} 数据保存成功 ...");
		
		trans.commit();      //{ps} 提交事务 ..

	}

}
