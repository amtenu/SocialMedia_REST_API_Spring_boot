package com.amanuel.rest.webservices.restapiwebService.admins;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class AdminsController {
	
	@GetMapping("/admins")
	public MappingJacksonValue getAdmins() {
		
		admins admin = new admins(1,"Aman","1234");
		
		MappingJacksonValue mappingJacksonValue =new MappingJacksonValue(admin);
		
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("id","password");
		FilterProvider filters=new SimpleFilterProvider().addFilter("adminsFilter", filter);
		
		mappingJacksonValue.setFilters(filters);
		
		return mappingJacksonValue;
		
	}
	
	@GetMapping("/admins_list")
	public MappingJacksonValue getAdminsAsList() {
		
		List<admins> adminsList = Arrays.asList(new admins(1,"Aman","1234"),new admins(1,"Solo","1234"));
		
		MappingJacksonValue mappingJacksonValue =new MappingJacksonValue(adminsList);
		
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("id","name");
		FilterProvider filters=new SimpleFilterProvider().addFilter("adminsFilter", filter);
		
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
		
	}

}
