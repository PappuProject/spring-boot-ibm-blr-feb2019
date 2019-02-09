package com.demo.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

@Service
public class HrService {
	
	@Autowired
	@Qualifier("empDaoImpl2")
	private EmpDao dao;

	public String registerEmp(int id, String name,String city,double salary) {
		
		String resp=dao.saveEmp(new Emp(id, name, city, salary));
		return resp;
	}
}
