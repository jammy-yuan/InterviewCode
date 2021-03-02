package com.gec.po;

public class Person {
	
	private Integer id;      //{ps} �ֶ���: id
	private String name;     //{ps} �ֶ���: name
	private Integer age;     //{ps} �ֶ���: age
	private IdCard idCard;   //{ps} ��������
	
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public IdCard getIdCard() {
		return idCard;
	}
	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
}
