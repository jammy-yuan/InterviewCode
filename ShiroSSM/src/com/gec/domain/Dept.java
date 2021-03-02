package com.gec.domain;

public class Dept {
	
	private String id;
	private String deptName;  //{ps} 部门名称 
	private String descript;  //{ps} 描述
	private String parentId;  //{ps} 上级部门的ID
	private String parIds;    //{ps} 所有上级部门 ID 组合
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getParIds() {
		return parIds;
	}
	public void setParIds(String parIds) {
		this.parIds = parIds;
	}
	
	@Override
	public String toString() {
		return "Dept [id=" + id + ", deptName=" + deptName + ", descript=" + descript + ", parentId=" + parentId
				+ ", parIds=" + parIds + "]";
	}
	
}
