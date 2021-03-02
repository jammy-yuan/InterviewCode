package com.gec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gec.dao.UserDao;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	public UserServiceImpl(){
		System.out.println("{debug} UserSerivce() 构造器 ...");
	}
	@Override
	public void doLogin(String username, String password) {
		System.out.println("{debug} 调用了 UserService.doLogin()");
		userDao.validateUser(username, password);
	}
}
