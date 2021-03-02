package com.gec.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gec.domain.TUser;
import com.gec.domain.User;
import com.gec.service.UserService;
@Controller
@RequestMapping("/User")
public class UserController {
	UserController(){
		System.out.println("UserController");
	}
	
	@Autowired
	private UserService userService;
	@RequestMapping("/test")
	public ModelAndView test(
			@RequestParam(required=false) String username, 
			@RequestParam(required=false) Integer startAge, 
			@RequestParam(required=false) Integer endAge) {
		List<TUser> users = userService.searchUser(username, startAge, endAge);
		ModelAndView view = new ModelAndView("userList");
		for (TUser tUser : users) {
			print( tUser );
		}
		System.out.println("------------------------------------025");
		view.addObject("users", users);
		return view;
	}
	private void print(Object obj) {
		System.out.println( "UserController: "+ obj );
	}
	
	@RequestMapping("/test2")
	public String test2() {		
		int i = userService.saveUser();
		if(i>0) {
			return "success";
		}
		return "fail";
	}
	
	public User testLogin(User user) {
		String userName = user.getUserName();
		if(userName.equals("andy")) {
			user.setId("u01");
			user.setRoleName("employee");
		}else if(userName.equals("candy")) {
			user.setId("u02");
			user.setRoleName("manager");
		}else {
			return null;
		}
		return user;
	}
	
	@RequestMapping("/login")
	public String login(User user,HttpServletRequest req) {
		String path="redirect:/User/loginFailed";
		User user2 = testLogin(user);
		if(user2!=null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("user", user2);
			path="redirect:/User/index";
		}
		return path;
	}
	
}


//@RequestMapping("/hello")
//public String hello(){
//	return "success";
//}