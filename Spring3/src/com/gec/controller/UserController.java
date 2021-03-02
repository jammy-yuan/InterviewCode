package com.gec.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.gec.service.UserService;

//��ͬ��:
//<bean id="��ǰ����" class="��ǰ���ַ" >
@Component
public class UserController {
	
	//��ͬ��: {�����Ͳ���}
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
		System.out.println("{debug} ������: UserController.login()");
		userService.doLogin(username, password);
	}
	
}
