package com.gec.domain;

public class Student {
	private Integer id;
	private String name;
	private Squad squad;
	public Student() {}
	public Student(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;

	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Squad getSquad() {
		return squad;
	}
	public void setSquad(Squad squad) {
		this.squad = squad;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	

}
