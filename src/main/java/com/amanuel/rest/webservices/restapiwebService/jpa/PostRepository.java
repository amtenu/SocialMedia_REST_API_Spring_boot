package com.amanuel.rest.webservices.restapiwebService.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amanuel.rest.webservices.restapiwebService.user.Post;


public interface PostRepository extends JpaRepository<Post, Integer> {

	
}
