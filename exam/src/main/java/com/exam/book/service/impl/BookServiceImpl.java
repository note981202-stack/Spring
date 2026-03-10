package com.exam.book.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.book.service.BookService;
import com.exam.book.service.BookVO;
import com.exam.book.service.RentVO;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
	
	private final BookMapper bookMapper;
	
	//도서 전체 조회
	@Override
	public List<BookVO> findAll() {
		return bookMapper.findAll(null);
	}
	
	//도서 등록
	@Override
	public int insert(BookVO vo) {
		return bookMapper.insert(vo);
	}
	
	//대출 목록 조회
	@Override
	public List<RentVO> findRentAll() {
		return bookMapper.findRentAll(null);
	}
}
