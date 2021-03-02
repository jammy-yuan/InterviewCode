package com.gec.service;

import java.util.List;

import com.gec.domain.TUser;

public interface UserService {
	public List<TUser> searchUser(String username,Integer startAge,Integer endAge);
	int saveUser();
}
