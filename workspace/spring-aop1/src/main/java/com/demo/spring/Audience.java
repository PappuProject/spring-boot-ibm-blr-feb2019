package com.demo.spring;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audience {
	@Pointcut("execution(* com.demo.spring.Singer.per*(..))")
	private void pcut() {}

	@Before("pcut()")
	public void switchOffMobile() {
		System.out.println("Audience switching off mobiles..");
	}
	
	@Before("pcut()")
	public void takeSeat() {
		System.out.println("Audience taking seat..");
	}
	
	@AfterReturning("pcut()")
	public void applaud() {
		System.out.println("Good performance Clap!Clap!..");
	}
}
