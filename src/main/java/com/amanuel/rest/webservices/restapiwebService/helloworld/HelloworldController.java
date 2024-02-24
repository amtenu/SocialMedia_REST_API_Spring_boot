package com.amanuel.rest.webservices.restapiwebService.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {

	@GetMapping(path = "/hello-world")
	public String helloworld() {
		return "Hello world";
	}

	@GetMapping(path = "/hello-world-bean")
	public helloworldbean helloworldBean() {

		return new helloworldbean("Hello World");
	}

	@GetMapping(path = "/hello-world/path-variable/{name}")
	public helloworldbean helloworldPathVariable(@PathVariable String name) {

		return new helloworldbean(String.format("Hello ,%s", name));
	}

}
