package com.gec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gec.dao.UserMapper;
import com.gec.domain.User;
import com.gec.domain.UserExample;
import com.gec.domain.UserExample.Criteria;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> searchUser( String username, 
			Integer ageStart, Integer ageEnd ) {
		UserExample exp =new UserExample();
		Criteria cri = exp.createCriteria();
		if( username!=null ){
			cri.andUserNameLike( "%"+ username +"%" );
		}
		if( ageStart!=null && ageEnd!=null ){
			cri.andAgeBetween(ageStart, ageEnd);
		}
		List<User> userList = userMapper.selectByExample( exp );
		return userList;
	}
	
	private void print(Object object) {
		System.out.println("{debug}" + object);
	}

	@Override
	public void saveUser() {
		User user1 = new User();
		User user2 = new User();
		userMapper.saveUser( user1 );
		print( 5 / 0);
		userMapper.saveUser( user2 );
	}

}
