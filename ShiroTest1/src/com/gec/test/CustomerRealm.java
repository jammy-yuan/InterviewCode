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
		// {ps} 我们会在这里得到一个令牌
		// 我们从令牌中获取一个些用户信息出来 ..
		Object principal = token.getPrincipal();// 获得身份信息
		System.out.println("令牌中的身份: " + principal);

		// {ps} 获取凭证 / 证书 信息
		// 这是得到的是一个字符数组, 每一个字符都保存起来
		char[] credentials = (char[]) token.getCredentials();
		String str = new String(credentials);
		System.out.println("令牌中的凭证: " + str);

		// {3} 一般去真正的数据库中获取用户的信息
		User user = getUserFromDB((String) principal);
		
		//{4} 对 user 作一些校验
		if(user==null) {
			throw new UnknownAccountException("用户不存在...................");
		}
		if(!user.getPassword().equals(str)) {
			throw new IncorrectCredentialsException("密码不正确...................");
		}
		if(user.isLocked()) {
			throw new LockedAccountException("用户已被锁...........................");
		}
		
		//{ps} 能来到这里代表认证通过了 ...
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal,str, "cusRealm");
		return info;
	}

	//模拟从数据库拿数据
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
