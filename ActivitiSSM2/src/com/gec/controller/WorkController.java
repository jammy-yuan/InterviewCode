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
import com.gec.domain.User;
import com.gec.service.WorkService;

@Controller
@RequestMapping("/Work")
public class WorkController {

	@Autowired
	private WorkService workService;
	
	@RequestMapping("/doLeave")
	public String doLeave( Leave leave, Model model ){
		ProcessInstance ins = workService.doLeave( leave );
		model.addAttribute( "instance", ins );
		return "leaveInfo";
	}
	
	
	
	
	@RequestMapping("/queryMyTask")
	public String queryMyTask( String assignee, Model model ){
		List<Task> list = workService.queryMyTask( assignee );
		model.addAttribute( "list", list );
		//{ps} forward: /WEB-INF/jsp/queryMyTask.jsp
		return "queryMyTask";
	}

	
	
	@RequestMapping("/finishMyTask")
	public String finishMyTask( @RequestParam String taskId, 
			HttpSession session ){
		User user = (User)session.getAttribute("user");
		boolean ret = workService.finishMyTask( taskId );
		int err = (ret) ? 0 : 1;
		String resPath = "redirect:/Work/queryMyTask?assignee="+ user.getId() 
						 +"&errcode="+ err;
		return resPath;
	}
	
	
	
	private void print(Object obj) {
		System.out.println( "{WORK_CON} "+ obj );
	}

	
	//{ps} ��д��ٵ�
	//Link: /Work/showLeaveBill
	@RequestMapping("/showLeaveBill")
	public String showLeaveBill( Leave leave ){
		//{ps} forward �� /WEB-INF/jsp/showLeaveBill.jsp ҳ
		return "showLeaveBill";   
	}
	
	
	
	
	
	//{ps} �ƹ��ļ�ֱ�Ӷ������ļ�
	//     ��������ʱ, ��Ҫʹ���ļ���ִ�С�
	@RequestMapping(
		value="/deployProcDef",
		produces="text/html;charset=UTF-8"
	)
	@ResponseBody
	public String deployProcDef(){
		String path = "D:\\feiq\\zip\\myleave.zip";
		String deployId;
		try {
			deployId = workService.deployProcDef( path );
		} catch (IOException e) {
			return "��������ʧ��: "+ e.getMessage();  
		}
		return "�������̳ɹ�: deployId: "+ deployId;  
	}
	
	
	
	

}
