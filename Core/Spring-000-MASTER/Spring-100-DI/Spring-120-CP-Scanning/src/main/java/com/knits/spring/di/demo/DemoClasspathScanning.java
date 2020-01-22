package com.knits.spring.di.demo;

import com.knits.spring.common.com.kaspar.demo.CustomerService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.knits.spring.common.service.UserService;
import com.knits.spring.common.utils.Mocks;


@Slf4j
public class DemoClasspathScanning {

	public static void main(String[] args) {
//		demo01_saveUser();
		demoShowCustomers();
	}

	private static void demo01_saveUser(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		context.getBean(UserService.class).save(Mocks.mockUser());
	}

	private static void demoShowCustomers(){
		ApplicationContext context = new ClassPathXmlApplicationContext("mydemo-beans.xml");
		context.getBean(CustomerService.class).showCustomers();

	}

}
