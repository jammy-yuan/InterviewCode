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
		// ����ajax���͹���������
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println("ajax--->" + username + "," + password);
		// ��������
		if(username.equals("����")) {
			response.getWriter().write("�˺��Ѵ���");
		}else {
			if(!password.equals("123456")) {
				response.getWriter().write("�������");
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
