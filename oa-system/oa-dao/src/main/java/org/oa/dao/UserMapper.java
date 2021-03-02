package org.oa.dao;

import java.util.List;
import org.oa.domain.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {
	public User getUserById(int id); 
	public List<User> searchUser(User user);
	public int updateUser(User user);
	public List<User> queryUserByName(@Param("nameList") List<String> list);
}
