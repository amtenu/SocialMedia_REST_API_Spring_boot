package com.amanuel.rest.webservices.restapiwebService.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amanuel.rest.webservices.restapiwebService.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	
}
