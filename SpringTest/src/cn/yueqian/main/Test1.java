package cn.yueqian.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.yueqian.controller.UserControllerImpl;

public class Test1 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserControllerImpl uc=(UserControllerImpl)context.getBean("userController");
		uc.loginController("¿œÕı", "123");
	}

}
