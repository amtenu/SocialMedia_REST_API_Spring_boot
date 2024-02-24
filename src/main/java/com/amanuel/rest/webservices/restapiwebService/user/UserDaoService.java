package com.amanuel.rest.webservices.restapiwebService.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	private static int userCount=0;

	static {
		users.add(new User(++userCount, "Aman", LocalDate.now().minusYears(30)));
		users.add(new User(++userCount, "Solo", LocalDate.now().minusYears(20)));
		users.add(new User(++userCount, "Danu", LocalDate.now().minusYears(15)));
	}

	public List<User> findAllUsers() {
		return users;
	}

	public User findUserById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().get();
	}

	
	public User saveUser(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
		
	}
}
