package com.gec.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;

public class ������ʱ��{
	
//	SpringProcessEngineConfiguration x1;
//	ProcessEngineFactoryBean x2;
	ProcessEngine pe;
	{
		//{ps} ������������, ���涨�� �ķ���
		pe.getRepositoryService();
		//{ps} ����������ʱ��صķ���, �ɻ�ȡ����ʱ��״̬.
		pe.getRuntimeService();
		//{ps} ��ȡ����ִ���е�������Ϣ, ��������
		pe.getTaskService();
		//{ps} ��ȡ��ʷ�����Ϣ, ���Ի�ȡ���ʷ, ������ʷ��
		pe.getHistoryService();
		
		
	}
	
}