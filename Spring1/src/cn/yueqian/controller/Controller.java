package cn.yueqian.controller;

import cn.yueqian.service.Service;

public class Controller {
	private Service service;
	public Controller() {
		System.out.println("controller");
	}
	public void setService(Service service) {
		System.out.println("setService");
	}

}
