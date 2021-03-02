package com.gec.test;

import com.alibaba.fastjson.JSONObject;

public class TestMain {
	public static void main(String[] args) {
		JSONObject object = new JSONObject();
		object.put("name", "andy");
		object.put("pass", "123");
		object.put("age", 30);
		object.put("sex", "man");
		object.put("weight", 60);
		String string = object.toJSONString();
		System.out.println(string);
	}

}
