package com.gec.domain;

public class Body {
	private String descript;
	public Body() {
		System.out.println("{debug} ����: Body ������...");
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	@Override
	public String toString() {
		return "Foot [descript=" + descript + "]";
	}
}
