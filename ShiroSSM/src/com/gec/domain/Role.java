package com.gec.domain;

public class Role {
	private String id;
	private String roleName;
	private String descript;
	
	public Role(){}
	public Role(String id, String roleName, String descript) {
		this.id = id;
		this.roleName = roleName;
		this.descript = descript;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", descript=" + descript + "]";
	}
	
}
