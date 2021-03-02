package com.gec.test;

import java.util.Scanner;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;

public class RealmTest {
	public static void main(String[] args) {
		//{1} 准备好一个简单 Realm 临时测试
				//{2} 用户认证数据放置到这里。
		SimpleAccountRealm realm = new SimpleAccountRealm();
		realm.addAccount("andy", "123","manager");
		realm.addAccount("candy", "123");
		//{3} 创建一个默认安全管理器
		DefaultSecurityManager manager = new DefaultSecurityManager();
		//{4} 设置一下数据源
		manager.setRealm(realm);
		//{5} 绑定安全管理器
		SecurityUtils.setSecurityManager(manager);
		Subject subject = SecurityUtils.getSubject();
		System.out.println("请输入用户名和密码");
		Scanner sc=new Scanner(System.in);
		String username = sc.next();
		String pass = sc.next();
		UsernamePasswordToken token = new UsernamePasswordToken(username, pass);
		try {
			subject.login(token);
		}catch (AuthenticationException e) {
			e.printStackTrace();
		}
		boolean isAuth = subject.isAuthenticated(); 
		System.out.println("--------------------------------------------------------------------");
		//System.out.println("认证结果:"+isAuth);
		boolean hasRole = subject.hasRole("manager");
		if(hasRole) {
			System.out.println("你现在拥有经理的权限,你现在可访问经理能访问的资源...");
		}
		System.out.println("--------------------------------------------------------------------");
	}

}


















