package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class CustomerRepositoryTest {
	@Autowired CustomerRepository customerRepository;

	@Transactional
	@Commit
	@Test
	@DisplayName("고객정보등록")
	public void save() {
		Customer cust = customerRepository.save(new Customer("홍길동", "010-1111-1111"));
		
		customerRepository.findAll().forEach(c ->  System.out.println(c.getName()));
	}
}
