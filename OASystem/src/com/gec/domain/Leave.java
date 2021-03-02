package com.gec.domain;

public class Leave {
	
	//(1) 提交谁请假 (暂时是无效, 因为流程文件已写死了)
	//initcator: 流程的发起人
	private String initcator;

	//(2) 请假的开始时间: startDate
	private String startDate;
	
	//(3) 请假的结束时间: endDate
	private String endDate;

	//(4) 请假的原因: reason
	private String reason;
	private String procInstId;
	private String taskId;
	private int days;
	private String createTime;
	private String finishTime;
	private String procDefId;
	private String assignee;
	private String status;

	public String getProcInstId() {
		return procInstId;
	}

	public void setProcInstId(String procInstId) {
		this.procInstId = procInstId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}

	public String getProcDefId() {
		return procDefId;
	}

	public void setProcDefId(String procDefId) {
		this.procDefId = procDefId;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInitcator() {
		return initcator;
	}

	public void setInitcator(String initcator) {
		this.initcator = initcator;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "Leave [initcator=" + initcator + ", startDate=" + startDate + ", endDate=" + endDate + ", reason="
				+ reason + ", procInstId=" + procInstId + ", taskId=" + taskId + ", days=" + days + ", createTime="
				+ createTime + ", finishTime=" + finishTime + ", procDefId=" + procDefId + ", assignee=" + assignee
				+ ", status=" + status + "]";
	}

}
