package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Singer /*implements Performer */{

	//@Autowired
	//private Audience aud;
	
	//@Override
	public void perform() {
		//aud.takeSeat();
		//aud.switchOffMobile();
		System.out.println("singer is singing...");
		//aud.applaud();

	}

}
