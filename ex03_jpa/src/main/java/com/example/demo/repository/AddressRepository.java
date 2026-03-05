package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository 
		extends JpaRepository<Address, Integer> {
	
}
