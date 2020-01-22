package com.kaspar.spring.di.demo;

import com.kaspar.spring.di.config.CustomAppConfig;
import com.knits.spring.common.com.kaspar.demo.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@Slf4j
public class DemoCustomJavaConfiguration {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(CustomAppConfig.class);
		context.getBean(CustomerService.class).showCustomers();
	}


}
