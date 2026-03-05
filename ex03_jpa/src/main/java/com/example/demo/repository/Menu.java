package com.example.demo.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="tbl_menu")
@Entity
public class Menu {
	
	@Id
	Integer menuNo;
	
	
	@Column(name = "name")
	String MenuName;
	
	
}
