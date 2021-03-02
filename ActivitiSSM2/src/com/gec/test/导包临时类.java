package com.gec.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;

public class 导包临时类{
	
//	SpringProcessEngineConfiguration x1;
//	ProcessEngineFactoryBean x2;
	ProcessEngine pe;
	{
		//{ps} 用来布署流程, 保存定义 的服务
		pe.getRepositoryService();
		//{ps} 与流程运行时相关的服务, 可获取运行时的状态.
		pe.getRuntimeService();
		//{ps} 获取流程执行中的任务信息, 办理任务。
		pe.getTaskService();
		//{ps} 获取历史相关信息, 可以获取活动历史, 任务历史。
		pe.getHistoryService();
		
		
	}
	
}