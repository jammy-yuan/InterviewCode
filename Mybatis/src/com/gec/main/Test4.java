package com.gec.main;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gec.domain.Student;
import com.gec.mapper.StudentMapper;

public class Test4 {
	public static void main(String[] args) throws IOException {
		InputStream in = Resources.getResourceAsStream("mybatis.cfg.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = factory.openSession();
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		Student stu = mapper.getStudentById(1);
		System.out.println(stu);
		System.out.println(stu.getSquad());
		session.commit();
		session.close();
	}
}
