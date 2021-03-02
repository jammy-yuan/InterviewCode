package com.gec.po;

import java.util.Set;

//{ps} Project ¿‡
public class Project {
		
	private Integer id;
	private String proName;
	private String proDesc;
	private Set<Developer> developers;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProDesc() {
		return proDesc;
	}
	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}
	public Set<Developer> getDevelopers() {
		return developers;
	}
	public void setDevelopers(Set<Developer> developers) {
		this.developers = developers;
	}
	
	@Override
	public String toString() {
		return "Project [id=" + id + ", proName="+ 
				proName + ", proDesc=" + proDesc + "]";
	}
	
}
