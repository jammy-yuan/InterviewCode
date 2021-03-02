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

public class Test3 {
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
		session.close();      //{ps} �رջỰ ..
		//factory.close();   //{ps} ������Ҫ�˳���
	}
	
	//@Test
	public void testSave(){
		User user = new User();
		//{ps} user �� id Ҫ��Ҫȥ���� ?
		//    ��: ����Ҫ���� id, ��Ϊ�������ɲ�����: native 
		//    (�� id ����  mysql �Զ����� ..)
		//	  <!-- {ps} ���������� -->
		//    <generator  class="native" >
		//    </generator>

		//{ps} id ��������, ���ݿ�������ͬ id ����ô�� ?
		//	    ��: �⻹��Ҫ��������������ɲ���������
		//        ����� <generator class="assigned" > ����Ҫ���� id;
		//    user.setId( 50 );
		//    ��������ͬ id �ͱ������ظ��쳣..
		
		user.setUserName("andy");
		user.setPassWord("123");
		user.setAge( 63 );
		user.setWeight( (float)52.33 );
		session.save( user );
		
		System.out.println("{debug} ִ���˱��� ...");
	}
	
	//{ps} ��һ������ʱ�õķ���
	//@Test
	public void update(){
		//User user = new User();
		//{ps} ָ����Ҫ�޸�˭ ?
		//user.setId( 1 );    //{ps} ���� id �����ݿ��Ǵ��ڵġ�
		//user.setUserName("����");		
		//session.update( user );
		
		//{ps} get ֮��  user �Ѿ������ݿ��еļ�¼������ ..
		User user = (User)session.get(User.class,1);
		
		user.setUserName("����-2019");
		System.out.println("{debug} �ڴ��иĶ�: ����-2019");
		
		//{ps} ʲôʱ��  update ������ ?
		//��: �� user ����û����������״̬, ���������ɰ󶨵�״̬, ���뽫�û���
		// ����ͬ�������ݿ⡣
		//��ʱ update �������塣
		
		//{ps} ��Ҫ�����ݿ��еļ�¼, ǰ�����ܹ������ݿ�ļ�¼�� 
		//(�� id �����ݿ�����Ǵ��ڵ�)
		//session.update( user );
	}

	//@Test
	public void testSaveOrUpdate(){
		//{ps} ���� saveOrUpdate ����, ��Ҫ��Ҫ�㶮��ʲôʱ���ǲ���
		//  ʲôʱ���Ǹ��¡�
		User user = new User();
		//user.setId( 1 );    //{ps} ��ͼȥ�����ݿ��ĳ����¼ (����)
						      //{ps} ��ȥ���� id , ��һ�����  insert into ����..
		user.setUserName( "andy2020" );
		//{ps} �������� "����(�½�)" ���� "����" ?
		session.saveOrUpdate( user );//���½�
	}

	@Test
	public void testDelete(){
		//{ps} ���� ID, ɾ�����ݿ��¼ ?
		//{ps} ���� ID, �� ID ��������ô�� ?
		//    ����:  org.hibernate.Stale State Exception
		//{ps} û�� ID, ������ʲô��
		User user = new User();
		user.setId( 1 ); 
		user.setUserName("andy2020");
		session.delete( user );
	}
	public static void main(String[] args) {
		Test3 test=new Test3();
		test.createFactory();
		test.testSaveOrUpdate();
		test.closeResource();
	}
}
