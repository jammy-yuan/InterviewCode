package com.gec.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gec.domain.User;

public interface UserMapper {
	public User getUserById(int id); 
	public List<User> searchUser(User user);
	public int updateUser(User user);
	public List<User> queryUserByName(@Param("nameList") List<String> list);
}
