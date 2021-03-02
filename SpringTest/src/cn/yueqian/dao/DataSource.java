package cn.yueqian.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	private String url;
	private String driver;
	private String username;
	private String password;

	public void setUrl(String url) {
		this.url = url;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// ��������
	boolean flag = false;
	public void loadClass() {
			try {
				Class.forName(driver);
				flag=true;
				System.out.println("flag:"+flag);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	//�õ�����
	public Connection getConnection() {
		if(!flag) {
			loadClass();
		}
		if(flag) {
			try {
				System.out.println("�õ�����");
				return DriverManager.getConnection(url,username,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return null;
	}
	
	//�ر�����
	public void closeConnection(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

















