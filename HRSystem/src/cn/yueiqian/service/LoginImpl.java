package cn.yueiqian.service;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import cn.yueqian.dao.Crud;
import cn.yueqian.dao.CrudImpl;
import cn.yueqian.javabean.User;
import cn.yueqian.utils.DruidUtils;

public class LoginImpl implements Login {
	Crud crud=new CrudImpl();
	//�жϵ�¼�Ƿ�ɹ�������1�ɹ�������2������󣬷���0���˺Ų�����
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
