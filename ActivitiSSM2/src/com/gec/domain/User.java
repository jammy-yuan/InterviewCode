package com.gec.domain;

	public class User {
		private String id;
		private String userName;
		private String passWord;
		private Integer age;
		private Float weight;
		//{ps} ��ʱ��һ����ɫ����
		private String roleName;
		
    public String getRoleName() { return roleName; }
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	
	public User(){
    	System.out.println("{debug} IoC ������ User ...");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
    	System.out.println("{debug} ע���� id = "+ id);
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
    	System.out.println("{debug} ע���� userName = "+ userName);
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
    	System.out.println("{debug} ע���� passWord = "+ passWord);
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
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + 
				passWord + ", age=" + age + ", weight="
				+ weight + "]";
	}
    
}