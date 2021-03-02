package cn.yueqian.service;

import cn.yueqian.dao.Dao;

public class Service {
	private Dao dao;
	public Service() {
		System.out.println("service");
	}
	public void setDao(Dao dao) {
		System.out.println("setdao");
	}

}
