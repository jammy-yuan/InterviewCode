package com.gec.service;

import java.util.List;

import com.gec.domain.User;

	public interface UserService {
		
		List<User> searchUser(String username, 
				Integer ageStart, Integer ageEnd);

		void saveUser();
	
	}

	
	
	