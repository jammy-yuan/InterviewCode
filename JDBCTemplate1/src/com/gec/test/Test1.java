package com.gec.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.support.TransactionTemplate;

import com.gec.damain.User;

public class Test1 {
	DriverManagerDataSource ds;
	TransactionTemplate txTemp;
	{
		//ds.setDriverClassName(arg0);
		//ds.setUsername(username);
		
	}
	
	
	
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		DriverManagerDataSource ds=(DriverManagerDataSource)ac.getBean("dataSource");
		JdbcTemplate temp = new JdbcTemplate(ds);
		//String sql="update t_user set _age=? where _id=?";
//		String sql="select *from t_user where pass_word=?";
//		Object[] arg= {123};
		//temp.update(sql,arg);
//		List<User> list=temp.query(sql, arg,new ResultSetExtractor<List<User>>() {//结果集处理器
//			@Override
//			public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
//				List<User> list=new ArrayList();
//				while(rs.next()) {
//					User user=new User(
//							rs.getString("user_name"),
//							rs.getString("pass_word"),
//							rs.getInt("_age"),
//							rs.getFloat("_weight")
//							);
//					list.add(user);
//				}
//				return list;
//			}			
//		});
//		List<User> list=new ArrayList();
//		temp.query(sql, arg, new RowCallbackHandler() {//行记录处理器
//			@Override
//			public void processRow(ResultSet rs) throws SQLException {
//				User user=new User(
//						rs.getString("user_name"),
//						rs.getString("pass_word"),
//						rs.getInt("_age"),
//						rs.getFloat("_weight")
//						);
//				list.add(user);
//			}			
//		});
		String sql="select user_name from t_user where _id=?";
		Object[] arg= {1};
		String name=temp.queryForObject(sql, arg,String.class);
		System.out.println(name);
	}

}





