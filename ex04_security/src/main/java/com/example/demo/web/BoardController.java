package com.example.demo.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserDTO;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BoardController {

		@GetMapping("/board") //내가작성한 게시글
		public String test(@AuthenticationPrincipal UserDTO principal,
							HttpSession session) {
			//로그인된 사용자 ID
			
			  // 시큐리티 컨텍스트 객체를 얻습니다.
//			SecurityContext context = SecurityContextHolder.getContext();
//
//			// 인증 객체를 얻습니다.
//			Authentication authentication = context.getAuthentication();
//
//			// 로그인한 사용자정보를 가진 객체를 얻습니다.
//			UserDTO principal = (UserDTO)authentication.getPrincipal();
			
			log.info("userid:" + principal.getLoginId());
			log.info("deptname:" + session.getAttribute("deptName"));
			return "board";
		}
}
