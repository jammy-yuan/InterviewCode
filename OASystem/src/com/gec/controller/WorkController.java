package com.gec.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
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
import org.springframework.web.multipart.MultipartFile;

import com.gec.domain.Leave;
import com.gec.domain.User;
import com.gec.service.WorkService;
import com.gec.utils.DateUtils;

@Controller
@RequestMapping("/Work")
public class WorkController {

	@Autowired
	private WorkService workService;
	
	@RequestMapping("/doLeave")
	public String doLeave( Leave leave, Model model ){
		Date t1 = DateUtils.strToDate(leave.getStartDate());
		Date t2 = DateUtils.strToDate(leave.getEndDate());
		int days = DateUtils.calculateDays(t1, t2);
		leave.setDays( days );
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
		System.out.println(ret+"finishtask11111111111111111");
		int err = (ret) ? 0 : 1;
		String resPath = "redirect:/Work/queryMyTask?assignee="+ user.getId() 
						 +"&errcode="+ err;
		System.out.println(resPath);
		return resPath;
	}
	
	private void print(Object obj) {
		System.out.println( "{WORK_CON} "+ obj );
	}

	//{ps} 填写请假单
	//Link: /Work/showLeaveBill
	@RequestMapping("/showLeaveBill")
	public String showLeaveBill( Leave leave ){
		//{ps} forward 到 /WEB-INF/jsp/showLeaveBill.jsp 页
		return "showLeaveBill";   
	}
	
	//{ps} 直接上传本地文件
	@RequestMapping("/doUpload")
	public String doUpload(@RequestParam("zipFile")MultipartFile file) {
		InputStream in;
		try {
			 in= file.getInputStream();
			 workService.deployProcDef(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/Work/procList";
	}
	
	

}
