package cn.yueqian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import cn.yueqian.domain.User;
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private DataSource dataSource;
	public UserDaoImpl() {
		System.out.println("调用了UserDao构造器");
	}
	@Override
	public User loginDao(String name,String password) {
		System.out.println("调用了UserDao.loginDao()");
		Connection con = dataSource.getConnection();
		String sql="select * from t_user where user_name=?";
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getString("pass_word").equals(password)) {
					System.out.println("登录成功！"); 
				}else {
					System.out.println("密码错误！"); 
				}
			}else {
				System.out.println(name+","+password);
				System.out.println("用户名不存在！"); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
