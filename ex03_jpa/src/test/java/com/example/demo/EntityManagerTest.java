package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.Customer;

import jakarta.persistence.EntityManager;

@SpringBootTest
public class EntityManagerTest {
	
	@Autowired EntityManager entityManager;
	
	@Commit
	@Transactional
	@Test
	public void insert() {
		Customer cust = new Customer("hong","011");
		entityManager.persist(cust);
		System.out.println("==="+cust);
	}

	@Commit
	@Transactional
//	@Test
	@DisplayName("수정")
	public void update() {
		Customer cust = entityManager.find(Customer.class, 1);
		cust.setAddr("부산");
		entityManager.merge(cust);
	}
	
	@Commit
	@Transactional
//	@Test
	@DisplayName("삭제")
	public void delete() {
		Customer cust = entityManager.find(Customer.class, 1);
		entityManager.remove(cust);
	}
	
}
