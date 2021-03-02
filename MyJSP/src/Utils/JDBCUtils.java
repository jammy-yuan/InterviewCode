package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * �Լ���װһ��������
 * 
 * @author gec
 *
 */
public class JDBCUtils {
	private static String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";// url
	private static String user = "root";
	private static String password = "";// ���û�������д����
	private static Connection ct = null;

	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	// 1.�����������ŵ���̬�������,��Ϊֻ�ü���һ��
	static {
		// * 1.������������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// * 2.Connection��������ӣ� �������ݿ����Ӷ���ÿһ��Connection����һ���������ӻỰ��
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

	// 3.��д��ѯ�ķ���
	public static ResultSet executeQuery(String sql, String[] str) {
		// 2.������ӡ�
		ct = getConnection();// ��������Լ�д��
		try {
			// �õ�����sql���Ķ���
			ps = ct.prepareStatement(sql);
			// ����ռλ������
			if (str != null) {
				for (int i = 0; i < str.length; i++) {
					ps.setString(i + 1, str[i]);
				}
			}
			// ����sql���
			rs = ps.executeQuery();
			return rs;// ���ؽ����

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// 4.��дһ����ɾ�ĵķ���
	public static int executeUpdate(String sql, String[] str) {
		// 2.������ӡ�
		ct = getConnection();// ��������Լ�д��
		try {
			// �õ�����sql���Ķ���
			ps = ct.prepareStatement(sql);
			// ����ռλ������
			if (str != null) {
				for (int i = 0; i < str.length; i++) {
					ps.setString(i + 1, str[i]);
				}
			}
			// ����sql���
			int in = ps.executeUpdate();
			if (in > 0) {

			} else {
				System.out.println("����ʧ��");
			}
			// �ر���Դ
			close(ct, ps, rs);
			return in;// ���ؽ����

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	// ��дһ������������Դ
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
