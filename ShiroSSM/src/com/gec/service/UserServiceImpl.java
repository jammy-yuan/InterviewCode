package com.gec.service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gec.dao.UserMapper;
import com.gec.domain.Role;
import com.gec.domain.User;

@Service
public class UserServiceImpl implements UserService{
	private final String SYMBOL = "+------------------------------------------------------+";
	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUserByName(String principal) {
		User user = userMapper.getUserByName((String) principal);
		if(user==null) {
			return null;
		}
		printUser(user);
		return user;
	}
	
	public static void printUser(User user) {
		System.out.println("-----------------------------------------------------");
		System.out.println("UserService"+user);
		List<Role> roles = user.getRoles();
		for (Role role : roles) {
			System.out.println(role);
		}
		System.out.println("-----------------------------------------------------");
	}

	@Override
	public Set<String> getPermissions(List<Role> roles) {
		Iterator<Role> it = roles.iterator();
		if(it.hasNext()) {
			String id = it.next().getId();
			Set<String> myPermissions = userMapper.findPermissions( id );
			print( SYMBOL );
			int i = 0;
			for ( String per : myPermissions ) {
				i ++;
				printf("[%d] per:{%s}\n", i, per );
			}
			print( SYMBOL );
			return myPermissions;
		}
		return null;
	}

	private void print(String obj) {
		System.out.println( obj );
	}
	
	private void printf(String format, Object...arg) {
		System.out.printf( format, arg );
	}

}
