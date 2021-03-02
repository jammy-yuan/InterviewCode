package cn.yueqian.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
	@NotEmpty(message="用户名不能为空")
	@Length(min=2,max=10,message="用户名长度应在2-10之间")
	private String name;
	@Length(min=6,max=18,message="密码长度应在6-18之间")
	private String password;
	@Min(value=12,message="未满12周岁者不能登录")
	@Max(value=100,message="用户年龄应小于100岁")
	private int age;
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
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", age=" + age + "]";
	}
	
	

}
