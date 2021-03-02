package com.gec.service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gec.dao.MenuMapper;
import com.gec.domain.Menu;

//{ps} ���������� ע��, �ͻᱻ Spring IoC ���������ˡ�
@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuMapper menuMapper;
	/*
		��������:
		(1) ���� menuMapper.getAllMenus �õ� Set<Menu> ��
		(2) �ٽ� Set<Menu> תΪ Map ��
			 �����ʽ:
				key="ӳ���ַ", value=Menu
			 ����ʾ��:
				key="/User/editUser", value=Menu		
		(3) ���� Map<Menu> ��
	*/
	@Override
	public Map<String, Menu> getMenuMap() {
		Set<Menu> menuSet = menuMapper.getAllMenus();
		//(2) �ٽ� Set<Menu> תΪ Map ��ʽ��
		Map<String,Menu> menuMap = new LinkedHashMap<String,Menu>();
		for ( Menu menu : menuSet ) {
			//ӳ���ַ: /User/editUser
			String mapping = menu.getMapping(); //{ps} ��ȡ "ӳ���ַ"
			//{ps} key="ӳ���ַ", value=Menu
			menuMap.put( mapping, menu );
		}
		return menuMap;
	}
	
}


















