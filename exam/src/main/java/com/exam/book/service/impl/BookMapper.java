package com.exam.book.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.exam.book.service.BookVO;
import com.exam.book.service.RentVO;

@Mapper
public interface BookMapper { //xml파일 호출 목적

	//도서 목록 조회
	public List<BookVO> findAll(String order);
	
	//도서 등록
	int insert(BookVO vo);
	
	//대출 목록 조회
	public List<RentVO> findRentAll(String order);
}
