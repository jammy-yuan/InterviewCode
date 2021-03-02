package com.gec.domain;

import java.util.List;

public class User {
	private String id;
	private String username;
	private String password;
	private String nickName;
	private Integer age;
	private Float weight;
	
	//{ps} 多对多的关系
	private List<Role> roles;
	
	//{ps} 多对一关系 [部门]
	private Dept dept;
	
	
	
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public List<Role> getRoles() { return roles; }
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + 
				", password=" + password + ", nickName=" + nickName
				+ ", age=" + age + ", weight=" + weight + "]";
	}
    
}