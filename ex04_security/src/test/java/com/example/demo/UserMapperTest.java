package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.RoleDTO;
import com.example.demo.service.UserDTO;
import com.example.demo.service.impl.UserMapper;

@SpringBootTest
public class UserMapperTest {
	
	@Autowired
	UserMapper userMapper;
	
	@Test // - user 단건 조회 
	public void getUserTest() {
		
		//given
		String id = "user";
		
		//when
		UserDTO user = userMapper.getUser(id);  
		
		//then
		System.out.println(user);
	}
	

//	@Test
	public void getRoleTest() {
		
		//given
		String id = "1";
		
		//when
		List<RoleDTO> rolelist = userMapper.getRole(id);
		
		//then
		rolelist.stream().forEach(role -> System.out.println(role));
		
	} //roletest end
	
} //class end


