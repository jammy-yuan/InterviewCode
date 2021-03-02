package com.gec.main;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gec.domain.User;
import com.gec.mapper.UserMapper;

public class Test1 {

//	public static void main(String[] args) throws IOException {
//		InputStream in = Resources.getResourceAsStream("mybatis.cfg.xml");
//		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//		//{ps} ��һ���Ự
//		SqlSession session = factory.openSession();
//		User user = new User();
////		user.setId(2);
////		user.setUsername("Candy");
////		user.setPassword("123");
////		user.setAge(19);
////		user.setWeight(50.2f);
//		int count = session.delete("com.gec.UserMapper.delUserById",2);
//		System.out.println("���³ɹ�����������"+count+"������");
//		session.commit();
//		session.close();
//	}
//}
//	User user = session.selectOne("com.gec.domain.UserMapper.getUserById",3);
//int count = session.insert("com.gec.UserMapper.addUser",user);
//System.out.println("����ɹ�����������"+count+"�����ݣ����ɵ�id:"+user.getId());
	
	public static void main(String[] args) throws IOException {
		InputStream in = Resources.getResourceAsStream("mybatis.cfg.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//{ps} ��һ���Ự
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = mapper.getUserById(3);	
		System.out.println(mapper.getClass());		
		System.out.println(user);
		session.commit();
		session.close();
	}
	
}


