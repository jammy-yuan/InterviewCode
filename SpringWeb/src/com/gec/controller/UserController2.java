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
		System.out.println("{debug} ������ login()");
		System.out.println(user.getName()+user.getPassword());
		if("andy".equals(user.getName())&&"123".equals(user.getPassword())) {
			path="redirect:/jsp/success.jsp";
			HttpSession session = req.getSession(true);
			session.setAttribute("user", user);
			System.out.println("{deubg} �û���¼�ɹ�...");
		}
		return path;
	}
	@RequestMapping(
			value="/edit",
			produces="text/html;charset=UTF-8"
			)
	@ResponseBody
	public String edit() {
		System.out.println("{debug} ������ edit()");
		return "���� edit() ����";
	}
	@RequestMapping(
			value="/view",
			produces="text/html;charset=UTF-8"
			)
	@ResponseBody
	public String view() {
		System.out.println("{debug} ������ view()");
		return "���� view() ����";
	}

}
