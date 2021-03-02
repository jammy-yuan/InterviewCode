package cn.yueqian.javabean;

public class Employee {
	private String username;
	private String number;
	private String password;
	private String sex;

	public Employee() {}
	public Employee(String username, String number, String password, String sex) {
		super();
		this.username = username;
		this.number = number;
		this.password = password;
		this.sex = sex;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Employee [username=" + username + ", number=" + number + ", password=" + password + ", sex=" + sex
				+ "]";
	}

}
