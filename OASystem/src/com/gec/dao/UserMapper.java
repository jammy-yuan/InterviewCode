package com.gec.dao;

import com.gec.domain.Leave;
import com.gec.domain.User;
import com.gec.domain.UserExample;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User getUserByName(@Param("username") String username );
    
    User getManagerId( @Param("deptid") String deptid,
    		@Param("rolename") String rolename );
    
    User getBossId( @Param("rolename") String rolename );
    
    Set<String> getRolesByUserId( String userId );
    
    Set<String> findPermissions( @Param("roleId")String _roleId );
    
    
}