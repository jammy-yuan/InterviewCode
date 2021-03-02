package com.gec.filters;

import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import com.gec.domain.Menu;
import com.gec.utils.MenuUtils;

public class MappingFilter extends AuthorizationFilter{
	@Override
	protected boolean isAccessAllowed( ServletRequest _req, 
			ServletResponse _resp, Object value ) throws Exception {
		HttpServletRequest req = (HttpServletRequest)_req;
		
		//{1} ֪�������ڷ��ʵ���ʲô��ַ...
		String uri = req.getRequestURI();   //{Ps} /User/viewList
		String ctxPath = req.getContextPath();
		uri = uri.replace( ctxPath, "" );
		
		//print( "[MappingFilter] URI: "+ uri );
		
		String[] arr = (String[])value;
		for ( String uri_str : arr ) {
			//print( "[MappingFilter] uri_str: "+ uri_str );
			boolean ok = uri.startsWith( uri_str );
			if( ok ){
				return true;
			}
		}
		
		//{2} ��һ����һ����ַ��Ӧ�Ĳ˵�
		Map<String, Menu> menuMap = MenuUtils.getMenuMap();
		Menu menu = menuMap.get( uri );
		if( menu!=null ){  //{ps} �������������ôһ���˵�..
			//{ps}�õ�������һ���˵�����Ҫ��Ȩ��
			String curPermission = menu.getPermission();
			//{ps} �ǵ��û���û�з��ʴ˲˵���Ȩ���� ?
			//{ps} �ұ���õ���ǰ���û� (����) �ɡ�
			Subject subject = SecurityUtils.getSubject();

			//{1} �ж���û��ĳ��Ȩ��: ���쳣
			//subject.checkPermission( curPermission );
			printMark( "[MappingFilter] ��ǰ��Ҫ��Ȩ��: "+ curPermission );
			System.out.println( "[MappingFilter] ����Ȩ��: "+ curPermission );
			Object principal = subject.getPrincipal();
			System.out.println("[MappingFilter] {��ݶ���} "+ principal.getClass() );
			
			boolean ret = subject.isPermitted( curPermission );
			if( ret ) {
				printMark( "����Ȩ���ʴ���Դ: "+ curPermission );
			}else {
				printMark( "����Ȩ���ʴ���Դ: "+ curPermission );
			}
			//{2} �ж���û��ĳ��Ȩ��: ����  true / false
			return ret;
		}
		return false;   //{ps} false �����㲻�ܷ���
	}
	

	private void print( Object obj ) {
		System.out.println( "{ShiroFilter} "+ obj );
	}
	
	private void printMark( Object obj ) {
		System.out.println( "+---------------------------------------------------------+" );
		System.out.println( "{ShiroFilter} "+ obj );
		System.out.println( "+---------------------------------------------------------+" );
	}
}





