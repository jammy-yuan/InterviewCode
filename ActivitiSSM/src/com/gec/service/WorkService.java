package com.gec.service;

import java.io.IOException;
import java.util.List;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import com.gec.domain.Leave;

public interface WorkService {
	ProcessInstance doLeave(Leave leave);
	List<Task> queryMyTask(String assignee);
	boolean finishTask(String TaskID);
	String deployProcDef(String path) throws IOException;

}
