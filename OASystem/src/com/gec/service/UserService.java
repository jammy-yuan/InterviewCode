package com.gec.service;

import java.util.List;
import java.util.Set;

import com.gec.domain.Role;
import com.gec.domain.User;

public interface UserService {

	User getUserByName( Object principal );

	Set<String> getPermissions(List<Role> roles);

	String findDeptManagerId(String deptId, String DEPT_ROLE);

	int updateAssignee(String procDefId,String procInsId, String taskId, String mangerId);

	String findBoss(String bOSS_ROLE);

}

	
	
	