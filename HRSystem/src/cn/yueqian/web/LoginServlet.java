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
 * Servlet implementation class ConnectJSP
 */
@WebServlet("/ConnectJSP")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		Login login = new LoginImpl();
		int islogin = login.login(name, password);		
		// 1.�õ�Session���е���֤��
		HttpSession session = request.getSession();
		String session_code = (String) session.getAttribute("checkcode");
		// 2.�õ��û��������֤��
		String input_code = request.getParameter("check");
		System.out.println("session_code==" + session_code + ",input_code==" + input_code);
		// 3.����code���Ƚ�
		if (input_code.equalsIgnoreCase(session_code)) {
			System.out.println("success");
			// ��֤����ȷ
			if (islogin == 1) {
				System.out.println("111111111");
				request.getRequestDispatcher("sucess.jsp").forward(request, response);
			} else if (islogin == 2) {
				System.out.println("222222222");
				response.getWriter().append("alert('���벻��ȷ')");
				request.getRequestDispatcher("Log.jsp").forward(request, response);
			} else {
				System.out.println("00000000000");
				response.getWriter().append("alert('�˺Ų�����')");
				request.getRequestDispatcher("Log.jsp").forward(request, response);
			}

		} else {
			System.out.println("fail");
			response.getWriter().append("alert('��֤�벻��ȷ')");
			response.sendRedirect("/HRSystem/Log.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
