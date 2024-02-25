package com.amanuel.rest.webservices.restapiwebService.versioning;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioninigStudentController {
	
	@GetMapping("/v1/student")
	public StudentV1 getFirstVersionOfStudent() {
		return new StudentV1("Amanuel");
	}
	
	@GetMapping("/v2/student")
	public StudentV2 getSecondVersionOfStudent() {
		return new StudentV2("Amanuel",LocalDate.of(2020, 2, 2));
	}
	
	@GetMapping(path="/student",params="version=1")
	public StudentV1 getFirstVersionOfStudentUsingRequestParameter() {
		return new StudentV1("Amanuel");
	}
	
	@GetMapping(path="/student",params="version=2")
	public StudentV2 getSecondVersionOfStudentUsingRequestParameter() {
		return new StudentV2("Amanuel",LocalDate.of(2020, 2, 2));
	}

	
	@GetMapping(path="/student/header",headers="X-API-VERSION=1")
	public StudentV1 getFirstVersionOfStudentUsingRequestHeaders() {
		return new StudentV1("Amanuel");
	}
	
	
	@GetMapping(path="/student/header",headers="X-API-VERSION=2")
	public StudentV2 getSecondVersionOfStudentUsingRequestHeader() {
		return new StudentV2("Amanuel",LocalDate.of(2020, 2, 2));
	}
	
	
}
