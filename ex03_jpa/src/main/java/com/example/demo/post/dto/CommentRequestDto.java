package com.example.demo.post.dto;

import com.example.demo.post.repository.Comment;
import com.example.demo.post.repository.Posts;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentRequestDto {
	private String comment;
	private Long postsId;
	private Long customerId;
	private Posts posts;
	
	public Comment toEntity() {
		Comment comments = Comment
				.builder()
				.comment(comment)
				.posts(posts)
				.build();
		return comments;
	}
}
