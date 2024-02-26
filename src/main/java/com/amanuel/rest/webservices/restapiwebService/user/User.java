package com.amanuel.rest.webservices.restapiwebService.user;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


@Entity(name="user_details")
public class User {
	
	protected User() {};

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2,message="Name should have @ least 2 chars")
	@JsonProperty("user_name")
	private String name;
	@Past(message="Birthday shouldn't be in the past")
	@JsonProperty("Date_of_Birth")
	private LocalDate birthdate;

	public User(Integer id, String name, LocalDate birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthdate=" + birthdate + "]";
	}

}
