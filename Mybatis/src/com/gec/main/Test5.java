package com.gec.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gec.domain.Course;
import com.gec.domain.Student;
import com.gec.mapper.CourseMapper;

public class Test5 {
	public static void main(String[] args) throws IOException {
		InputStream in = Resources.getResourceAsStream("mybatis.cfg.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = factory.openSession();
		CourseMapper mapper = session.getMapper(CourseMapper.class);
		Course course = mapper.getCourseById(10);
		System.out.println(course);
		List<Student> students = course.getStudents();
		for (Student s : students) {
			System.out.println(s);
		}
		session.commit();
		session.close();
	}

}
