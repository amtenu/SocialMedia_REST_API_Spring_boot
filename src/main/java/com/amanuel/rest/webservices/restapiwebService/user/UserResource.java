package com.amanuel.rest.webservices.restapiwebService.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	private UserDaoService service;

	public UserResource(UserDaoService service) {
		this.service = service;
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {

		return service.findAllUsers();

	}

	@GetMapping("/users/{id}")
	public User getFindUserByID(@PathVariable int id) {

		return service.findUserById(id);

	}

}
