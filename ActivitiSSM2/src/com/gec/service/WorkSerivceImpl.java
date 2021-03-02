package com.gec.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	final String PRO_KEY = "myProcess"; 
	
	@Override
	public ProcessInstance doLeave( Leave leave ) {
		Map<String,Object> varMap = new HashMap<String,Object>();
		varMap.put( "initcator", leave.getInitcator() );
		varMap.put( "startDate", leave.getStartDate() );
		varMap.put( "endDate", leave.getEndDate() );
		varMap.put( "reason", leave.getReason() );

		ProcessInstance ins = runtimeService.startProcessInstanceByKey(
							PRO_KEY, varMap );
		return ins;
	}
	

	private void print( Object object ) {
		System.out.println( "{WorkService} "+ object );
	}

	//{ps} 查找张飞的任务
	@Override
	public List<Task> queryMyTask( String assignee ) {
		//assignee = "张飞";
		List<Task> list = taskService.createTaskQuery()
		.taskAssignee( assignee )     //{ps} 查找张飞的任务 ..
		//.orderByTaskCreateTime()
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
	public String deployProcDef( String path ) throws IOException {
		InputStream is = new FileInputStream( path );
		ZipInputStream zipIS = new ZipInputStream( is );
		Deployment deploy = repositoryService.createDeployment()
		.name("LeaveProc")    //{ps} 指定一个布署名称
		.addZipInputStream( zipIS )
		.deploy();
		print("+----------------------------------------------+");
		print( "布署ID: "+ deploy.getId() );
		print( "布署时间: "+ deploy.getDeploymentTime() );
		print("+----------------------------------------------+");
		return deploy.getId();
	}
	
	

}
