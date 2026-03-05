package com.example.demo.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Getter
@Entity
public class Member {
	
	@Id
	private Integer id;
	private String username;
	
//	연관관계	매핑
	@ManyToOne
	@JoinColumn(name = "teamId")
	private	Team team;
	
	public Member() {}
	
	public Member(String username, Team team) {
		super();
		this.username = username;
		this.team = team;
	}				
	
	
	
}	
