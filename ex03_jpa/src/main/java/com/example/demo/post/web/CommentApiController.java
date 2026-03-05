package com.example.demo.post.web;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.post.dto.CommentRequestDto;
import com.example.demo.post.service.CommentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CommentApiController {

	private final CommentService commentService;
	
	//등록
	@PostMapping("/api/v1/comment")
	public Long save(@RequestBody CommentRequestDto requestDto) {
		return commentService.insert(requestDto);
	}
	
}
