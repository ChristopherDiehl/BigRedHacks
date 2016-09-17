package com.crum;

import org.springframework.data.annotation.Id;

public class User 
{
	@Id
	private String id;
	public User() {

	}
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}

}