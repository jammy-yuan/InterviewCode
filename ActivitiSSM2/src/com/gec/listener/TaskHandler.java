package com.gec.listener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

	public class TaskHandler implements TaskListener {
		private static final long serialVersionUID = 1L;
		@Override
		public void notify( DelegateTask task ) {
			//{ps} 当前方法将会在什么时候执行 ?
			// 这一个是根据  myleave.bpmn 文件的设置来定..
			// 我指定了在刚创建 经理审批的任务时, 调用本方法。

			//{ps} 当前方法可以做什么事情 ?
			//{1} 获取流程变量, 设置流程变量。
			//{2} 还可以指定当前任务节点的办理人
			//(因为当前任务的办理人还不明确)
			//System.out.println("{debug} TaskHandler ---> notify()");
			
			//{3} 我已经拿到部门 ID
			String leader = getLeaderByDeptId( "dp01" );
			if( leader!=null ){  //{ps} 找到一个办理人
				System.out.println("{debug} 设置当前任务的办理人:"+ leader);
				task.setAssignee( leader );  //设置领导 ..
			}else{
				//{PS} 我们将来在网关处理这个事情 ..
				//task.setVariable( "exception", "NO_Assignee" );
			}
		}
		//{ps} 模拟从数据库中获取办理人的 ID
		public String getLeaderByDeptId( String deptId ){
			if( deptId.equals("dp01") ){  //开发部的领导 ..
				return "u02";    //u02 ---> candy [经理]
			}
			return null;
		}
	}
	
	
	


	
	