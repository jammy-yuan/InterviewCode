package com.gec.test;

import java.util.Scanner;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

import com.gec.domain.User;

public class RealmTest2 {
	public static User getUser() {
		System.out.println("请输入用户名与密码：");
		Scanner sc = new Scanner(System.in);
		String username = sc.next();
		String pass = sc.next();
		User user = new User();
		user.setUsername(username);
		user.setPassword(pass);
		sc.close();
		return user;
	}
	
	public static void main(String[] args) {
		CustomerRealm realm = new CustomerRealm();
		DefaultSecurityManager manager = new DefaultSecurityManager();
		manager.setRealm(realm);
		SecurityUtils.setSecurityManager(manager);
		Subject subject = SecurityUtils.getSubject();
		User user = getUser();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
		try {
			subject.login(token);
		}catch (AuthenticationException e) {
			e.printStackTrace();
		}
		System.out.println("---------------------------------------------");
		System.out.println("认证是否通过:"+subject.isAuthenticated());
		System.out.println("---------------------------------------------");
	}

}
