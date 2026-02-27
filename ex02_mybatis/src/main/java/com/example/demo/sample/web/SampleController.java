package com.example.demo.sample.web;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

	@GetMapping("/sample")  //인터넷 리소스 리저브
	public String sample(Model model) {
		model.addAttribute("today", new Date(). toString()); 
		return "/sample"; // viewresolver : templates/sample.html 
		
	}
  };

