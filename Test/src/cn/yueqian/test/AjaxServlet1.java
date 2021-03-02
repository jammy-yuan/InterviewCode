package cn.yueqian.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxServlet1
 */
@WebServlet("/AjaxServlet1")
public class AjaxServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String code=request.getParameter("check");
		String reg="123456";
		if("张三".equals(name)) {
			response.getWriter().write("该账号已被注册");
							
		}else if(!password.matches(reg)){
			response.getWriter().write("该密码不合法");
		}else if(!code.equals("123456")) {
			response.getWriter().write("验证码不正确");
		}else {
			response.getWriter().write("注册成功");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
