package com.gec.realms;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.gec.domain.User;
import com.gec.service.UserService;
import com.gec.utils.MyWebUtils;

public class CustomerRealm extends AuthorizingRealm {

String LINE = "+----------------------------------------------------------+";
	
	//{ps} 你在这里设置一个 UserService
	//为什么这里能够用  IoC 容器中的 Bean
	//因为: 在 shiro.xml 中已经配置了 bean
	//<bean id="customRealm" 
	//   class="com.gec.realms.CustomRealm" />
	
	@Autowired
	UserService userService;
	
	public CustomerRealm(){
		printMark("自定义 Realm 被创建了 ...");
	}
	
	private void printMark( Object obj ) {
		System.out.println( LINE );
		System.out.println( obj );
		System.out.println( LINE );
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo( 
			AuthenticationToken token )
			throws AuthenticationException {
		//{ps} 我们会在这里得到一个令牌
		//我们从令牌中获取一个些用户信息出来 ..
		String principal = (String)token.getPrincipal();  //{ps} 获取身份信息..
		print( "令牌中的身份: "+ principal );
		
		//{ps} 获取凭证 / 证书 信息
		//这是得到的是一个字符数组, 每一个字符都保存起来
		char[] credentials = (char[])token.getCredentials();
		String strCredentials = new String( credentials );
		print( "令牌中的凭证: "+strCredentials );
		
		//{3} 真正的去数据库中获取用户的信息
		//userService.getUserByName( 身份 );
		User svUser = userService.getUserByName( principal );
		//User user = getUserFromDB( (String)principal );
		
		
		//{4} 对 user 作一些校验
		if( svUser==null ){  //{ps} 用户不存在
			throw new UnknownAccountException("此用户不存在...");
		}
		if ( !svUser.getPassword().equals(strCredentials) ) {
			throw new IncorrectCredentialsException("密码错误...");
		}
//		if ( user.isLocked() ) {  //{ps} 当前用户已锁定 ...
//			throw new LockedAccountException("当前用户已锁定 ...");
//		}
		//{ps} 能来到这里代表认证通过了 ...
		//{ps} new SimpleAuthenticationInfo( 身份, 凭证, realm名称 );
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
				svUser, strCredentials, "customerRealm" );
		HttpServletRequest req=MyWebUtils.getRequest();
		HttpSession session = req.getSession(true);
		//{ps} 将 User 设置到会话域 ...
		session.setAttribute("user", svUser);
		return info;
	}

	private void print(Object obj ) {
		System.out.println( "{CustomRealm} "+ obj );
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals ) {
		printMark( "[START]" );
		//{ps} 获取从认证信息中获取主身份对象	
		User svUser = (User)principals.getPrimaryPrincipal();
				
		//{ps} 获取用户的所有权限
		//{ps} 调用: userService.getPermissions( List<Roles> );
		Set<String> pers = userService.getPermissions( svUser.getRoles() );
				
		//{ps} 创建 "简单授权信息对象"
		SimpleAuthorizationInfo zInfo = new SimpleAuthorizationInfo();
				
		//{ps} 将权限设置到 "简单授权信息对象" 中
		//{ps} zInfo.setStringPermissions( Set<权限> );
		zInfo.setStringPermissions( pers );

		//{ps} 返回  "授权信息对象" 出去..
		return zInfo;
	}
	
	
	//{ps} 清除缓存
	public void clearCached() {
		printMark("{clearCached} {清理缓存} ..");
		Subject subject = SecurityUtils.getSubject();
		PrincipalCollection prinList = subject.getPrincipals();
		super.clearCache( prinList );
	}

}
