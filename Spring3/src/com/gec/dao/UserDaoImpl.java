package com.gec.dao;

import org.springframework.stereotype.Repository;

import com.gec.domain.User;

/*
 * @Repository
 * Repository 英文原意 : 仓库 / 存储器
 * 相当于:
 *     <Bean id="" class="" />
 */
@Repository
public class UserDaoImpl implements UserDao {
	//{ps} Jdbc工厂类 
	//@Autowired
	public UserDaoImpl(){
		System.out.println("{debug} 调用 UserDaoImpl 构造器..");
	}
	@Override
	public User validateUser(String username, String password) {
		System.out.println("{debug} 调用 UserDao.validateUser();");
		return null;
	}
}
