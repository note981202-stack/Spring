package com.example.demo.board.mapper;

import java.util.List;

public interface ReplyMapper {
   //등록 삭제 게시글 번호로 조회
	public List <ReplyVO> findByBno(int bno); // vo파일로 읽어 올거임
	
	public List <ReplyVO> findByRno(int rno); // vo파일로 읽어 올거임
	
	public List<ReplyVO> findAll(); // 전체 조회
	
	int deleteByRno(Integer rno); // 단건 삭제
	
	int insertReply(ReplyVO replyvo); //등록
	
	
}
