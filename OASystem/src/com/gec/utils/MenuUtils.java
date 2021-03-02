package com.gec.utils;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.gec.domain.Menu;
import com.gec.service.MenuService;

public class MenuUtils {

	/*
		{1} ��ȡ "Ӧ�ó�����" ��
			 key="menuMap" �� Map ӳ�䡣			 
			 menuMap �д�ŵ����ָ�ʽ������:	 
			 {1} "/User/editUser"(KEY) ---> Menu (value)
			 {2} "/User/deleteUser"(KEY) ---> Menu (value)
				  ...	 	
		{2} ���ӳ�䲻����, ���� menuService.getMenuMap ����
		    �õ� map, �ٽ� map ���� "Ӧ�ó�����"
			 (key="menuMap",value=map)
		{3} ���� map��
	 */

	@SuppressWarnings("unchecked")
	public static Map<String,Menu> getMenuMap(){
		//{1} ��ȡ "Ӧ�ó�����" ��  map
		ServletContext webCtx = MyWebUtils.getServletContext();
		Map<String,Menu> menuMap = null;
		print( "��ȡ menu Map ����.." );
		menuMap = (Map<String,Menu>)webCtx.getAttribute("menuMap");
		//{2}��һ������, ��������ô����..
		if( menuMap==null ){  //{ps} �����ݿ��л�ȡ
			//{ps} ����ôȥ�����ݿ�������� ..
			//�ǲ��ǿ��Դ� Spring IoC �����л�ȡ MenuService ������
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
