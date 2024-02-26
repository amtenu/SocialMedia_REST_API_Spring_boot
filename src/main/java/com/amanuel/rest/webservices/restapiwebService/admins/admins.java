package com.amanuel.rest.webservices.restapiwebService.admins;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class admins {
	
	private Integer id;
	
	private String name;
	
	@JsonIgnore
	private String password;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
	
	

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public admins(Integer id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	@Override
	public String toString() {
		return "admins [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	
	

}
