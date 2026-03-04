package com.example.demo.board.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.board.mapper.BoardVO;
import com.example.demo.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/board")
@Controller
public class BoardController {

	private final BoardService boardService; //인젝션
	
	//전체조회
	@GetMapping("/list")
	public String findAll(Model model) {
		List <BoardVO> list = boardService.findAll();
		model.addAttribute("list", list);
		return "board/list";
	}
	
	//단건 상세 조회
	@GetMapping("info/{bno}")
	public String findByBno(@PathVariable int bno, Model model) {
	    BoardVO board = boardService.findByBno(bno);
	    model.addAttribute("board", board);
	    return "board/info";
	}
	
	//등록 처리
	/*
	 * @PostMapping("/board/{bno}/board") public
	 */
	
	
	
	//삭제 처리
	
	
	
}
