package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.service.UserDTO;
import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService, UserDetailsService{
	
	
	private final UserMapper userMapper;
	@Override
	public UserDTO getUser(String loginId) {
		return userMapper.getUser(loginId);
		
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDTO user = userMapper.getUser(username);  //DB에서 username으로 조회
		if(user == null) {
			throw new UsernameNotFoundException("not found"); // 사용자가 없으면 로그인 실패
		}
		return user; //new User(user.getLoginId(), user.getPassword(), auth);
	}
	
}
