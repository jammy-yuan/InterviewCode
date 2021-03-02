package com.gec.domain;

import java.util.List;

public class Squad {
	private Integer id;
	private String name;
	private List<Student> students;
	public Squad() {}
	public Squad(Integer id, String name, List<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.students = students;
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
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Squad [id=" + id + ", name=" + name +  "]";
	}
	
}
