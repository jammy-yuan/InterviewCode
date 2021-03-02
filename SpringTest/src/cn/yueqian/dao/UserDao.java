package cn.yueqian.dao;

import cn.yueqian.domain.User;

public interface UserDao {

	User loginDao(String name, String password);

}