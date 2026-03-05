package com.example.demo.post.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.post.dto.CommentRequestDto;
import com.example.demo.post.repository.CommentRepository;
import com.example.demo.post.repository.Posts;
import com.example.demo.post.repository.PostsRepository;
import com.example.demo.post.service.CommentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl 
		implements CommentService{

	final CommentRepository commentRepository;
	final PostsRepository PostsRepository;
	
	@Override
	public Long insert(CommentRequestDto dto) {
		//post 조회
		Posts post = PostsRepository.findById(dto.getPostsId()).get();
		dto.setPosts(post);
		return commentRepository.save(dto.toEntity()).getId();
	}
}
