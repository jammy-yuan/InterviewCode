package com.gec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.gec.dao.Userdao;
@Service
public class UserService {
	@Autowired
	private Userdao userDao;
	public void update() {
		userDao.updateUser(3, 50.8f);
		System.out.println(5/0);
		userDao.updateUser(2, 40.8f);
	}
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		UserService service = (UserService)ctx.getBean(UserService.class);
		service.update();
	}
}
