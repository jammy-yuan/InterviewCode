package com.gec.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
//改造后的controller
@Controller
@RequestMapping("/User")
public class UserController{

//	@RequestMapping(value="/file",method=RequestMethod.POST)
//	//@PathVariable：用占位符的方式获取映射地址中的字符串
//	public void login() {
//		System.out.println("x=");
//	}
//	public ModelAndView login(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//		System.out.println("调用了UserController");
//		ModelAndView mav = new ModelAndView("success");
//		mav.addObject("user","andy");
//		return mav;
//	}
	
	@RequestMapping(
			value={"/getJson"},
			produces="application/json"
	)
	@ResponseBody
	public String getJson() {
		return "{\"name\":\"andy\",\"pass\":\"123\"}";
	}
	
//	private String path="C:\\Users\\DDD\\Desktop\\151\\img\\7307";
//	@RequestMapping(
//			value= {"/getImag"},
//			produces= {"image/jpg"}
//	)
//	@ResponseBody
//	public byte[] getImag(@RequestParam("filename") String filename) {
//		
//		
//		return null;
//	}
//	public static byte[] getFile(String path) {
//		try {
//			InputStream in = new FileInputStream(path);
//			new byte[in.via]
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
	
}
