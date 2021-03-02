package com.gec.test;

import java.util.List;

import org.hibernate.Query;

import com.gec.po.Employee;

public class HQLDemo1 extends BaseMain{
	public void test() {
		String hql="from Employee";
		Query query = session.createQuery(hql);
		List<Employee> list = query.list();
		for (Employee emp : list) {
			System.out.printf("id:{%d},%s,%s",emp.getId(),emp.getEmpName(),emp.getDept());
		}
	}
	public static void main(String[] args) {
		
	}
}
