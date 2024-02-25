package com.amanuel.rest.webservices.restapiwebService.versioning;

import java.time.LocalDate;

public class StudentV2 {
	
	private String name;
	private LocalDate age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getAge() {
		return age;
	}
	public void setAge(LocalDate age) {
		this.age = age;
	}
	public StudentV2(String name, LocalDate age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "StudentV2 [name=" + name + ", age=" + age + "]";
	}
	
	

}
