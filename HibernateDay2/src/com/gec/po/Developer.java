package com.gec.po;

import java.util.Set;

public class Developer {
	//{ps} Developer ¿‡
	private Integer id;
	private String devName;
	private Integer age;
	private Set<Project> projects;
	
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDevName() {
		return devName;
	}
	public void setDevName(String devName) {
		this.devName = devName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Developer [id=" + id + ", devName=" + devName + ", age=" + age + "]";
	}
	
}
