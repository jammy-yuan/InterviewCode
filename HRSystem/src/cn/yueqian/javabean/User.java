package cn.yueqian.javabean;

import java.util.Date;

public class User {
	private String loginname;
	private String password;
	private int status;
	private Date createdate;
	private String username;
	
	public User() {
		super();
	}
	public User(String logintime, String password, int status, Date createdate, String username) {
		super();
		this.loginname = logintime;
		this.password = password;
		this.status = status;
		this.createdate = createdate;
		this.username = username;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "User [loginname=" + loginname + ", password=" + password + ", status=" + status + ", createdate="
				+ createdate + ", username=" + username + "]";
	}
	
}
