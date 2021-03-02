package com.gec.po;

public class User implements java.io.Serializable {

	private static final long serialVersionUID = -7871537535570710117L;
	
	//{ps} 尽量不要用基础类型: int, byte, short, double
	private Integer id;
	private String userName;
	private String passWord;
	private Integer age;
	private Float weight;
	
	//{ps} 无参构造器
	public User(){	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
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
		return "User [id=" + id + ", userName=" + userName + ", passWord=" +
				passWord + ", age=" + age + ", weight="
				+ weight + "]";
	}

}
