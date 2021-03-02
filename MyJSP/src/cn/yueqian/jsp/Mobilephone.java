package cn.yueqian.jsp;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.xmlrpc.base.Array;

import Utils.JDBCUtils;
import cn.yueqian.javabean.Phones;

/**
 * Servlet implementation class Mobilephone
 */
@WebServlet("/Mobilephone")
public class Mobilephone extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql1="select * from mobilephone";
		ResultSet rs1 = JDBCUtils.executeQuery(sql1, null);
		List<Phones> list=new ArrayList<>();
		try {
			while(rs1.next()) {
				Phones phone=new Phones();
				phone.setId(rs1.getString("id"));
				phone.setName(rs1.getString("name"));
				phone.setPrice(rs1.getString("price"));
				list.add(phone);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("phone.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
