package com.gec.dao;

import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.gec.domain.User;

public interface UserMapper {

	User getUserByName(@Param("username") String username);
	
	Set<String> findPermissions(
			@Param("roleId") String roleId );

	Set<String> getRolesByUser(
			@Param("userId") String userId );
	

}
