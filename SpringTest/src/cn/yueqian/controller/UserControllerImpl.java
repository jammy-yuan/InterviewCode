package cn.yueqian.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import cn.yueqian.service.UserService;

@Component("userController")
//@Controller("userController")
public class UserControllerImpl implements UserController {
//	@Resource(name="userServiceImpl")
	@Autowired(required=false)
	@Qualifier("userServiceImpl")
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}
	public UserControllerImpl() {
		System.out.println("调用了UserController构造器");
	}
	public void loginController(String name,String password) {
		System.out.println("调用了UserController.loginController()");
		userService.loginService(name, password);
	}
		
}
