package com.gec.po;

public class IdCard {
	private Integer id;
	private String descript;
	
	//{ps} 
	private Person person;	
	public Person getPerson() { return person; }
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	
	@Override
	public String toString() {
		return "IdCard [id=" + id + ", descript=" + descript + "]";
	}

}
