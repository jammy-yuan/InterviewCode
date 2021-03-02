package com.gec.domain;



public class Menu {
	private String id;
	private String parentId;    //父ID
	private String parIds;      //所有父ID的字符串
	private String menuName;    //菜单名称
	private String note;
	private String mapping;     //映射地址
	private String visible;    
	private String permission;  //权限字符串
	
	public String getId() { return id; }
	public void setId(String id) {
		this.id = id;
	}
	
	public String getParentId() { return parentId; }
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	public String getParIds() { return parIds; }
	public void setParIds(String parIds) {
		this.parIds = parIds;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getMapping() {
		return mapping;
	}
	public void setMapping(String mapping) {
		this.mapping = mapping;
	}
	public String getVisible() {
		return visible;
	}
	public void setVisible(String visible) {
		this.visible = visible;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	@Override
	public String toString() {
		return "Menu [id=" + id + ", parentId=" + parentId + ", parIds=" + parIds + ", menuName=" + menuName + ", note="
				+ note + ", mapping=" + mapping + ", visible=" + visible + ", permission=" + permission + "]";
	}
	
}
