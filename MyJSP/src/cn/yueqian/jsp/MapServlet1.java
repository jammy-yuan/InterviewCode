package cn.yueqian.jsp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yueqian.javabean.Employee;

/**
 * Servlet implementation class MapServlet1
 */
@WebServlet("/MapServlet1")
public class MapServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Employee> map=new HashMap<>();
		Employee emp1=new Employee("emp1", "1", "123", "ÄÐ");
		Employee emp2=new Employee("emp2", "2", "123", "ÄÐ");
		Employee emp3=new Employee("emp3", "3", "123", "ÄÐ");
		Employee emp4=new Employee("emp4", "4", "123", "ÄÐ");
		Employee emp5=new Employee("emp5", "5", "123", "ÄÐ");
		map.put("1", emp1);
		map.put("2", emp1);
		map.put("3", emp1);
		map.put("4", emp1);
		map.put("5", emp1);
		request.setAttribute("map", map);
		request.getRequestDispatcher("mapdemo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
