package com.gec.test;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;

public class Test1 {
	
	public static void createTable() {
		ProcessEngineConfiguration config = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
		
		//{ps} 连接数据库配置
		config.setJdbcDriver("com.mysql.jdbc.Driver");
		config.setJdbcUrl("jdbc:mysql://localhost:3306/activitis?useUnicode=true&amp;characterEncoding=UTF-8");
		config.setJdbcUsername("root");
		config.setJdbcPassword("root");
		
		//{ps} 设置数据库方案更新策略
		config.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
		
		//{ps} 工作流的核心对象 ProcessEngine
		ProcessEngine engine = config.buildProcessEngine();
		System.out.println("表创建成功！");
	}
	
	public static void createTableByXML() {
		ProcessEngineConfiguration config = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
		ProcessEngine engine = config.buildProcessEngine();
	}
	
	protected static Object dateToStr( Date date ) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = sdf.format( date );
		return format;
	}
	
	static ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
	
	public static void deployProcess() {
		ClassLoader loader = Test1.class.getClassLoader();
		InputStream bpmn = loader.getResourceAsStream("diagrams/MyLeave.bpmn");
		InputStream png = loader.getResourceAsStream("diagrams/MyLeave.png");
		RepositoryService repservice = engine.getRepositoryService();
		Deployment deploy = repservice.createDeployment()
		.name("LeaveProcess")
		.addInputStream("myleave.bpmn", bpmn)
		.addInputStream("myleave.png", png)
		.deploy();
		System.out.println("布署流程-----------------------------------------" ); 
		System.out.println("布署的ID:"+deploy.getId() ); 
		System.out.println("布署时间:"+dateToStr( deploy.getDeploymentTime() ) ); 
		System.out.println("布署名称:"+deploy.getName() ); 
		System.out.println("布署成功-----------------------------------------" ); 
	}
	
	public static void completeZhang() {
		//开启流程实例
		RuntimeService runservice = engine.getRuntimeService();
		ProcessInstance instance = runservice.startProcessInstanceByKey("myProcess");
		
		//查询任务ID
		TaskService taskservice = engine.getTaskService();
		TaskQuery taskQuery = taskservice.createTaskQuery();
		List<Task> list = taskQuery.taskAssignee("张飞").list();
		Task task = list.get(0);
		System.out.println("张飞任务ID:"+task.getId());
		//提交任务
		taskservice.complete(task.getId());
		System.out.println("张飞提交了请假申请");
	}
	
	public static void completeLiu() {
		//查询任务ID
		TaskService taskservice = engine.getTaskService();
		TaskQuery taskQuery = taskservice.createTaskQuery();
		List<Task> list = taskQuery.taskAssignee("刘备").processDefinitionKey("myProcess").list();
		Task task = list.get(0);
		System.out.println("刘备任务ID:"+task.getId());
		//提交任务
		taskservice.complete(task.getId());
		System.out.println("刘备批准了张飞的请假申请");
	}
	
	public static void main(String[] args) {
//		completeLiu();
		createTable();
	}

}











