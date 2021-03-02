package com.gec.domain;

public class Hand {
	private String descript;
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
