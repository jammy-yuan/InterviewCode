package com.gec.domain;

public class Leave {

	//(1) �ύ˭��� (��ʱ����Ч, ��Ϊ�����ļ���д����)
		//initcator: ���̵ķ�����
		private String initcator;

		//(2) ��ٵĿ�ʼʱ��: startDate
		private String startDate;
		
		//(3) ��ٵĽ���ʱ��: endDate
		private String endDate;

		//(4) ��ٵ�ԭ��: reason
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
