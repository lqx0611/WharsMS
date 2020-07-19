package com.lqx.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lqx.pojo.User;

public class BaseTest {

	String clsName = this.getClass().getSimpleName();
	

	
	protected void printLine() {
		System.out.println("+----------------------------"+
				"----------------------------+");
	}
	protected void print(Object obj) {
		System.out.println("{"+ clsName +"} "+ obj);
	}
	
	protected SqlSessionFactory factory;
	public void initFactory() throws IOException{
		InputStream is = Resources.getResourceAsStream(
				"spring-mybatis.xml" );
		factory = new SqlSessionFactoryBuilder()
						.build( is );
	}
	public void initFactory( String path ) throws IOException{
		InputStream is = Resources.getResourceAsStream(
				path );
		factory = new SqlSessionFactoryBuilder()
						.build( is );
	}

}
