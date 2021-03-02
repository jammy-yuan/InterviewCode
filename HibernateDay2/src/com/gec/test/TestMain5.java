package com.gec.test;

import java.util.Set;

import org.junit.Test;
import com.gec.po.Developer;
import com.gec.po.Project;
public class TestMain5 extends BaseMain {

	@Test
	public void testPojectToDeveloper(){
		Project pro = (Project)session.get( Project.class, 10 );
		System.out.println("项目信息:" + pro);
		//{ps} 通过工程来获取, 谁参与了这一个工程 。。
		Set<Developer> devs = pro.getDevelopers();
		for (Developer dev : devs) {
			System.out.println("{开发者}"+ dev);
		}
	}
	
	//@Test
	public void testPersonToIdCard(){
		
	}
	
}
