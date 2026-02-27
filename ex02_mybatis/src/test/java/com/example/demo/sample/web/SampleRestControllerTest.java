package com.example.demo.sample.web;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(controllers = SampleRestController.class)
public class SampleRestControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@DisplayName("rest 서버 테스트: get")
	public void get() throws Exception { 
		mockMvc.perform(MockMvcRequestBuilders.get("/ex01"))
			   .andExpect(status().isOk())
			   .andDo(print());
		
	}
}
