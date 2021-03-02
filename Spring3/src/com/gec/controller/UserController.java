package com.gec.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.gec.service.UserService;

//等同于:
//<bean id="当前类名" class="当前类地址" >
@Component
public class UserController {
	
	//等同于: {按类型查找}
	//context.getBean( UserService.class );
	//@Resource
	//@Resource(type=UserService.class)
	
	//@Resource(name="BeanID")
	@Resource(name="userServiceImpl")
	private UserService userService;
	
	public UserController(){
		System.out.println("{debug} UserController()");
	}

	public void login(String username, String password){
		System.out.println("{debug} 调用了: UserController.login()");
		userService.doLogin(username, password);
	}
	
}
