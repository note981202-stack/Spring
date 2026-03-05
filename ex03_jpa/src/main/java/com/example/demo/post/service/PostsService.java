package com.example.demo.post.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.post.dto.PostsListResponseDto;
import com.example.demo.post.dto.PostsResponseDto;
import com.example.demo.post.dto.PostsSaveRequestDto;
import com.example.demo.post.dto.PostsUpdateRequestDto;

public interface PostsService {

	public Long save(PostsSaveRequestDto requestDto);
	public Long update(Long id,PostsUpdateRequestDto requestDto);
	public Long delete(Long id);	
	public PostsResponseDto findById(Long id);
	public Page<PostsListResponseDto> findAllDesc(int pageNo) ;
	
	//comment service - 댓글등록
}
