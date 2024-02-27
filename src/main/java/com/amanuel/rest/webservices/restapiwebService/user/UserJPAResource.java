package com.amanuel.rest.webservices.restapiwebService.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.amanuel.rest.webservices.restapiwebService.jpa.PostRepository;
import com.amanuel.rest.webservices.restapiwebService.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJPAResource {

	private UserRepository repository;

	private PostRepository postRepository;

	public UserJPAResource(UserRepository repository, PostRepository postRepository) {

		this.repository = repository;
		this.postRepository = postRepository;
	}

	@GetMapping("/jpa/users")
	public List<User> getAllUsers() {

		return repository.findAll();

	}

	// Creating data and link for response

	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> getFindUserByID(@PathVariable int id) {

		Optional<User> user = repository.findById(id);

		if (user.isEmpty())
			throw new UserNotFoundException("id is :" + id);

		EntityModel<User> entityModel = EntityModel.of(user.get());

		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
		entityModel.add(link.withRel("A user"));
		return entityModel;

	}

	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {

		User savedUser = repository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@DeleteMapping("/jpa/users/{id}")
	public void deleteUserByID(@PathVariable int id) {

		repository.deleteById(id);

	}

	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> findPostOfUserByID(@PathVariable int id) {

		Optional<User> user = repository.findById(id);

		if (user.isEmpty())
			throw new UserNotFoundException("id is :" + id);

		return user.get().getPost();

	}

	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> addPostOfUserByID(@PathVariable int id, @Valid @RequestBody Post post) {

		Optional<User> user = repository.findById(id);

		if (user.isEmpty())
			throw new UserNotFoundException("id is :" + id);

		post.setUser(user.get());

		Post savedPost = postRepository.save(post);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

}
