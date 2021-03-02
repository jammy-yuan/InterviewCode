package com.gec.test;
/**
 * 创建一个事务
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class Test2 {
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		TransactionTemplate trans =(TransactionTemplate) ac.getBean("transTemplate");
		JdbcTemplate temp =(JdbcTemplate) ac.getBean("jdbcTemplate");
		trans.execute(new TransactionCallback() {
			@Override
			public Object doInTransaction(TransactionStatus arg0) {
				temp.update("update t_user set _weight=50.3 where _id=3");
				System.out.println(5/0);//模拟一个异常
				temp.update("update t_user set _weight=54.3 where _id=2");
				return null;
			}
		});
	}

}
