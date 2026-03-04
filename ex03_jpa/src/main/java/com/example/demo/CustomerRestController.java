package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CustomerRestController {
	
	final CustomerRepository coustomerRepository;
	@GetMapping("/list")
	public List <Customer> list() {
		return coustomerRepository.findAll();
	}
}
