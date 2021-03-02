package com.workflow.listener;

import java.util.List;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import com.gec.domain.Role;
import com.gec.domain.User;
import com.gec.service.UserService;
import com.gec.utils.MyWebUtils;

public class LeaveTaskHandler implements TaskListener {
	private static final long serialVersionUID = 1L;

	private static final String LINE = 
			"+-------------------------------------------------------+";

	private UserService userService = MyWebUtils.getBean(UserService.class);
	private final String DEPT_ROLE = "manager";
	private final String BOSS_ROLE = "boss";

	@Override
	public void notify(DelegateTask task) {
		// ��õ�ǰ�û�
		User user = MyWebUtils.getCurrentUser();
		List<Role> roles = user.getRoles();
		String roleName = roles.get(0).getRolename();
		String taskId = task.getId();
		String procInsId = task.getProcessInstanceId();
		String procDefId = task.getProcessDefinitionId();
		if (roleName.equals("employee")) {
			String deptId = user.getDept().getId();
			printMark( "deptId = "+ deptId );
			String mangerId = userService.findDeptManagerId(deptId, DEPT_ROLE);
			
			printMark( procDefId, procInsId, taskId, mangerId ); 
			
			task.setAssignee(mangerId);
			int ret = userService.updateAssignee(procDefId, procInsId, taskId, mangerId);
			System.out.println("LeaveTaskHandler������"+ret+"������");
		} else if (roleName.equals("manager")) {
			// {1}�����Ǿ��� candy ��� complete �����������ء�

			// {2}��������������:
			// ˳����: ${days>5} ����������ǰ����
			// {3}���� "��ǰ����" ��ִ����Ϊ "u03" (boss)
			String bossId = userService.findBoss(BOSS_ROLE);
			task.setAssignee(bossId);
			int ret = userService.updateAssignee(procDefId, procInsId, taskId, bossId);
			System.out.println("LeaveTaskHandler������"+ret+"������");
		}
	}

	private void printMark( Object...args) {
		System.out.println( LINE );
		int i = 0;
		for (Object object : args) {
			System.out.println( "["+ i +"]"+ object );
		}
		System.out.println( LINE );
	}

	private void printMark(String string) {
		System.out.println( LINE );
		System.out.println( string );
		System.out.println( LINE );
	}

}
