package cn.yueqian.dao;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import cn.yueqian.javabean.Department;
import cn.yueqian.javabean.Employee;
import cn.yueqian.javabean.Job;
import cn.yueqian.javabean.QueryResult;
import cn.yueqian.javabean.User;
import cn.yueqian.utils.DruidUtils;

public class CrudImpl implements Crud {
	// ��ѯ������user
	public User read(String name) {
		QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
		String sql = "select * from user_inf where loginname=?";
		Object[] params = { name };// ռλ��
		User user = null;
		try {
			user = qr.query(sql, params, new BeanHandler<User>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(user);
		return user;
	}

	// ��ѯһ������
	public QueryResult getlist(String tablename, int startindex, int pagesize) {
		QueryResult qr = new QueryResult();
		QueryRunner query = new QueryRunner(DruidUtils.getDataSource());
		String sql = "select * from " + tablename + "limit " + startindex + "," + pagesize;
		// �õ�һ�����ϣ����
		List<?> list = null;
		try {
			switch (tablename) {
			case "dept_inf":
				list = query.query(sql, new BeanListHandler<Department>(Department.class));
				break;
			case "job_inf":
				list = query.query(sql, new BeanListHandler<Job>(Job.class));
				break;
			case "user_inf":
				list = query.query(sql, new BeanListHandler<User>(User.class));
				break;
			case "employee_inf":
				list = query.query(sql, new BeanListHandler<Employee>(Employee.class));
				break;
			}
			qr.setList(list);
			sql = "select count(*) from" + tablename;
			String str = String.valueOf(query.query(sql, new ScalarHandler()));
			int in = Integer.parseInt(str);
			if (in != 0) {
				qr.setTotalrecord(in);
				System.out.println("�ܼ�¼��-��" + in + "��");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qr;
	}

	// ��������
	public int insert(String tablename, Object obj) {
		QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
		String sql = "insert into users(username,pw)value(?,?)";
		Object[] param = { "����", "123456" };
		try {
			int i = qr.update(sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
