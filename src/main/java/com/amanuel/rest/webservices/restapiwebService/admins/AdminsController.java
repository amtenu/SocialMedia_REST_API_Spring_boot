package com.amanuel.rest.webservices.restapiwebService.admins;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminsController {
	
	@GetMapping("/admins")
	public admins getAdmins() {
		return new admins(1,"Aman","1234");
		
	}
	
	@GetMapping("/admins_list")
	public List<admins> getAdminsAsList() {
		return Arrays.asList(new admins(1,"Aman","1234"),new admins(1,"Solo","1234"));
		
	}

}
