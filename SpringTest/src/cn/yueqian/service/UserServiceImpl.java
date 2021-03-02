package cn.yueqian.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yueqian.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	public UserServiceImpl() {
		System.out.println("������UserService������");
	}
	/* (non-Javadoc)
	 * @see cn.yueqian.service.UserService#loginService(java.lang.String, java.lang.String)
	 */
	@Override
	public void loginService(String name,String password) {
		System.out.println("������UserService.loginService()");
		userDao.loginDao(name, password);
	}
}
