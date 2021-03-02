package cn.yueqian.jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxDemo
 */
@WebServlet("/AjaxDemo")
public class AjaxDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收ajax发送过来的数据
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println("ajax--->" + username + "," + password);
		// 返回数据
		if(username.equals("张三")) {
			response.getWriter().write("账号已存在");
		}else {
			if(!password.equals("123456")) {
				response.getWriter().write("密码错误");
			}else {
				response.getWriter().write("true");
			}
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
