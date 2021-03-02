package com.gec.domain;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class LeaveConfig {
	private String procDefId;
	private Integer ref;
	private Integer version;
	private String key;
	@JSONField(format="yyyy-MM-dd")
	private Date createDate;
	public String getProcDefId() {
		return procDefId;
	}
	public void setProcDefId(String procDefId) {
		this.procDefId = procDefId;
	}
	public Integer getRef() {
		return ref;
	}
	public void setRef(Integer ref) {
		this.ref = ref;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "LeaveConfig [procDefId=" + procDefId + ", ref=" + ref + ", version=" + version + ", key=" + key
				+ ", createDate=" + createDate + "]";
	}

}
