package com.gec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gec.dao.TUserMapper;
import com.gec.domain.TUser;
import com.gec.domain.TUserExample;
import com.gec.domain.TUserExample.Criteria;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private TUserMapper tUserMapper;

	@Override
	public List<TUser> searchUser(String username, Integer startAge, Integer endAge) {
		TUserExample exp= new TUserExample();
		Criteria cri= exp.createCriteria();
		if(username!=null) {
			cri.andUserNameLike("%"+username+"%");
		}
		if(startAge!=null&&endAge!=null) {
			cri.andAgeBetween(startAge, endAge);
		}
		List<TUser> list = tUserMapper.selectByExample(exp);
		return list;
	}

	@Override
	public int saveUser() {
		TUser user1=new TUser();
		user1.setUserName("candy1");
		TUser user2=new TUser();
		user2.setUserName("candy2");
		tUserMapper.insert(user1);
		System.out.println(6/0);
		int a = tUserMapper.insert(user2);
		return a;
	}

}
