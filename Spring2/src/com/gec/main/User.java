package com.gec.main;

public class User {
	private String username;
	private String password;
	private int age;
	private double weight;
	
	public User(String username, String password){
		System.out.println("{deubg} ������ User(String, String)������");
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
		System.out.println("{debug} �� Spring ���� User �޲ι����� ..");
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		System.out.println("{debug} �� Spring ���� User.setUsername [ʵ������ע��]");
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		System.out.println("{debug} �� Spring ���� User.setPassword [ʵ������ע��]");
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		System.out.println("{debug} �� Spring ���� User.setAge [ʵ������ע��]");
		this.age = age;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		System.out.println("{debug} �� Spring ����.setWeight [ʵ������ע��]");
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password 
				+ ", age=" + age + ", weight=" + weight + "]";
	}
 */