package com.gec.utils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.gec.domain.User;


public class MyWebUtils {
	
	public MyWebUtils(){
		print("-------------------------------");
		print("������: MyWebUtils ");
		print("-------------------------------");
	}

	private void print(Object obj) {
		System.out.println(obj);
	}
	
	public static <T> T getBean( Class<T> type ){
		//{ps} WebApplicationContext === Spring IoC ���� ..
		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		//{ps} ������ xml �����, �����ע��� java ����, �����õ�
		return context.getBean( type );
	}

	public static HttpServletRequest getRequest(){
		ServletRequestAttributes attr = (ServletRequestAttributes)
				RequestContextHolder.getRequestAttributes();
		HttpServletRequest req = attr.getRequest();
		return req;
	}
	
	public static User getCurrentUser(){
		HttpServletRequest req = MyWebUtils.getRequest();
		HttpSession session = req.getSession();
		User user = null;
		if( session!=null ){
			user = (User)session.getAttribute("user");
		}
		return user;
	}
	
	public static ServletContext getServletContext(){
		//{ps} ��ȡ��ǰ Web ����������
		ServletContext context = ContextLoader
				.getCurrentWebApplicationContext()
				.getServletContext();
		return context;
	}
}
