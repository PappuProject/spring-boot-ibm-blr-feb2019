package com.demo.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.demo.spring.entity.Emp;

@Component
public class GetEmpData implements CommandLineRunner {

	@Autowired
	JdbcTemplate jt;

	@Override
	public void run(String... args) throws Exception {

		List<Emp> empList = jt.query((con) -> {
			PreparedStatement pst = con.prepareStatement("select * from emp");
			return pst;

		}, (rs, rowNum) -> {

			return new Emp(rs.getInt("EMPNO"), rs.getString("NAME"), rs.getString("ADDRESS"), rs.getDouble("SALARY"));

		});

		for (Emp e : empList) {
			System.out.println(e.getName() + " " + e.getSalary());
		}

		empList.stream().forEach(e -> System.out.println(e.getName()));

		// Get Single Emp

		Emp e = jt.queryForObject("select * from emp where empno=201",
		(rs, rowNum) -> {

			return new Emp(rs.getInt("EMPNO"), rs.getString("NAME"), rs.getString("ADDRESS"), rs.getDouble("SALARY"));

		});
		
		System.out.println(e.getName()+" "+e.getSalary());
	}
}
