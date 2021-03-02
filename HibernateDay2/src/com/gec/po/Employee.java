package com.gec.po;

public class Employee {
	private Integer id;      //对应表字段: _id
	private String empName;  //对应表字段: emp_name
	private Dept dept;       //对应表字段: 归属部门
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
}
