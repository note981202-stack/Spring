package com.example.demo.config.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.demo.service.UserDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		
		//로그인된 사용자 이름
		log.info("login username: " + authentication.getName());
		log.info("login username: " + 
					((UserDTO)authentication.getPrincipal()).getDeptName());
		
		//session
		request.getSession().setAttribute("deptName", ((UserDTO)authentication.getPrincipal()).getDeptName());
		
		//username, role
				List<String> roleNames = new ArrayList<>();		
				authentication.getAuthorities().forEach( authority -> {
					roleNames.add( authority.getAuthority());
				}  );		
				System.out.println("roleName:" + roleNames);
				
				if ( roleNames.contains("ROLE_ADMIN") ) {
					response.sendRedirect("/admin");
					return;
				} else if ( roleNames.contains("ROLE_USER") ) {
					response.sendRedirect("/hello");
					return;
				} 
				response.sendRedirect("/");
		
		//role 에 맞는 시작페이지
//		authentication.getAuthorities().
		
	}
	  
	}