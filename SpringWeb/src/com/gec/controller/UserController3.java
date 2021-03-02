package com.gec.controller;


import java.util.List;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import cn.yueqian.domain.User;

@Controller
@RequestMapping("/User")
public class UserController3 {
	@RequestMapping("/register")
	public ModelAndView register(@Valid User user,BindingResult br) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/User/index");
		int count = br.getFieldErrorCount();//�õ������ֶ���
		System.out.println(count);
		List<FieldError> list = br.getFieldErrors();
		if(count>0) {
			mav.setViewName("forward:/register.jsp");
			for (FieldError e : list) {
				String field = e.getField();//�õ������ֶ���
				String message = e.getDefaultMessage();//�õ�������Ϣ����
				System.out.println(message);
				mav.addObject("error_"+field, message);
			}
		}
		
		return mav;
	}
}
