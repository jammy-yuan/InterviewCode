package com.gec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.filter.CharacterEncodingFilter;

import cn.yueqian.domain.User;

@Controller
@RequestMapping("/User")
public class UserController2 {
	@RequestMapping("/login")
	public String login(User user,HttpServletRequest req) {

		String path="redirect:/jsp/error.jsp";
		System.out.println("{debug} 来到了 login()");
		System.out.println(user.getName()+user.getPassword());
		if("andy".equals(user.getName())&&"123".equals(user.getPassword())) {
			path="redirect:/jsp/success.jsp";
			HttpSession session = req.getSession(true);
			session.setAttribute("user", user);
			System.out.println("{deubg} 用户登录成功...");
		}
		return path;
	}
	@RequestMapping(
			value="/edit",
			produces="text/html;charset=UTF-8"
			)
	@ResponseBody
	public String edit() {
		System.out.println("{debug} 来到了 edit()");
		return "来到 edit() 方法";
	}
	@RequestMapping(
			value="/view",
			produces="text/html;charset=UTF-8"
			)
	@ResponseBody
	public String view() {
		System.out.println("{debug} 来到了 view()");
		return "来到 view() 方法";
	}

}
