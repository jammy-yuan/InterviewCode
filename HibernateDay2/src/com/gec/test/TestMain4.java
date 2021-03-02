package com.gec.test;

import org.junit.Test;
import com.gec.po.IdCard;
import com.gec.po.Person;

public class TestMain4 extends BaseMain {

	//@Test
	public void testIdCardToPerson(){
		IdCard idCard = (IdCard)session.get(IdCard.class, 1);
		System.out.println( "身份证: "+ idCard );
		Person person = idCard.getPerson();
		System.out.println( "person: "+ person );
	}
	
	@Test
	public void testPersonToIdCard(){
		Person person = (Person)session.get( Person.class, 2 );
		System.out.println( "人:"+ person );
		IdCard idCard = person.getIdCard();
		System.out.println( "身份证:"+ idCard );
	}
	
	
}
