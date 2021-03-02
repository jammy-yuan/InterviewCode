package com.gec.listener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

	public class TaskHandler implements TaskListener {
		private static final long serialVersionUID = 1L;
		@Override
		public void notify( DelegateTask task ) {
			//{ps} ��ǰ����������ʲôʱ��ִ�� ?
			// ��һ���Ǹ���  myleave.bpmn �ļ�����������..
			// ��ָ�����ڸմ��� ��������������ʱ, ���ñ�������

			//{ps} ��ǰ����������ʲô���� ?
			//{1} ��ȡ���̱���, �������̱�����
			//{2} ������ָ����ǰ����ڵ�İ�����
			//(��Ϊ��ǰ����İ����˻�����ȷ)
			//System.out.println("{debug} TaskHandler ---> notify()");
			
			//{3} ���Ѿ��õ����� ID
			String leader = getLeaderByDeptId( "dp01" );
			if( leader!=null ){  //{ps} �ҵ�һ��������
				System.out.println("{debug} ���õ�ǰ����İ�����:"+ leader);
				task.setAssignee( leader );  //�����쵼 ..
			}else{
				//{PS} ���ǽ��������ش���������� ..
				//task.setVariable( "exception", "NO_Assignee" );
			}
		}
		//{ps} ģ������ݿ��л�ȡ�����˵� ID
		public String getLeaderByDeptId( String deptId ){
			if( deptId.equals("dp01") ){  //���������쵼 ..
				return "u02";    //u02 ---> candy [����]
			}
			return null;
		}
	}
	
	
	


	
	