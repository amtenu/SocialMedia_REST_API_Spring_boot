package com.amanuel.rest.webservices.restapiwebService.helloworld;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {
	
	@GetMapping(path="/hello-world")
	public String helloworld(){
		return "Hello world";
	}

}
