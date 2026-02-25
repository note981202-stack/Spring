package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.demo02.Restaurant;

@SpringBootTest
public class DiTest02 {
	
	@Autowired Restaurant restaurant;
	
	@Test
	public void test() {
		restaurant.getChef().toString();
	}

}
