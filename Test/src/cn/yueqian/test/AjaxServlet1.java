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
		if("����".equals(name)) {
			response.getWriter().write("���˺��ѱ�ע��");
							
		}else if(!password.matches(reg)){
			response.getWriter().write("�����벻�Ϸ�");
		}else if(!code.equals("123456")) {
			response.getWriter().write("��֤�벻��ȷ");
		}else {
			response.getWriter().write("ע��ɹ�");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
