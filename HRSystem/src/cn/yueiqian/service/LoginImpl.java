package cn.yueiqian.service;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import cn.yueqian.dao.Crud;
import cn.yueqian.dao.CrudImpl;
import cn.yueqian.javabean.User;
import cn.yueqian.utils.DruidUtils;

public class LoginImpl implements Login {
	Crud crud=new CrudImpl();
	//判断登录是否成功，返回1成功，返回2密码错误，返回0则账号不存在
	public int login(String name, String password) {		
		
		 User user = crud.read(name);
		if(null!=user) {
			String pass=user.getPassword();
			if(pass.equals(password)) {
				return 1;
			}else {
				return 2;
			}
		}
		return 0;
	}
	public List getList() {
		return null;
	}

}
