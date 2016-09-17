package com.crum;

import org.springframework.data.annotation.Id;

public class User 
{
	@Id
	private String id;
	private String password;
	private String username;

	public User(String username, String password) {
		this.password = password;
		this.username = username;
	}
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
    return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}