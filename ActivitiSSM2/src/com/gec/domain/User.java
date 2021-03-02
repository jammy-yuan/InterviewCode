package com.gec.domain;

	public class User {
		private String id;
		private String userName;
		private String passWord;
		private Integer age;
		private Float weight;
		//{ps} 临时加一个角色名称
		private String roleName;
		
    public String getRoleName() { return roleName; }
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	
	public User(){
    	System.out.println("{debug} IoC 创建了 User ...");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
    	System.out.println("{debug} 注入了 id = "+ id);
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
    	System.out.println("{debug} 注入了 userName = "+ userName);
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
    	System.out.println("{debug} 注入了 passWord = "+ passWord);
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