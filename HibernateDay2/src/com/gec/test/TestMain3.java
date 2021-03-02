package com.gec.test;

import java.util.Set;
import org.junit.Test;
import com.gec.po.Dept;
import com.gec.po.Employee;
public class TestMain3 extends BaseMain {

	//@Test
	public void testManyToOne(){
		//{ps} ����һ��Ա������, 		
		Employee emp1 = (Employee)session.get( Employee.class, 2 );  //Candy
		System.out.println( emp1 );
		
		//{ps} �����ܷ��ȡ Dept �����Ϣ..
		Dept dept = emp1.getDept();
		System.out.println( dept );
		//���Խ��: [id=1, deptName=IT��ҵ��, descript=����������������]
		
	}
	
	@Test
	public void testOneToMany(){
		Dept dept = (Dept)session.get(Dept.class, 1);
		System.out.println("������Ϣ:" + dept);
		int count = 0;
		Set<Employee> emps = dept.getEmps();
		for (Employee emp : emps) {
			count ++;
			System.out.printf("Ա��%d: %s\n", count, emp.toString() );
		}
		//{���}
		//Dept [id=1, deptName=IT��ҵ��, descript=����������������]
		//Ա��1: Employee [id=3, empName=luby]
		//Ա��2: Employee [id=2, empName=candy]
		//Ա��3: Employee [id=1, empName=andy]
	}
	
	
}
