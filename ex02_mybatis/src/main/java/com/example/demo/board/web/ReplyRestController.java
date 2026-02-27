package com.example.demo.board.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.mapper.ReplyVO;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class ReplyRestController {

	private final ReplyMapper replyMapper;
	
	
	
	//해당 게시글의 댓글 조회
	@GetMapping("/board/{bno}/reply")//bno에 해당하는 댓글들
	public List<ReplyVO> getreply(@PathVariable Integer bno) {
		List <ReplyVO> list = replyMapper.findByBno(bno);
		return list;
	};
	
	
	
	//댓글 등록
	@PostMapping("/board/{bno}/reply")
	public List<ReplyVO> insert(@PathVariable Integer bno,
								@RequestBody ReplyVO vo) {
		
		vo.setBno(bno);
		replyMapper.insertReply(vo);
		
		return replyMapper.findByRno(vo.getRno());
	}
	
	
	//댓글 삭제
	@DeleteMapping("/reply/{rno}")
	public Integer delete(@PathVariable Integer rno) {
		replyMapper.deleteByRno(rno);
		return rno;
	}
	
	
}
