package com.gec.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gec.dao.LeaveMapper;
import com.gec.domain.Leave;

@Service
public class WorkSerivceImpl implements WorkService {

	//{ps} 自动装配 activiti 相关的服务对象 ...
	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	private RuntimeService runtimeService;
 
	@Autowired
	private HistoryService historyService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private LeaveMapper leaveMapper;
	
	final String PRO_KEY = "LeaveBill"; 
	
	@Override
	public ProcessInstance doLeave( Leave leave ) {
		
		Map<String,Object> varMap = new HashMap<String,Object>();
		varMap.put( "initcator", leave.getInitcator() );
		varMap.put( "startDate", leave.getStartDate() );
		varMap.put( "endDate", leave.getEndDate() );
		varMap.put( "cancel", false );
		varMap.put( "days", leave.getDays() );
		varMap.put( "reason", leave.getReason() );
		

		ProcessInstance ins = runtimeService.startProcessInstanceByKey(
							PRO_KEY, varMap );
		int ret = this.addLeave(leave);
		System.out.println("插入了"+ret+"条数据");
		
		return ins;
	}
	
	public int addLeave(Leave leave) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createTime = format.format(date);
		leave.setCreateTime(createTime);
		int ret = leaveMapper.addLeave(leave);
		return ret;
	}

	private void print( Object object ) {
		System.out.println( "{WorkService} "+ object );
	}

	@Override
	public List<Task> queryMyTask( String assignee ) {
		List<Task> list = taskService.createTaskQuery()
		.taskAssignee( assignee )     //{ps} 查找assignee的任务 ..
		.list();
		return list;
	}

	//{ps} 完成某人的任务
	@Override
	public boolean finishMyTask( String taskId ){
		//{ps} 先查一下存不存有任务
		Task task = taskService.createTaskQuery()
		.taskId( taskId )
		.singleResult();
		//{ps} 存在这个任务, 则去办理该任务 ...
		if( task!=null ){
			printMark("该任务已办理好了 ...");
			taskService.complete( taskId );
			return true;   //{ps} 我已经办了 ..
		}
		return false;
	}

	private void printMark(String string) {
		print("-------------------------------------------------------------------------------");
		print( "WorkService: "+ string );
		print("-------------------------------------------------------------------------------");
	}

	@Override
	public String deployProcDef( InputStream in ) throws IOException {
		ZipInputStream zipIS = new ZipInputStream( in );
		Deployment deploy = repositoryService.createDeployment()
		.name("LeaveProc")    //{ps} 指定一个布署名称
		.addZipInputStream( zipIS )
		.deploy();
		ProcessDefinition procDef = repositoryService.createProcessDefinitionQuery().
		deploymentId(deploy.getId())
		.singleResult();
		
		print("+----------------------------------------------+");
		print( "布署ID: "+ deploy.getId() );
		print( "布署时间: "+ deploy.getDeploymentTime() );
		print("+----------------------------------------------+");
		return deploy.getId();
	}
	
	

}
