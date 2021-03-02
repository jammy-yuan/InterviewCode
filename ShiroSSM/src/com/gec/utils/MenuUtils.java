package com.gec.utils;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.gec.domain.Menu;
import com.gec.service.MenuService;

public class MenuUtils {

	/*
		{1} 获取 "应用程序域" 中
			 key="menuMap" 的 Map 映射。			 
			 menuMap 中存放的这种格式的数据:	 
			 {1} "/User/editUser"(KEY) ---> Menu (value)
			 {2} "/User/deleteUser"(KEY) ---> Menu (value)
				  ...	 	
		{2} 如果映射不存在, 调用 menuService.getMenuMap 方法
		    得到 map, 再将 map 存入 "应用程序域"
			 (key="menuMap",value=map)
		{3} 返回 map。
	 */

	@SuppressWarnings("unchecked")
	public static Map<String,Menu> getMenuMap(){
		//{1} 获取 "应用程序域" 中  map
		ServletContext webCtx = MyWebUtils.getServletContext();
		Map<String,Menu> menuMap = null;
		print( "获取 menu Map 对象.." );
		menuMap = (Map<String,Menu>)webCtx.getAttribute("menuMap");
		//{2}不一定存在, 不存在怎么办了..
		if( menuMap==null ){  //{ps} 从数据库中获取
			//{ps} 你怎么去拿数据库的数据呢 ..
			//是不是可以从 Spring IoC 容器中获取 MenuService 出来。
			MenuService menuService = MyWebUtils.getBean( MenuService.class );
			menuMap = menuService.getMenuMap();
			webCtx.setAttribute("menuMap", menuMap);
		}
		return menuMap;
	}
	
	private static void print( Object obj ) {
		System.out.println( "{MenuUtils} " + obj);
	}	
}
