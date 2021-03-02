package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 自己封装一个工具类
 * 
 * @author gec
 *
 */
public class JDBCUtils {
	private static String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";// url
	private static String user = "root";
	private static String password = "";// 如果没有密码就写“”
	private static Connection ct = null;

	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	// 1.将加载驱动放到静态代码块中,因为只用加载一次
	static {
		// * 1.（加载驱动）
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// * 2.Connection（获得连接） 代表数据库连接对象，每一个Connection代表一个物理连接会话。
	public static Connection getConnection() {
		//Connection ct = null;
		try {
			ct = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ct;
	}

	// 3.编写查询的方法
	public static ResultSet executeQuery(String sql, String[] str) {
		// 2.获得连接、
		ct = getConnection();// 这个方法自己写的
		try {
			// 得到发送sql语句的对象
			ps = ct.prepareStatement(sql);
			// 处理占位符问题
			if (str != null) {
				for (int i = 0; i < str.length; i++) {
					ps.setString(i + 1, str[i]);
				}
			}
			// 发送sql语句
			rs = ps.executeQuery();
			return rs;// 返回结果集

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// 4.编写一个增删改的方法
	public static int executeUpdate(String sql, String[] str) {
		// 2.获得连接、
		ct = getConnection();// 这个方法自己写的
		try {
			// 得到发送sql语句的对象
			ps = ct.prepareStatement(sql);
			// 处理占位符问题
			if (str != null) {
				for (int i = 0; i < str.length; i++) {
					ps.setString(i + 1, str[i]);
				}
			}
			// 发送sql语句
			int in = ps.executeUpdate();
			if (in > 0) {

			} else {
				System.out.println("操作失败");
			}
			// 关闭资源
			close(ct, ps, rs);
			return in;// 返回结果集

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	// 编写一个方法，关资源
	public static void close(Connection ct, PreparedStatement ps, ResultSet rs) {
		try {

			if (rs != null) {
				rs.close();
			}

			if (ps != null) {
				ps.close();
			}
			if (ct != null) {
				ct.close();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static Connection getCt() {
		return ct;
	}

	public static PreparedStatement getPs() {
		return ps;
	}

	public static ResultSet getRs() {
		return rs;
	}

}
