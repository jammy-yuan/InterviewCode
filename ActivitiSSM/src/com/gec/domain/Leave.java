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
			return "Leave [initcator=" + initcator + ", startDate=" + 
					startDate + ", endDate=" + endDate + ", reason="
					+ reason + "]";
		}
}
