package com.gec.po;

import java.util.Set;

public class Dept {
	private Integer id;       //��Ӧ���ֶ�: _id
	private String deptName;  //��Ӧ���ֶ�: dept_name
	private String descript;  //��Ӧ���ֶ�: _descript
	private Set<Employee> emps;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Set<Employee> getEmps() {
		return emps;
	}
	public void setEmps(Set<Employee> emps) {
		this.emps = emps;
	}
	

}
