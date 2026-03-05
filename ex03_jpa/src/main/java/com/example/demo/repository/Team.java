package com.example.demo.repository;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;

@Getter
@Entity
public class Team {

	@Id
	private Integer id;
	private String teamname;
	
	public Team() {}
	
	public Team(String teamname) {
		this.teamname = teamname;
	}
}
