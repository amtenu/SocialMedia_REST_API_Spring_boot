package com.amanuel.rest.webservices.restapiwebService.user;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

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

	// Creating data and link for response

	@GetMapping("/users/{id}")
	public EntityModel<User> getFindUserByID(@PathVariable int id) {

		User user = service.findUserById(id);

		if (user == null)
			throw new UserNotFoundException("id is :" + id);

		EntityModel<User> entityModel = EntityModel.of(user);

		WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).getAllUsers());
		entityModel.add(link.withRel("A user"));
		return entityModel;

	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {

		User savedUser = service.saveUser(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@DeleteMapping("/users/{id}")
	public void deleteUserByID(@PathVariable int id) {

		service.deleteById(id);

	}

}
