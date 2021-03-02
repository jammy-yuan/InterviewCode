package com.gec.main;

public class User {
	private String username;
	private String password;
	private int age;
	private double weight;
	
	public User(String username, String password){
		System.out.println("{deubg} 调用了 User(String, String)构造器");
		this.username = username;
		this.password = password;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + 
				password + ", age=" + age + ", weight=" + weight + "]";
	}

}


/*
private String password;
	private int age;
	private double weight;

	public User(){
		System.out.println("{debug} 由 Spring 调用 User 无参构造器 ..");
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		System.out.println("{debug} 由 Spring 调用 User.setUsername [实现依赖注入]");
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		System.out.println("{debug} 由 Spring 调用 User.setPassword [实现依赖注入]");
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		System.out.println("{debug} 由 Spring 调用 User.setAge [实现依赖注入]");
		this.age = age;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		System.out.println("{debug} 由 Spring 调用.setWeight [实现依赖注入]");
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password 
				+ ", age=" + age + ", weight=" + weight + "]";
	}
 */