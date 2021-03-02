package com.gec.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gec.domain.User;
import com.gec.service.UserService;

@Controller
@RequestMapping("/User")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login( User user, HttpServletRequest req ){
		//{ps} Ä£ÄâÒ»¸ö¼ÙµÇÂ¼
		User svUser = testLogin( user );
		//{ps} µÇÂ¼Ê§°Ü
		String resPath = "redirect:/User/loginFaild";   
		if( svUser!=null ){
			HttpSession session = req.getSession( true );
			session.setAttribute("user", svUser);
			resPath = "redirect:/User/index";
		}
		return resPath;
	}
	
	

	private User testLogin( User user ) {
		String username = user.getUserName();
		if( username.equals("andy") ){
			user.setId("u01");
			user.setRoleName( "employee" );
		}else if( username.equals("candy") ){
			user.setId("u02");
			user.setRoleName( "manager" );
		}else{
			return null;
		}
		return user;
	}
	
	
	

	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
}
