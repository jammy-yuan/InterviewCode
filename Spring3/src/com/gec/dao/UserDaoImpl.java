package com.gec.dao;

import org.springframework.stereotype.Repository;

import com.gec.domain.User;

/*
 * @Repository
 * Repository Ӣ��ԭ�� : �ֿ� / �洢��
 * �൱��:
 *     <Bean id="" class="" />
 */
@Repository
public class UserDaoImpl implements UserDao {
	//{ps} Jdbc������ 
	//@Autowired
	public UserDaoImpl(){
		System.out.println("{debug} ���� UserDaoImpl ������..");
	}
	@Override
	public User validateUser(String username, String password) {
		System.out.println("{debug} ���� UserDao.validateUser();");
		return null;
	}
}
