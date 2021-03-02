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
	
	//{ps} ������������һ�� UserService
	//Ϊʲô�����ܹ���  IoC �����е� Bean
	//��Ϊ: �� shiro.xml ���Ѿ������� bean
	//<bean id="customRealm" 
	//   class="com.gec.realms.CustomRealm" />
	
	@Autowired
	UserService userService;
	
	public CustomerRealm(){
		printMark("�Զ��� Realm �������� ...");
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
		//{ps} ���ǻ�������õ�һ������
		//���Ǵ������л�ȡһ��Щ�û���Ϣ���� ..
		String principal = (String)token.getPrincipal();  //{ps} ��ȡ�����Ϣ..
		print( "�����е����: "+ principal );
		
		//{ps} ��ȡƾ֤ / ֤�� ��Ϣ
		//���ǵõ�����һ���ַ�����, ÿһ���ַ�����������
		char[] credentials = (char[])token.getCredentials();
		String strCredentials = new String( credentials );
		print( "�����е�ƾ֤: "+strCredentials );
		
		//{3} ������ȥ���ݿ��л�ȡ�û�����Ϣ
		//userService.getUserByName( ��� );
		User svUser = userService.getUserByName( principal );
		//User user = getUserFromDB( (String)principal );
		
		
		//{4} �� user ��һЩУ��
		if( svUser==null ){  //{ps} �û�������
			throw new UnknownAccountException("���û�������...");
		}
		if ( !svUser.getPassword().equals(strCredentials) ) {
			throw new IncorrectCredentialsException("�������...");
		}
//		if ( user.isLocked() ) {  //{ps} ��ǰ�û������� ...
//			throw new LockedAccountException("��ǰ�û������� ...");
//		}
		//{ps} ���������������֤ͨ���� ...
		//{ps} new SimpleAuthenticationInfo( ���, ƾ֤, realm���� );
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
				svUser, strCredentials, "customerRealm" );
		HttpServletRequest req=MyWebUtils.getRequest();
		HttpSession session = req.getSession(true);
		//{ps} �� User ���õ��Ự�� ...
		session.setAttribute("user", svUser);
		return info;
	}

	private void print(Object obj ) {
		System.out.println( "{CustomRealm} "+ obj );
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals ) {
		printMark( "[START]" );
		//{ps} ��ȡ����֤��Ϣ�л�ȡ����ݶ���	
		User svUser = (User)principals.getPrimaryPrincipal();
				
		//{ps} ��ȡ�û�������Ȩ��
		//{ps} ����: userService.getPermissions( List<Roles> );
		Set<String> pers = userService.getPermissions( svUser.getRoles() );
				
		//{ps} ���� "����Ȩ��Ϣ����"
		SimpleAuthorizationInfo zInfo = new SimpleAuthorizationInfo();
				
		//{ps} ��Ȩ�����õ� "����Ȩ��Ϣ����" ��
		//{ps} zInfo.setStringPermissions( Set<Ȩ��> );
		zInfo.setStringPermissions( pers );

		//{ps} ����  "��Ȩ��Ϣ����" ��ȥ..
		return zInfo;
	}
	
	
	//{ps} �������
	public void clearCached() {
		printMark("{clearCached} {������} ..");
		Subject subject = SecurityUtils.getSubject();
		PrincipalCollection prinList = subject.getPrincipals();
		super.clearCache( prinList );
	}

}
