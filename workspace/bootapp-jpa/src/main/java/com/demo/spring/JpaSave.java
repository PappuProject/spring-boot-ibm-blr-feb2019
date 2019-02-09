package com.demo.spring;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.spring.entity.Emp;

//@Component
//@Transactional
public class JpaSave implements CommandLineRunner {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void run(String... args) throws Exception {
		
		//em.persist(new Emp(202, "James", "London", 45000));
		
		//System.out.println("Emp saved..");
		
		Emp e= em.find(Emp.class, 201);
		
		if(e!=null) {
			e.setSalary(89000);
			em.merge(e);
		}else {
			System.out.println("Emp Not Found..");
		}
		
		
		Query query=em.createQuery("select e from Emp e");
		
		List<Emp> emps=query.getResultList();
		
		emps.stream().forEach(a->System.out.println(a.getName()+" "+a.getSalary()));
		
		
		
		

	}

}
