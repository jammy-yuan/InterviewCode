package com.gec.service;

import java.util.List;
import java.util.Set;

import com.gec.domain.Role;
import com.gec.domain.User;

public interface UserService {

	User getUserByName( String principal );

	Set<String> getPermissions(List<Role> roles);

}

	
	
	