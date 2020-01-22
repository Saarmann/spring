package com.knits.spring.di.demo;

import com.knits.spring.common.com.kaspar.demo.CustomerService;
import com.knits.spring.common.service.MyService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.knits.spring.common.service.ServiceWithCollections;
import com.knits.spring.common.service.UserService;
import com.knits.spring.common.utils.Mocks;

import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;

@Slf4j
public class DemoXmlConfiguration {

	public static void main(String[] args) {
		
//		demo01_getUserByType();
	//	demo02_getUserById();
//		demo03_getUserByName();
//		demo04_getUserFrom_BeanFactory();
//		demo05_getUserFrom_ApplicationCtxImpls();
//		demo06_collectionInjection();

//		connectionTest();
		myCustomers();
	}
	
	private static void connectionTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("demo-beans.xml");

		DataSource datasource = context.getBean(DataSource.class);

		Connection conn = null;
		try
		{
			conn = datasource.getConnection();
			System.err.println ("Connection opened");
		}
		catch (Exception e)
		{
			System.err.println ("Impossible to connect to Database");
			e.printStackTrace();

		}
		finally
		{
			if (conn != null)
			{
				try
				{
					conn.close ();
					System.out.println ("connection closed");
				}
				catch (Exception e) { /* ignore close errors */ }
			}
		}
		//myService.;

	}


	private static void myCustomers(){
		ApplicationContext context = new ClassPathXmlApplicationContext("demo-beans.xml");
		CustomerService customerService = context.getBean(CustomerService.class);

		customerService.showCustomers();
	}

	private static void demo01_getUserByType(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml"); // connect spring with metadata, this is where spring begins
		UserService userService =  context.getBean(UserService.class);
		userService.save(Mocks.mockUser());
		
	}
	
	private static void demo02_getUserById(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
//		UserService userService = context.getBean("UserServiceBean",UserService.class);
//		userService.save(Mocks.mockUser());

		MyService myService = context.getBean("MyService",MyService.class);
		myService.feature(Mocks.mockUser());
	}

	private static void demo03_getUserByName(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		UserService userService =  context.getBean("UserServiceName",UserService.class);
		userService.save(Mocks.mockUser());
	}
	
	
	private static void demo04_getUserFrom_BeanFactory(){
		Resource res = new ClassPathResource("spring-beans.xml");
        BeanFactory factory = new XmlBeanFactory(res);	
        UserService userService =  factory.getBean(UserService.class);
        userService.save(Mocks.mockUser());
	}

	
	private static void demo05_getUserFrom_ApplicationCtxImpls(){
		ApplicationContext context = new FileSystemXmlApplicationContext("C:/temp/Spring/Spring-100/spring-beans.xml");
		UserService userService =  context.getBean(UserService.class);
		userService.save(Mocks.mockUser());
	}
	
	private static void demo06_collectionInjection(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		ServiceWithCollections service=context.getBean(ServiceWithCollections.class);
		log.info("List: {} ",service.getTechnologySkillsList().toString());
		log.info("Set: {} ",service.getTechnologySkillsSet().toString());
		log.info("Map: {} ",service.getTechnologySkillsMap().toString());
	}
}
