package com.gec.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;

public class Test2 {
	
	static ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
	
	public static void start() {
		System.out.println("------------------------------------开启流程实例-------------------------------------");
		RuntimeService runService = engine.getRuntimeService();
		ProcessInstance ins = runService.startProcessInstanceByKey("myProcess");
		System.out.println("流程实例 ID: "+ins.getId());
		System.out.println("流程活动 ID: "+ins.getActivityId());
		System.out.println("流程定义 ID: "+ins.getProcessDefinitionId());
		System.out.println("------------------------------------开启流程实例完成------------------------------------");
	}
	
	public static String zhangfeiQuery() {
		TaskService taskService = engine.getTaskService();
		TaskQuery taskQuery = taskService.createTaskQuery();
		List<Task> list = taskQuery.taskAssignee("张飞").list();
		System.out.println("--------------------- 张飞的任务清单 ----------------------------");
		for (Task task : list) {
			System.out.println("任务ID:"+ task.getId() );
			System.out.println("任务名称: "+ task.getName() );
		}
		System.out.println("---------------------------------------------------------------------");
		Task task = list.get(0);
		return task.getId();
	}
	
	public static void commitZhang() {
		String taskID = zhangfeiQuery();
		TaskService taskService = engine.getTaskService();
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("type", "婚嫁");
		map.put("reason","回去结婚");
		map.put("days",10);
		taskService.complete(taskID, map);
		System.out.println("张飞提交了请假申请:"+ taskID);
	}
	
	public static void commitLiu() {
		TaskService taskService = engine.getTaskService();
		TaskQuery query = taskService.createTaskQuery();
		List<Task> list = query.taskAssignee("刘备")
		.processDefinitionKey("myProcess")
		.list();
		printList(list,taskService);
	}
	
	protected static void printMap(Map<String, Object> varMap) {
		System.out.println("---------------------printMap------------------------");
		Set<Entry<String, Object>> entrySet = varMap.entrySet();
		for (Entry<String, Object> entry : entrySet) {
			String key = entry.getKey();
			Object value = entry.getValue();
			System.out.println( "key:"+ key +", value:"+ value );
		}
		System.out.println("---------------------printMap------------------------");
	}
	
	public static void printList(List<Task> list,TaskService taskService) {
		for (Task task : list) {
			String taskID = task.getId();
			Map<String, Object> varMap = taskService.getVariables( taskID );
			printMap( varMap );
			System.out.println( "任务ID: "+ task.getId() );
			System.out.println( "任务描述: "+ task.getDescription() );
			System.out.println( "任务名称: "+ task.getName() );
			System.out.println( "创建日期: "+ task.getCreateTime() );
		}
	}

}

























