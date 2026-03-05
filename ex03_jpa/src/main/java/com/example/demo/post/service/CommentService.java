package com.example.demo.post.service;

import com.example.demo.post.dto.CommentRequestDto;

public interface CommentService {
	Long insert(CommentRequestDto dto);
}
