package com.gec.service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gec.dao.MenuMapper;
import com.gec.domain.Menu;

//{ps} 你这里标记了 注解, 就会被 Spring IoC 容器创建了。
@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuMapper menuMapper;
	/*
		具体流程:
		(1) 调用 menuMapper.getAllMenus 得到 Set<Menu> 。
		(2) 再将 Set<Menu> 转为 Map 。
			 存入格式:
				key="映射地址", value=Menu
			 具体示例:
				key="/User/editUser", value=Menu		
		(3) 返回 Map<Menu> 。
	*/
	@Override
	public Map<String, Menu> getMenuMap() {
		Set<Menu> menuSet = menuMapper.getAllMenus();
		//(2) 再将 Set<Menu> 转为 Map 格式。
		Map<String,Menu> menuMap = new LinkedHashMap<String,Menu>();
		for ( Menu menu : menuSet ) {
			//映射地址: /User/editUser
			String mapping = menu.getMapping(); //{ps} 获取 "映射地址"
			//{ps} key="映射地址", value=Menu
			menuMap.put( mapping, menu );
		}
		return menuMap;
	}
	
}


















