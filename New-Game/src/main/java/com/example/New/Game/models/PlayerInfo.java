package com.example.New.Game.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PlayerInfo")
public class PlayerInfo {
	@Id 
	private String email; 
	private String firstName;
	 private String lastName;
	 
	
	public PlayerInfo(String firstName, String lastName, String email) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

	 
}
