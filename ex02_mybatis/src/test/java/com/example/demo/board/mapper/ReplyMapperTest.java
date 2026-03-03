package com.example.demo.board.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class ReplyMapperTest {
	
	@Autowired ReplyMapper replyMapper;
	

////	@Test //테스트 완료
//	@DisplayName("RNO 번호 목록 조회")
//	public void findByBno() {
//		//given
//		Integer bno = 1;
//		
//		//when
////		ReplyVO vo = replyMapper.findByBno(bno); // ReplyVO가 데이터 타입이야
//		
//		
//		//then -결과 출력
//		System.out.println(vo);
//	}
	
//	@Test //삭제 완료
	@DisplayName("BNO로 삭제")
	public void deleteByRno() {
		//given
		Integer rno = 2;
		
		//when
		int vo = replyMapper.deleteByRno(rno);
		
		//then
		System.out.println(vo);
	}
	
	@Test
	@DisplayName("등록")
	public void insertReply() {

	    // given
		Integer bno = 2;
		String reply = "reply2";
		String replyer = "replyer2";
		
		ReplyVO vo = ReplyVO.builder()
	            .bno(bno)
	            .reply(reply)
	            .replyer(replyer)
	            .build();
		
	    // when
	    int result = replyMapper.insertReply(vo);

	    // then
	    System.out.println(result);
	}
	
}
