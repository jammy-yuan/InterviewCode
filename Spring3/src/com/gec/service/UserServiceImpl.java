package com.gec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gec.dao.UserDao;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	public UserServiceImpl(){
		System.out.println("{debug} UserSerivce() ������ ...");
	}
	@Override
	public void doLogin(String username, String password) {
		System.out.println("{debug} ������ UserService.doLogin()");
		userDao.validateUser(username, password);
	}
}
