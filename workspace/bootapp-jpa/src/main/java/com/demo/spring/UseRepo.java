package com.demo.spring;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpRepository;

@Component
public class UseRepo implements CommandLineRunner {

	@Autowired
	EmpRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		repo.save(new Emp(203, "Scott", "NYC", 85000));
		
		
		Optional<Emp> o=repo.findById(203);
		
		if(o.isPresent()) {
			Emp e=o.get();
			System.out.println(e.getName()+" "+e.getSalary());
		}else {
			System.out.println("Emp Not found..");
		}
		
		repo.getEmpInRange(60000, 80000)
		.stream()
		.forEach(a->System.out.println(a.getName()+" "+a.getSalary()));

	}

}
