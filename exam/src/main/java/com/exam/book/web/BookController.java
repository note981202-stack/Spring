package com.exam.book.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.exam.book.service.BookService;
import com.exam.book.service.BookVO;
import com.exam.book.service.RentVO;
import com.exam.book.service.impl.BookMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BookController {

	//##service파일 인젝션 해야함
	final BookService bookService;
	final BookMapper bookMapper;
	
	@Value("${file.upload}")
	String path;
	
	//시작화면 구성
	
	//도서 목록 조회(전체조회)
	@GetMapping("book/list")
	public void list(Model model) {
		List<BookVO> list = bookService.findAll();
		model.addAttribute("list",list);
	}

	//홈화면
	@GetMapping("book/home")
	public void home(){};
	
	//등록
	//등록페이지로 이동
	@GetMapping("book/register")
	public void register(Model model) {
	    model.addAttribute("book", new BookVO());
	}
	
	//등록 처리
	@PostMapping("book/register")
	public String insert(BookVO bookVO) {
		bookService.insert(bookVO);
		return "redirect:/book/list"; // 등록하고 목록으로
	}
	
	//도서 대여 현황 조회
	@GetMapping("book/rentlist") 
		public void list2(Model model) {
			List<RentVO> rentlist = bookService.findRentAll();
			model.addAttribute("list", rentlist);
		}
	
	
}
