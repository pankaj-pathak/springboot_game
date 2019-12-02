package com.example.New.Game.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "ScoreBoardInfo")
public class ScoreBoardInfo {
	@Id
	private String email; 
	private int score;
	
	public ScoreBoardInfo(String email, int score) {
		super();
		this.email = email;
		this.score = score;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

}
