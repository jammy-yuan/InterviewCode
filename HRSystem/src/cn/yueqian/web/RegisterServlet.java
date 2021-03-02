package cn.yueqian.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yueiqian.service.Login;
import cn.yueiqian.service.LoginImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("username");
		String password = request.getParameter("newpassword");
		String password2 = request.getParameter("newpassword2");
		String check = request.getParameter("newcheck");
		String passreg = "(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,18}";
		Login login = new LoginImpl();
		if (null != name) {
			int islogin = login.login(name, null);
			if (islogin == 2) {
				response.getWriter().write("该用户已被创建！");
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
