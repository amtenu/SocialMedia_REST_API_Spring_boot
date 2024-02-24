package com.amanuel.rest.webservices.restapiwebService.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();

	static {
		users.add(new User(1, "Aman", LocalDate.now().minusYears(30)));
		users.add(new User(2, "Solo", LocalDate.now().minusYears(20)));
		users.add(new User(3, "Danu", LocalDate.now().minusYears(15)));
	}

	public List<User> findAllUsers() {
		return users;
	}

}
