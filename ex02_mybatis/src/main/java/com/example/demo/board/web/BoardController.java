package com.example.demo.board.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.board.mapper.BoardVO;
import com.example.demo.board.service.BoardService;
import com.example.demo.board.service.impl.BoardServiceImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/board")
@Controller
public class BoardController {
	//인젝션
	private final BoardService boardService;
	
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
	
	//등록 페이지 이동
	@GetMapping("/register")
	public String insertBoard() {
	    return "board/register";   // templates/board/register.html
	}
	
	//등록 처리
	@PostMapping("/register")
	public String insert(BoardVO boardVO) {
	    boardService.insertBoard(boardVO);
	    return "redirect:/board/list";   // 등록 후 목록으로 이동
	}
	
	
	
	//삭제 처리
	@DeleteMapping("/{bno}")
	public Integer delete(@PathVariable Integer bno) {
		boardService.deleteByBno(bno);
		return bno;
	}
	
	
}
