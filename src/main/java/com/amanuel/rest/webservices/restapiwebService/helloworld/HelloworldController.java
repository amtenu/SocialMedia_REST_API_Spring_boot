package com.amanuel.rest.webservices.restapiwebService.helloworld;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {
	
	@GetMapping(path="/hello-world")
	public String helloworld(){
		return "Hello world";
	}
	
	@GetMapping(path="/hello-world-bean")
	public helloworldbean helloworldBean() {
		
		return new helloworldbean("Hello World");
	}

}
