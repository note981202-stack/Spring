package com.exam.book.service;

import java.util.List;

public interface BookService {
	
	
	//도서 목록 조회
	public List<BookVO> findAll();
	
	//등록
	int insert(BookVO vo);
	
	//대출 목록 조회 - 추후에 수정
	public List<RentVO> findRentAll();
	
}
