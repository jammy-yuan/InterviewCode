package com.gec.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Userdao {
	//从Ioc容器中按类型查找并注入一个依赖对象
	@Autowired
	private JdbcTemplate jdbcTemp;
	{
		System.out.println("{debug} Userdao init ...");
	}
	public void updateUser(int id,float weight) {
		String sql="update t_user set _weight=? where _id=?";
		jdbcTemp.update(sql,weight,id);
	}
}
