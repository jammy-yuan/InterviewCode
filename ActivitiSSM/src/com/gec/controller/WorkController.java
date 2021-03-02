package com.gec.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gec.domain.Leave;
import com.gec.domain.TUser;
import com.gec.service.WorkService;

@Controller
@RequestMapping("/Work")
public class WorkController {
	
	@Autowired
	private WorkService workService;
	
	@RequestMapping("/doLeave")
	public String doLeave(Leave leave,Model model) {
		ProcessInstance ins = workService.doLeave(leave);
		model.addAttribute("instance", ins);
		return "leaveInfo";
	}
	
	@RequestMapping("/queryMyTask")
	public String queryTask(String assignee,Model model) {
		System.out.println( "-----------------------------------------------------------------------------------" );
		System.out.println( "查询某人的待办任务: "+ assignee );
		System.out.println( "-----------------------------------------------------------------------------------" );
		List<Task> myTask = workService.queryMyTask(assignee);
		model.addAttribute("myTask", myTask);
		return "queryMyTask";
	}

	@RequestMapping("/finishTask")
	public String finishTask(@RequestParam String taskID,HttpSession session) {
		TUser user=(TUser)session.getAttribute("user");
		boolean ret = workService.finishTask(taskID);
		int err=(ret)?0:1;
		String path="redirect:/Work/queryMyTask?assignee="+user.getId()+"&errcode="+err;
		return path;
	}
	
	//{ps} 填写请假单
	@RequestMapping("/showLeaveBill")
	public String showLeaveBill(Leave leave) {
		return "showLeaveBill";
	}
	
	@RequestMapping(
			value="/deployProcDef",
			produces="text/html;charset=UTF-8")
	@ResponseBody
	public String deployProDef() {
		String path="D:\\feiq\\zip.zip";
		String deployID=null;
		try {
			deployID=workService.deployProcDef(path);
		} catch (IOException e) {
			return "布署流程失败: "+ e.getMessage();
		}
		return "布署流程成功: deployId: "+ deployID;
	}
}










