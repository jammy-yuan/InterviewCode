package com.gec.test;

import java.util.Set;
import org.junit.Test;
import com.gec.po.Dept;
import com.gec.po.Employee;
public class TestMain3 extends BaseMain {

	//@Test
	public void testManyToOne(){
		//{ps} 查找一个员工对象, 		
		Employee emp1 = (Employee)session.get( Employee.class, 2 );  //Candy
		System.out.println( emp1 );
		
		//{ps} 看看能否获取 Dept 相关信息..
		Dept dept = emp1.getDept();
		System.out.println( dept );
		//测试结果: [id=1, deptName=IT事业部, descript=负责软件开发与设计]
		
	}
	
	@Test
	public void testOneToMany(){
		Dept dept = (Dept)session.get(Dept.class, 1);
		System.out.println("部门信息:" + dept);
		int count = 0;
		Set<Employee> emps = dept.getEmps();
		for (Employee emp : emps) {
			count ++;
			System.out.printf("员工%d: %s\n", count, emp.toString() );
		}
		//{结果}
		//Dept [id=1, deptName=IT事业部, descript=负责软件开发与设计]
		//员工1: Employee [id=3, empName=luby]
		//员工2: Employee [id=2, empName=candy]
		//员工3: Employee [id=1, empName=andy]
	}
	
	
}
