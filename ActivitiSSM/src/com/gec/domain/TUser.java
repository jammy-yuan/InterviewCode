package com.gec.domain;

public class TUser {
    private Integer id;

    private String userName;

    private String passWord;

    private Integer age;

    private Float weight;

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
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
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
		return "TUser [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", age=" + age + ", weight="
				+ weight + "]";
	}
    
}