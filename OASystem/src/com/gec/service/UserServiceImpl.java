package com.gec.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gec.controller.WorkController;
import com.gec.dao.LeaveMapper;
import com.gec.dao.UserMapper;
import com.gec.domain.Leave;
import com.gec.domain.Role;
import com.gec.domain.User;

@Service
public class UserServiceImpl implements UserService{
	private final String SYMBOL = "+------------------------------------------------------+";
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private LeaveMapper leaveMapper;

	@Override
	public User getUserByName(Object principal) {
		User user = userMapper.getUserByName((String) principal);
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

	@Override
	public String findDeptManagerId(String deptId, String DEPT_ROLE) {
		User user = userMapper.getManagerId(deptId, DEPT_ROLE);		
		return user.getId();
	}
	
	@Override
	public int updateAssignee(String procDefId,String procInsId, String taskId, String mangerId) {
		Leave leave = new Leave();
		leave.setAssignee( mangerId );
		leave.setProcInstId( procInsId );
		leave.setProcDefId(procDefId);
		leave.setTaskId( taskId );
		leave.setStatus("1");
		int ret = leaveMapper.updateAssignee( leave );
		return ret;
	}

	@Override
	public String findBoss(String bOSS_ROLE) {
		User boss = userMapper.getBossId(bOSS_ROLE);
		return boss.getId();
	}

}
