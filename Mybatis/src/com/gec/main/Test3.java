package com.gec.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gec.domain.Squad;
import com.gec.domain.Student;
import com.gec.mapper.SquadMapper;

public class Test3 {
	public static void main(String[] args) throws IOException {
		InputStream in = Resources.getResourceAsStream("mybatis.cfg.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = factory.openSession();
		SquadMapper mapper = session.getMapper(SquadMapper.class);
		Squad squad = mapper.getSquadById(1);
		System.out.println("---------------------------------------------------------------------------");
		System.out.println(squad);
		List<Student> students = squad.getStudents();
		for (Student student : students) {
			System.out.println(student);			
		}
		System.out.println("---------------------------------------------------------------------------");
		session.commit();
		session.close();
	}

}
