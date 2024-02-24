package com.amanuel.rest.webservices.restapiwebService.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {

		User savedUser = service.saveUser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();

	}

}
