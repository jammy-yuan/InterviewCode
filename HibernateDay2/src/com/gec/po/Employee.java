package com.gec.po;

public class Employee {
	private Integer id;      //��Ӧ���ֶ�: _id
	private String empName;  //��Ӧ���ֶ�: emp_name
	private Dept dept;       //��Ӧ���ֶ�: ��������
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
