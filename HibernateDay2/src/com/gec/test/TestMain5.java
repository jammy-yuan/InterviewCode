package com.gec.test;

import java.util.Set;

import org.junit.Test;
import com.gec.po.Developer;
import com.gec.po.Project;
public class TestMain5 extends BaseMain {

	@Test
	public void testPojectToDeveloper(){
		Project pro = (Project)session.get( Project.class, 10 );
		System.out.println("��Ŀ��Ϣ:" + pro);
		//{ps} ͨ����������ȡ, ˭��������һ������ ����
		Set<Developer> devs = pro.getDevelopers();
		for (Developer dev : devs) {
			System.out.println("{������}"+ dev);
		}
	}
	
	//@Test
	public void testPersonToIdCard(){
		
	}
	
}
