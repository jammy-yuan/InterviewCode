package com.gec.damain;

public class User {
	private String name;
	private String password;
	private int age;
	private float weight;
	public User() {
		super();
	}
	public User(String name, String password, int age, float weight) {
		super();
		this.name = name;
		this.password = password;
		this.age = age;
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", age=" + age + ", weight=" + weight + "]";
	}
	

}
