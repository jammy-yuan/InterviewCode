package com.gec.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipInputStream;
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
public class WorkServiceImpl implements WorkService {

	// {ps} 自动装配 activiti 相关的服务对象 ...
	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	private RuntimeService runtimeService;

//	@Autowired
//	private HistoryService historyService;

	@Autowired
	private TaskService taskService;

	final String PRO_KEY = "myProcess";
	
	@Override
	public ProcessInstance doLeave(Leave leave) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("startDate",leave.getStartDate());
		map.put("initcator", leave.getInitcator());
		map.put("reason", leave.getReason());
		map.put("endDate", leave.getEndDate());

		ProcessInstance ins = runtimeService.startProcessInstanceByKey(PRO_KEY,map);
		System.out.println( "---------------------------------------------------------" );
		System.out.println( "开启请假流程 ..." );
		System.out.println( "---------------------------------------------------------" );
		return ins;
	}

	@Override
	public List<Task> queryMyTask(String assignee) {
		List<Task> list = taskService.createTaskQuery()
		.taskAssignee(assignee)
		.list();		
		return list;
	}

	@Override
	public boolean finishTask(String TaskID) {
		Task task = taskService.createTaskQuery()
		.taskId(TaskID)
		.singleResult();
		if(task!=null) {
			taskService.complete(TaskID);
			System.out.println( "---------------------------------------------------------" );
			System.out.println( "该任务已办理好了 ..." );
			System.out.println( "---------------------------------------------------------" );
			return true;
		}
		return false;
	}

	@Override
	public String deployProcDef(String path) throws IOException {
		Deployment deploy =null;
			InputStream in=new FileInputStream(path);
			ZipInputStream zip=new ZipInputStream(in);
			deploy = repositoryService.createDeployment()
			.name("proLeave")
			.addZipInputStream(zip)
			.deploy();
			System.out.println("+----------------------------------------------+");
			System.out.println( "布署ID: "+ deploy.getId() );
			System.out.println( "布署时间: "+ deploy.getDeploymentTime() );
			System.out.println("+----------------------------------------------+");
		return deploy.getId();
	}

}
