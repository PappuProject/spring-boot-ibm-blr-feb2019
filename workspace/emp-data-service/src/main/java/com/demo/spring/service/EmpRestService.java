package com.demo.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpRepository;

@RestController

public class EmpRestService {

	@Autowired
	private EmpRepository repo;

	/*
	 * @RequestMapping( path="/emp/find/{id}" ,method=RequestMethod.GET,
	 * produces=MediaType.APPLICATION_JSON_VALUE)
	 */
	@GetMapping(path = "/emp/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity findEmpById(@PathVariable("id") int id) {
		Optional<Emp> o = repo.findById(id);
		if (o.isPresent()) {
			return ResponseEntity.ok(o.get());
		} else {
			return ResponseEntity.ok("{\"status\":\"Emp Not Found\"}");
		}

	}

	@PostMapping(path = "/emp/save", produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveEmp(@RequestBody Emp e) {

		if (repo.existsById(e.getEmpId())) {
			return ResponseEntity.ok("The Emp already Exists");
		} else {
			repo.save(e);
			return ResponseEntity.ok("The Emp saved successfully");
		}

	}

	@GetMapping(path = "/emp/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getEmpList() {
		if (repo.count() == 0) {
			return ResponseEntity.ok("{\"status\":\"No EmpFound\"}");
		} else {
			return ResponseEntity.ok(repo.findAll());
		}
	}

}
