package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HrService {

	@Autowired
	RestTemplate rt;

	public ResponseEntity getEmpDetails(int id) {
		HttpHeaders headers = new HttpHeaders();

		headers.set("Accept", "application/json");

		HttpEntity req = new HttpEntity<>(headers);

		ResponseEntity resp = rt.exchange("http://emp-service/emp/find/" + id, 
				HttpMethod.GET, req, String.class);
		return resp;

	}

	public ResponseEntity getEmpList() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");

		HttpEntity req = new HttpEntity<>(headers);

		ResponseEntity resp = rt.exchange("http://emp-service/emp/list", 
				HttpMethod.GET, req, String.class);
		return resp;
	}

}
