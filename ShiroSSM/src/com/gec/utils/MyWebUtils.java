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
		print("创建了: MyWebUtils ");
		print("-------------------------------");
	}

	private void print(Object obj) {
		System.out.println(obj);
	}
	
	public static <T> T getBean( Class<T> type ){
		//{ps} WebApplicationContext === Spring IoC 容器 ..
		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		//{ps} 所有在 xml 中配的, 标记有注解的 java 对象, 都能拿到
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
		//{ps} 获取当前 Web 程序上下文
		ServletContext context = ContextLoader
				.getCurrentWebApplicationContext()
				.getServletContext();
		return context;
	}
}
