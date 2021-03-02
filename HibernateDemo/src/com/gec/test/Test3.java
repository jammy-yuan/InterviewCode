package com.gec.test;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gec.po.User;

public class Test3 {
	SessionFactory factory = null;
	Transaction tx = null;
	Session session = null;
	
	@Before
	public void createFactory(){
		//{ps} 创建一个 Hibernate 配置器, 自动去加载 classes\hibernate.cfg.xml 配置文件
		//     产生一个配置器，并封装配置信息到对象中。
		Configuration config = new Configuration().configure();
		Properties pros = config.getProperties();   //{ps} 获取属性
		
		//{ps} 创建一个注册服务的构建器, 再通过它向 hibernate 注册一个服务..
		//{ps} 4.21-4.2x 才会有, 4.3 这种操作已被删除。
		ServiceRegistry registry = new ServiceRegistryBuilder()
		.applySettings( pros )
		.buildServiceRegistry();
		
		//{ps} 创建一个会话工厂 ..
		factory = config.buildSessionFactory( registry );
		
		session = factory.openSession();
		tx = session.beginTransaction();
		System.out.println("{debug} 拿到事务 ...");
	}
	
	@After
	public void closeResource(){
		System.out.println("{debug} 提交了事务 ...");
		tx.commit();          //{ps} 提交事务 ..
		session.close();      //{ps} 关闭会话 ..
		//factory.close();   //{ps} 程序已要退出了
	}
	
	//@Test
	public void testSave(){
		User user = new User();
		//{ps} user 的 id 要不要去设置 ?
		//    答: 不需要设置 id, 因为主键生成策略是: native 
		//    (即 id 交由  mysql 自动生成 ..)
		//	  <!-- {ps} 主键生成器 -->
		//    <generator  class="native" >
		//    </generator>

		//{ps} id 你设置了, 数据库中有相同 id 的怎么办 ?
		//	    答: 这还是要根据你的主键生成策略来看。
		//        如果是 <generator class="assigned" > 就需要设置 id;
		//    user.setId( 50 );
		//    若出现相同 id 就报主键重复异常..
		
		user.setUserName("andy");
		user.setPassWord("123");
		user.setAge( 63 );
		user.setWeight( (float)52.33 );
		session.save( user );
		
		System.out.println("{debug} 执行了保存 ...");
	}
	
	//{ps} 是一个更新时用的方法
	//@Test
	public void update(){
		//User user = new User();
		//{ps} 指明你要修改谁 ?
		//user.setId( 1 );    //{ps} 必须 id 在数据库是存在的。
		//user.setUserName("老李");		
		//session.update( user );
		
		//{ps} get 之后  user 已经与数据库中的记录产生绑定 ..
		User user = (User)session.get(User.class,1);
		
		user.setUserName("李王-2019");
		System.out.println("{debug} 内存中改动: 李王-2019");
		
		//{ps} 什么时候  update 有意义 ?
		//答: 若 user 对象还没真正建立绑定状态, 你想把它变成绑定的状态, 还想将用户的
		// 数据同步到数据库。
		//这时 update 才有意义。
		
		//{ps} 如要绑定数据库中的记录, 前提是能够与数据库的记录绑定 
		//(即 id 在数据库表中是存在的)
		//session.update( user );
	}

	//@Test
	public void testSaveOrUpdate(){
		//{ps} 测试 saveOrUpdate 方法, 主要是要搞懂它什么时候是插入
		//  什么时候是更新。
		User user = new User();
		//user.setId( 1 );    //{ps} 意图去绑定数据库的某个记录 (更新)
						      //{ps} 不去设置 id , 这一个变成  insert into 操作..
		user.setUserName( "andy2020" );
		//{ps} 到底它是 "保存(新建)" 还是 "更新" ?
		session.saveOrUpdate( user );//是新建
	}

	@Test
	public void testDelete(){
		//{ps} 给定 ID, 删除数据库记录 ?
		//{ps} 给定 ID, 但 ID 不存在怎么样 ?
		//    报出:  org.hibernate.Stale State Exception
		//{ps} 没有 ID, 不发生什么。
		User user = new User();
		user.setId( 1 ); 
		user.setUserName("andy2020");
		session.delete( user );
	}
	public static void main(String[] args) {
		Test3 test=new Test3();
		test.createFactory();
		test.testSaveOrUpdate();
		test.closeResource();
	}
}
