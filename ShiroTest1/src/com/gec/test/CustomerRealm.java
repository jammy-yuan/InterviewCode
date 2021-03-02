package com.gec.test;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.realm.AuthenticatingRealm;

import com.gec.domain.User;

public class CustomerRealm extends AuthenticatingRealm {

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// {ps} ���ǻ�������õ�һ������
		// ���Ǵ������л�ȡһ��Щ�û���Ϣ���� ..
		Object principal = token.getPrincipal();// ��������Ϣ
		System.out.println("�����е����: " + principal);

		// {ps} ��ȡƾ֤ / ֤�� ��Ϣ
		// ���ǵõ�����һ���ַ�����, ÿһ���ַ�����������
		char[] credentials = (char[]) token.getCredentials();
		String str = new String(credentials);
		System.out.println("�����е�ƾ֤: " + str);

		// {3} һ��ȥ���������ݿ��л�ȡ�û�����Ϣ
		User user = getUserFromDB((String) principal);
		
		//{4} �� user ��һЩУ��
		if(user==null) {
			throw new UnknownAccountException("�û�������...................");
		}
		if(!user.getPassword().equals(str)) {
			throw new IncorrectCredentialsException("���벻��ȷ...................");
		}
		if(user.isLocked()) {
			throw new LockedAccountException("�û��ѱ���...........................");
		}
		
		//{ps} ���������������֤ͨ���� ...
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal,str, "cusRealm");
		return info;
	}

	//ģ������ݿ�������
	private User getUserFromDB(String username) {
		User user=null;
		if(username.equals("andy")) {
			user=new User();
			user.setPassword("123");
		}else if(username.equals("candy")) {
			user=new User();
			user.setPassword("456");
			user.setLocked(true);
		}
		return user;
	}

}
