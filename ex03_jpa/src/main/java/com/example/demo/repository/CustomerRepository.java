package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository 
		extends JpaRepository< Customer, Long>{
	
	List<Customer> findByName(String name);
	List<Customer> findByOrderByNameDesc();
	
	@Query("select c from Customer c where phone = ?1") //JPQL
	Customer findByPhone(String phone);
	
	@Query(value = "select id, name from customer order By name" ,nativeQuery = true) //ANSI sql
	List<Map<String, Object>> findAllByPhone();
}
