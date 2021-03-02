package com.gec.test;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class Test1 {
	
	public static void main(String[] args) {
		IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager manager = factory.getInstance();
		SecurityUtils.setSecurityManager(manager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("andy", "123");
		try {
			subject.login(token);
		}catch (AuthenticationException e) {
			e.printStackTrace();
		}
		boolean isAut = subject.isAuthenticated();
		print("andyµÇÂ¼×´Ì¬£º"+isAut);
		subject.logout();
		isAut = subject.isAuthenticated();
		print("andyµÇ³öÁË");
		print("andyµÇÂ¼×´Ì¬£º"+isAut);
	}
	
	public static void print(Object obj) {
		System.out.println("------------------------------------------------------------------");
		System.out.println(obj);
		System.out.println("------------------------------------------------------------------");
	}

}
