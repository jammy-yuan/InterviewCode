package cn.yueqian.bean;

import java.io.Serializable;

public class User implements Serializable{
	private String name;
	private String sex;
	private int age;
	private String password;
	public User(String name, String password){
		System.out.println("{deubg} 调用了 User(String, String)构造器");
		this.name = name;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("2222");
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
		System.out.println("3333");
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
		System.out.println("4444");
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
		System.out.println("5555");
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", sex=" + sex + ", age=" + age + ", password=" + password + "]";
	}

}
