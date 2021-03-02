package com.gec.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.yueqian.domain.User;

public class MyInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
			Object handler) throws IOException {
		HttpSession session = req.getSession(false);
		if(session!=null) {
			User user =(User) session.getAttribute("user");//{ps}获取会话域中的 user
			if(user!=null) {
				return true;
			}
		}
		resp.sendRedirect(req.getContextPath()+"/login.jsp?error=1");
		return false;
	}
	
	

}
