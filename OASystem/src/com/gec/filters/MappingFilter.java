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
		
		//{1} 知道你现在访问的是什么地址...
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
		
		//{2} 找一下这一个地址对应的菜单
		Map<String, Menu> menuMap = MenuUtils.getMenuMap();
		Menu menu = menuMap.get( uri );
		if( menu!=null ){  //{ps} 如果真正存在这么一个菜单..
			//{ps}得到访问这一个菜单所需要的权限
			String curPermission = menu.getPermission();
			//{ps} 那底用户有没有访问此菜单的权限呢 ?
			//{ps} 我必须得到当前的用户 (主体) 吧。
			Subject subject = SecurityUtils.getSubject();

			//{1} 判断有没有某个权限: 抛异常
			//subject.checkPermission( curPermission );
			printMark( "[MappingFilter] 当前需要的权限: "+ curPermission );
			System.out.println( "[MappingFilter] 访问权限: "+ curPermission );
			Object principal = subject.getPrincipal();
			System.out.println("[MappingFilter] {身份对象} "+ principal.getClass() );
			
			boolean ret = subject.isPermitted( curPermission );
			if( ret ) {
				printMark( "你有权访问此资源: "+ curPermission );
			}else {
				printMark( "你无权访问此资源: "+ curPermission );
			}
			//{2} 判断有没有某个权限: 返回  true / false
			return ret;
		}
		return false;   //{ps} false 代表你不能访问
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





