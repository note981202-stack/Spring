package com.example.demo.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.service.RoleDTO;
import com.example.demo.service.UserDTO;

@Mapper
public interface UserMapper {
	//user 단건 조회
	UserDTO getUser(String loginId);
	
	//권한조회 - 사용자에게 여러 권한이 부여될 수 있기 때문에 list로 받게 됨
	 List<RoleDTO> getRole(String id);
}
