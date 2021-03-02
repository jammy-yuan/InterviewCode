package com.gec.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
/**
 * ������
 * @author DDD
 *
 */
public class MyMapperGenerator {
	public void generateMappers() throws Exception {
		List<String> warning = new ArrayList();
		//{1} ��ȡ��ӽ���
		ClassLoader loader = MyMapperGenerator.class.getClassLoader();
		//������ȡ: generatorConfig.xml ������������
		//class/generatorConfig.xml
		InputStream is = loader.getResourceAsStream( "generatorConfig.xml" );
		
		//{1} ���������ļ�������
		ConfigurationParser cp = new ConfigurationParser( warning );
		//{2} ���������ļ�
		Configuration config = cp.parseConfiguration( is );
		//{3} ����Ĭ�ϻص�����
		DefaultShellCallback callback = new DefaultShellCallback( true );
		//{4} ����������
		MyBatisGenerator myGenerator = new MyBatisGenerator( config,
				callback, warning );
		//{5} ִ�д���
		myGenerator.generate( null );
		System.out.println( "Mapper �ļ����ɳɹ�!" );
	}
	
	public static void main(String[] args) throws Exception {
		MyMapperGenerator gen = new MyMapperGenerator();
		gen.generateMappers();
	}

}
