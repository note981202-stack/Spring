package com.example.demo.post.dto;

import com.example.demo.post.repository.Comment;

import lombok.Getter;

@Getter
public class CommentResponseDto {
	Long id;
	String comment;
	String name;
	
	public CommentResponseDto(Comment comment) {
		this.id = comment.getId();
		this.comment = comment.getComments();
//		this.name = comment.getCustomer().getName();
	}
}
