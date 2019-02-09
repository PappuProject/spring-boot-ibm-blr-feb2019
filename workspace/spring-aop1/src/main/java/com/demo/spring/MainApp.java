package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		//Performer p = (Performer) ctx.getBean("singer");
		
		Singer p=(Singer)ctx.getBean("singer");
		p.perform();
		
		System.out.println(p.getClass().getName());

	}

}
