package com.example.demo.hr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.hr.mapper.DepartmentDTO;
import com.example.demo.hr.mapper.EmpMapper;
import com.example.demo.hr.mapper.EmpVO;

@Controller
public class EmpRestController {

	@Autowired EmpMapper empMapper;
	
	@GetMapping("/api/emp")
	@ResponseBody // json변환 => 컨트롤러 + 리스폰스 바디 = 레스트 컨트롤러
	public List<EmpVO> emp() {
		return empMapper.findAll(null);
	}
	
	
	@GetMapping("/api/dept/insert") 
	///api/dept/insert?managerId=100&locationId=1700&departmentName=개발 2팀
	public DepartmentDTO insert(DepartmentDTO dto) {
		//service(mapper)
		empMapper.insertDeptProc(dto);
		return dto;
	}
	
	
}
