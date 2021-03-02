package com.gec.test;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class FilerMatcher {
	
	String act_ssm = "D:\\ecliWS\\ActivitiSSM2\\WebContent\\WEB-INF\\lib";
	String oa_ssm  = "D:\\ecliWS\\OASystem\\WebContent\\WEB-INF\\lib";
	
	public static void main(String[] args) {
		(
			new FilerMatcher()
		).test();
	}
	
	//{ps} 
	public void test() {
		File f1 = new File( act_ssm );
		File f2 = new File( oa_ssm );
		String[] actFile = f1.list();
		String[] oaFile = f2.list();
		
		Set<String> actSet = new HashSet<String>();
		Set<String> oaSet  = new HashSet<String>();
		for ( String str : oaFile ) {
			oaSet.add( str );
		}
		for ( String str : actFile) {
			if( oaSet.contains( str ) ) {
				//print( "OA 中: "+ str + "文件已存在..." );
			}else {
				print( "OA 中: "+ str + " {文件缺少}" );
			}
		}
	}

	private void print(String str) {
		System.out.println( "[OA_SYSTEM] "+ str );
	}
	
}
