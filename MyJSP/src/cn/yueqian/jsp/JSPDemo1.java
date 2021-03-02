package cn.yueqian.jsp;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.JDBCUtils;
import cn.yueqian.javabean.Employee;

/**
 * Servlet implementation class JSPDemo1
 */
@WebServlet("/JSPDemo1")
public class JSPDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sql = "select * from employee";
		ResultSet rs=JDBCUtils.executeQuery(sql, null);	    
	    List<Employee> list=new ArrayList<>();
		try {
			while(rs.next()) {
				Employee emp=new Employee();
				emp.setNumber(rs.getString("number"));
				emp.setPassword(rs.getString("password"));
				emp.setUsername(rs.getString("username"));
				emp.setSex(rs.getString("sex"));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//¹Ø±Õ×ÊÔ´
			JDBCUtils.close(JDBCUtils.getCt(), JDBCUtils.getPs(), rs);
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("jstlDemo1.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
