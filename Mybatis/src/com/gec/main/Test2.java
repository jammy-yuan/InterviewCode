package com.gec.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gec.domain.User;
import com.gec.mapper.UserMapper;

public class Test2 {
	public static void main(String[] args) throws IOException {
		InputStream in = Resources.getResourceAsStream("mybatis.cfg.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = factory.openSession();
		User user = new User();
		user.setId(1);
		user.setAge(20);
		UserMapper userMapper = session.getMapper(UserMapper.class);
//		List<User> list = userMapper.searchUser( user );
//		for (User u : list) {
//			System.out.println( u );
//		}
		
//		int updateUser = userMapper.updateUser(user);
//		System.out.println("作用了"+updateUser+"条记录");
		
		String[] str= {"andy","Marry"};
		List<String> list = Arrays.asList(str);
		List<User> users = userMapper.queryUserByName(list);
		for (User user2 : users) {
			System.out.println(user2);
		}
		session.commit();
		session.close();
	}

}
