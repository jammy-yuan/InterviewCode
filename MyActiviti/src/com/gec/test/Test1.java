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
		
		//{ps} �������ݿ�����
		config.setJdbcDriver("com.mysql.jdbc.Driver");
		config.setJdbcUrl("jdbc:mysql://localhost:3306/activitis?useUnicode=true&amp;characterEncoding=UTF-8");
		config.setJdbcUsername("root");
		config.setJdbcPassword("root");
		
		//{ps} �������ݿⷽ�����²���
		config.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
		
		//{ps} �������ĺ��Ķ��� ProcessEngine
		ProcessEngine engine = config.buildProcessEngine();
		System.out.println("�����ɹ���");
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
		System.out.println("��������-----------------------------------------" ); 
		System.out.println("�����ID:"+deploy.getId() ); 
		System.out.println("����ʱ��:"+dateToStr( deploy.getDeploymentTime() ) ); 
		System.out.println("��������:"+deploy.getName() ); 
		System.out.println("����ɹ�-----------------------------------------" ); 
	}
	
	public static void completeZhang() {
		//��������ʵ��
		RuntimeService runservice = engine.getRuntimeService();
		ProcessInstance instance = runservice.startProcessInstanceByKey("myProcess");
		
		//��ѯ����ID
		TaskService taskservice = engine.getTaskService();
		TaskQuery taskQuery = taskservice.createTaskQuery();
		List<Task> list = taskQuery.taskAssignee("�ŷ�").list();
		Task task = list.get(0);
		System.out.println("�ŷ�����ID:"+task.getId());
		//�ύ����
		taskservice.complete(task.getId());
		System.out.println("�ŷ��ύ���������");
	}
	
	public static void completeLiu() {
		//��ѯ����ID
		TaskService taskservice = engine.getTaskService();
		TaskQuery taskQuery = taskservice.createTaskQuery();
		List<Task> list = taskQuery.taskAssignee("����").processDefinitionKey("myProcess").list();
		Task task = list.get(0);
		System.out.println("��������ID:"+task.getId());
		//�ύ����
		taskservice.complete(task.getId());
		System.out.println("������׼���ŷɵ��������");
	}
	
	public static void main(String[] args) {
//		completeLiu();
		createTable();
	}

}











