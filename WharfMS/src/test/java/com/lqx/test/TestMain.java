package com.lqx.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.lqx.mapper.ContainerMapper;
import com.lqx.mapper.UserMapper;
import com.lqx.pojo.Container;
import com.lqx.pojo.LandRepository;
import org.apache.ibatis.session.SqlSession;

import com.lqx.pojo.User;
import com.lqx.test.BaseTest;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain extends BaseTest {
	public static void main(String[] args)
			throws IOException {
		//saveContainerTest();
		testRepository();
	}

	public static void testRepository(){
		ApplicationContext tx =new ClassPathXmlApplicationContext("spring-mybatis.xml");
		ContainerMapper mapper =tx.getBean(ContainerMapper.class);
		LandRepository landRepository = mapper.selectByRepositoryKey(1);
		System.out.println("获取的仓库："+landRepository);
		landRepository.setCount(70);
		mapper.updateByRepositoryKey(landRepository);
	}

	public static void saveContainerTest(){
		ApplicationContext tx =new ClassPathXmlApplicationContext("spring-mybatis.xml");
		ContainerMapper mapper =tx.getBean(ContainerMapper.class);
//		Container container = mapper.selectByPrimaryKey(1);
//		System.out.println("{TEST}container "+container);
		Container container = new Container();
		container.setShipType("大型货轮");
		container.setType("大型货柜");
		container.setRepository(7);
		container.setCapacity(80);
		mapper.insertSelective(container);
		System.out.println(container);
	}

	private Container getContainer() {
		SqlSession session = factory.openSession();
		ContainerMapper mapper = session.getMapper(
				ContainerMapper.class );
		Container container = mapper.selectByPrimaryKey(1);
//		List<User> list = mapper.getCourceList();
//		printLine();
//		print( "没分页版本查询:" );
//		for (User user : list) {
//			print( user );
//		}
//		printLine();
		return container;
	}
	
	private void getCourceHasPage() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(
				UserMapper.class );
		
		Scanner sc = new Scanner(System.in);
		int pageSize = 5;
		int pageNum = 1;
		String _page;
		int a = 1;
		while( a==1 ){
			print("请输入页码: ");
			_page = sc.nextLine();
			pageNum = Integer.valueOf(_page);
			
			//调用格式: PageHelper.startPage( 第几页, 页大小 );
			//PageHelper.startPage( pageNum, pageSize );
			
			//{ps} 加一个 true 表示, 你帮获取总记录数.
			Page page = PageHelper.startPage( 
							pageNum, pageSize, true );
			//{ps} 总记录数
			int total = (int)page.getTotal();
			print("[A] 在这里能否获得总记录数 :" + total);
			
			//{2}记住是在这个方法调用之前加上分页指令
			//List<Cource> list = mapper.getCourceList();
			
			//{3} 总记录数
			total = (int)page.getTotal();
			print("[B] 在这里能否获得总记录数 :" + total);
			
//			printLine();
//			for (Cource cr : list) {
//				print( cr );
//			}
//			printLine();
		}
	}
	
}





