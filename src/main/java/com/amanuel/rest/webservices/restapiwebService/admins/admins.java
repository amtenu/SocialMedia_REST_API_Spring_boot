package com.amanuel.rest.webservices.restapiwebService.admins;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


//@JsonIgnoreProperties({"password","SecretKey","id"})
@JsonFilter("adminsFilter")
public class admins {
	
	private Integer id;
	
	private String name;
	
	//@JsonIgnore
	private String password;
	
	private static String SecretKey="24242";

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
	
	

	public static String getSecretKey() {
		return SecretKey;
	}


	public admins(Integer id, String name, String password,String SecretKey) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		admins.SecretKey=SecretKey;
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
