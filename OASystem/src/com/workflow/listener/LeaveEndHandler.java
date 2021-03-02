package com.workflow.listener;

import java.util.Date;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

import com.gec.dao.LeaveMapper;
import com.gec.utils.DateUtils;
import com.gec.utils.MyWebUtils;

public class LeaveEndHandler implements ExecutionListener {

	private LeaveMapper leaveMapper = MyWebUtils.getBean(LeaveMapper.class);

	private void print(Object content) {
		System.out.println(content);
	}

	private void printf(String format, Object... objs) {
		System.out.printf(format, objs);
	}

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		String proInsId = execution.getProcessInstanceId();
		print( "流程实例ID: "+ proInsId );
		Date curDate = new Date();
		String _date = DateUtils.dateToStr( curDate );
		int ret = leaveMapper.saveLeaveStatus(
		proInsId, "2", _date );
		//execution.getVariables();
		this.printf("流程完成",ret);
	}

}
