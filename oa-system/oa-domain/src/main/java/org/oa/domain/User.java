package org.oa.domain;

public class User {
	private Integer id;
	private String username;
	private String password;
	private Integer age;
	private Float weight;
	public User() {}
	
	public User(Integer id, String username, String password, Integer age, Float weight) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.age = age;
		this.weight = weight;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		System.out.println("setUsername="+ username);
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
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", age=" + age + ", weight="
				+ weight + "]";
	}

}
