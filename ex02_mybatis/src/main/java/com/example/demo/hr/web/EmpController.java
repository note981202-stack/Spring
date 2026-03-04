package com.example.demo.hr.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.board.web.ReplyRestController;
import com.example.demo.hr.mapper.DeptMapper;
import com.example.demo.hr.mapper.EmpRequestVO;
import com.example.demo.hr.mapper.JobMapper;
import com.example.demo.hr.service.EmpService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class EmpController {

    private final ReplyRestController replyRestController;

	final EmpService empService;
	final DeptMapper deptMapper; //인젝션
	final JobMapper jobMapper;
	
	@Value("${file.upload}")
	String path;
	
	//전체 조회
	@GetMapping("emp/list")
	public void list(Model model) { //주소가 동일하면 리턴값 없이 void해도 됨
		System.out.println("path:" + path);
		//조회결과
		model.addAttribute("list", empService.findAll(null));
	}
	
	//상세 보기
	@GetMapping("emp/info/{id}")
	public String info(Model model, @PathVariable Integer id) { //주소가 동일하면 리턴값 없이 void해도 됨
		//조회결과
		model.addAttribute("emp", empService.findById(id));
		return "emp/info";
	}
	
	//등록 페이지로 이동
	@GetMapping("emp/register")
	public void register(Model model, EmpRequestVO vo) { //주소가 동일하면 리턴값 없이 void해도 됨
		model.addAttribute("emp", vo);
		//부서 목록
		model.addAttribute("deptList", deptMapper.findAll());
		//직업 명 목록
		model.addAttribute("jobList", jobMapper.findAll());
	}
	
	
	//등록 처리
	@PostMapping("emp/register")
	public String registerProc(@Valid @ModelAttribute("emp") EmpRequestVO vo,
								BindingResult bindingResult, Model model ) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("deptList", deptMapper.findAll());
			model.addAttribute("jobList", jobMapper.findAll());
			System.out.println(bindingResult.getAllErrors());
			return "/emp/register";
		}
		empService.insert(vo);
		return "redirect:/emp/list";
	}
	
	//삭제 처리
		@GetMapping("emp/delete")  //emp/delete?id=111
		public String delete(Integer id) {
			empService.deleteById(id);
			return "redirect:/emp/list";
		}
	
	//수정페이지로 이동
	
	
	//수정 처리
	
	
	//삭제 처리
	
	
}
