package cn.yueqian.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
	@NotEmpty(message="�û�������Ϊ��")
	@Length(min=2,max=10,message="�û�������Ӧ��2-10֮��")
	private String name;
	@Length(min=6,max=18,message="���볤��Ӧ��6-18֮��")
	private String password;
	@Min(value=12,message="δ��12�����߲��ܵ�¼")
	@Max(value=100,message="�û�����ӦС��100��")
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
