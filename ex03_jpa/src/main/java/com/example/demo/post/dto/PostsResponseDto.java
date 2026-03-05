package com.example.demo.post.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.post.repository.Posts;

import lombok.Getter;
//단건 조회
@Getter
public class PostsResponseDto {
	private Long id;
	private String title;
	private String content;
	private String author;
	private List<CommentResponseDto> comments;
	
	public PostsResponseDto(Posts entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.author = entity.getAuthor();
//		this.comments = entity.getComments().stream().map(null).collect(null);
		List<CommentResponseDto> list = new ArrayList<CommentResponseDto> ();
		entity.getComments().forEach(c-> list.add(new CommentResponseDto(c)));
		this.comments = list;
	}
}
