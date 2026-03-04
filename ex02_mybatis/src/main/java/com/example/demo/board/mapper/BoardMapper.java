package com.example.demo.board.mapper;

import java.util.List;

public interface BoardMapper {

	public List <BoardVO> findAll();//전체조회
	
	public BoardVO findByBno(int bno); //단건조회
	
	int deleteByBno(Integer bno); //삭제
	
	int insertBoard(BoardVO boardvo); //등록
}
