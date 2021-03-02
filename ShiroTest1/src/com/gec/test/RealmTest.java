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
		//{1} ׼����һ���� Realm ��ʱ����
				//{2} �û���֤���ݷ��õ����
		SimpleAccountRealm realm = new SimpleAccountRealm();
		realm.addAccount("andy", "123","manager");
		realm.addAccount("candy", "123");
		//{3} ����һ��Ĭ�ϰ�ȫ������
		DefaultSecurityManager manager = new DefaultSecurityManager();
		//{4} ����һ������Դ
		manager.setRealm(realm);
		//{5} �󶨰�ȫ������
		SecurityUtils.setSecurityManager(manager);
		Subject subject = SecurityUtils.getSubject();
		System.out.println("�������û���������");
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
		//System.out.println("��֤���:"+isAuth);
		boolean hasRole = subject.hasRole("manager");
		if(hasRole) {
			System.out.println("������ӵ�о����Ȩ��,�����ڿɷ��ʾ����ܷ��ʵ���Դ...");
		}
		System.out.println("--------------------------------------------------------------------");
	}

}


















