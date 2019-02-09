package com.demo.spring.dao;

import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository
public class EmpDaoImpl2 implements EmpDao{

	@Override
	public String saveEmp(Emp e) {
		
		return "Emp Saved";
	}

}
