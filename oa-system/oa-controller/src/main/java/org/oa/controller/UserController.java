package org.oa.controller;

import org.oa.domain.User;
import org.oa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/User")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/testMybatis")
	public ModelAndView testMybatis(@RequestParam(required = false) String username,
			@RequestParam(required = false) Integer ageStart, @RequestParam(required = false) Integer ageEnd) {
		// ---- 填入你的代码 --------
		return null;
	}

	@RequestMapping("/testTransaction")
	public String testTransaction() {
		User user = new User();
		userService.searchUser(user);
		return null;
	}
}