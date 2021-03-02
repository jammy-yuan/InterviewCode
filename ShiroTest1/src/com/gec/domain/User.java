package com.gec.domain;

public class User {
	private String username;
	private String password;
	private boolean locked;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", locked=" + locked + "]";
	}
	

}
