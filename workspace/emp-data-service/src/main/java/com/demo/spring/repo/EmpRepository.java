package com.demo.spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer> {
	
	@Query("select o from Emp o where o.salary between ?1 and ?2")
	public List<Emp> getEmpInRange(double minSal,double maxSal);

}
