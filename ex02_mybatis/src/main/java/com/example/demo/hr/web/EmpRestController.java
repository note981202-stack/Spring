package com.example.demo.hr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.hr.mapper.DepartmentDTO;
import com.example.demo.hr.mapper.EmpMapper;

@RestController
public class EmpRestController {

	@Autowired EmpMapper empMapper;
	
	@GetMapping("/api/dept/insert") 
	///api/dept/insert?managerId=100&locationId=1700&departmentName=개발 2팀
	public DepartmentDTO insert(DepartmentDTO dto) {
		//service(mapper)
		empMapper.insertDeptProc(dto);
		return dto;
	}
	
	
}
