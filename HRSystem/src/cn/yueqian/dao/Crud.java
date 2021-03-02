package cn.yueqian.dao;

import org.apache.commons.dbutils.QueryRunner;

import cn.yueqian.javabean.User;

public interface Crud {
	User read(String name);

}
