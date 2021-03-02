package com.gec.dao;

import java.util.List;

import com.gec.domain.Leave;

public interface LeaveMapper {
	
	int addLeave(Leave leave);
    
    List<Leave> getLeave(String initiator,String assignee);
    
    int saveLeaveStatus(String procInsId,String status,String finishtime);

	int updateAssignee(Leave leave);

}
