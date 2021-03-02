package com.gec.test;

import org.junit.Test;

import com.gec.po.User;
/**
 * �����
 * @author DDD
 *
 */
public class TestMain1 extends BaseMain {

	@Test
	public void testEvict(){
		User user = (User)session.get(User.class, 2);
		System.out.println( "user = "+ user );
		user.setUserName("����-2019");
		user.setPassWord("000");
		
		//{ps} ��ͼ���˶���ӻ��������� ...
		session.evict( user );
		System.out.println("{debug} ���˶���ӻ��������� ...");
		System.out.println("{debug} ͬ�������ݿ� ...");
	}
	
	//@Test
	public void testClear(){
		User user2 = (User)session.get(User.class, 2);
		System.out.println( "user = "+ user2 );
		user2.setUserName("candy2");
		user2.setPassWord("222");
		
		User user3 = (User)session.get(User.class, 3);
		System.out.println( "user = "+ user3 );
		user3.setUserName("candy3");
		user3.setPassWord("333");
		
		//{ps} ��ͼ����������ж������
		session.clear();
		
		System.out.println("{debug} ��ջ���������ж��� ...");
		System.out.println("{debug} ͬ�������ݿ� ...");
	}
	
	//@Test
	public void testClose(){
		User user2 = (User)session.get(User.class, 2);
		System.out.println( "user = "+ user2 );
		user2.setUserName("candy-2019");
		user2.setPassWord("222");
		
		User user3 = (User)session.get(User.class, 3);
		System.out.println( "user = "+ user3 );
		user3.setUserName("candy-2020");
		user3.setPassWord("333");
		
		//{ps} ��ͼ����������ж������
		// ��ʾ:  session ��Ҫ�ظ��ر� ...
		//session.close();
		
		System.out.println("{debug} �ر� Session..");
		System.out.println("{debug} ͬ�������ݿ� ...");
	}
	
	
	
	
}