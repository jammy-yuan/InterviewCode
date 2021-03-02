package com.gec.dao;

import com.gec.domain.User;

public interface UserDao {
	public User validateUser(String username, String password);
}
