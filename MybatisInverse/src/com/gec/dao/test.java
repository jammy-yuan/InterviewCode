package com.gec.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Array;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gec.beans.TUser;
import com.gec.beans.TUserExample;
import com.gec.beans.TUserExample.Criteria;
import com.gec.mapper.TUserMapper;

public class test {
	static SqlSessionFactory factory;
	public static void createFactory() throws IOException {
		InputStream in = Resources.getResourceAsStream("mybatis.cfg.xml");
		factory = new SqlSessionFactoryBuilder().build(in);
	}
	public static void finish(SqlSession session) {
		session.commit();
		session.close();
	}
	public static void test(SqlSession session) {
		//{ps} 创建一个查询样本
		TUserExample exp = new TUserExample();
		//{ps} 创建一个条件对象, 用来设置查询的条件...
		Criteria cri = exp.createCriteria();
		//cri.andIdEqualTo(1);
//		cri.andAgeGreaterThan(10);
		String[] atr= {"ken","tony","andy"};
		List<String> asList = Arrays.asList(atr);
//		cri.andUserNameIn(asList);
		cri.andUserNameLike("%n%");//模糊查询
		exp.setOrderByClause("_age");
		TUserMapper mapper = session.getMapper(TUserMapper.class);
		List<TUser> list = mapper.selectByExample(exp);
		System.out.println("---------------------------------------------------------------------------------------");
		for (TUser tUser : list) {
			System.out.println(tUser);
		}
		System.out.println("---------------------------------------------------------------------------------------");
	}
	public static void main(String[] args) throws IOException {
		createFactory();
		SqlSession session = factory.openSession();
		test(session);
		finish(session);
	}

}
