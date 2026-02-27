package com.example.demo.sample.web;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.sample.mapper.SampleVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController //핸들러 리턴결과가 json, xml로 자동 변환
public class SampleRestController {
	
	@GetMapping("/ex01") //커멘드핸들러 , 커멘드객체
	public SampleVO ex1(SampleVO vo) { //객체형 타입 - 이렇게 쓰면 아래와 같이 귀찮게 안써도 됨
		log.info(vo.toString());
		return vo;
	}
	
	@Tag(name= "Sample API")  
	@Operation(summary = "회원정보조회",  
	description = "티켓정보를 조회합니다.",  
	responses = {  
				@ApiResponse(responseCode = "200", description = "등록 성공"), 
				@ApiResponse(responseCode = "400", description = "잘못된 요청") 
				}) 
	@Parameter(description = "회원정보", example = "{username:'홍길동', addr:'대구'}")
	
	@PostMapping("/ex01") //커멘드핸들러 , 커멘드객체
	public SampleVO ex11(@RequestBody SampleVO vo) { //객체형 타입 - 이렇게 쓰면 아래와 같이 귀찮게 안써도 됨
		log.info(vo.toString());
		return vo;
	}
	
	@PutMapping("/ex01") //풋  커멘드핸들러 , 커멘드객체
	public ResponseEntity<SampleVO> ex12(@RequestBody SampleVO vo) { //객체형 타입 - 이렇게 쓰면 아래와 같이 귀찮게 안써도 됨
		log.info(vo.toString());
		return new ResponseEntity<SampleVO>(vo, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
//	@GetMapping("/ex1") //커멘드핸들러 , 커멘드객체
//	public String ex1(SampleVO vo) { //객체형 타입 - 이렇게 쓰면 아래와 같이 귀찮게 안써도 됨
//		log.info(vo.toString());
//		return vo.toString();
//	}
	         
	@GetMapping("/ex02") //ex2?name=choi  
	public String ex2(@RequestParam(required = false, //원시형 타입 - 개별 / requestparam은 써도 되고 안써도 됨
									defaultValue = "choi",
									name = "nm") String name,
					Integer age,
					String[] hobby) {  
		log.info(name, age);
		return name + " : " + age;
	}
	
	
	@GetMapping("/ex03/{name}/{age}") //ex3/choi/20   ex3/park/10
	public String ex3(@PathVariable String name, 
					  @PathVariable Integer age ) {
		log.info(name, age);
		return name + " : " + age;
	}

	@GetMapping("/ex04")    
	public SampleVO ex4() {
		SampleVO vo = SampleVO.builder()
				.name("홍길동")
				.age(20)
				.hobby(List.of("read", "game"))
				.regDate(new Date())
				.build();
		return vo; 
	}

	@GetMapping("/ex05") // 04번을 리스트로 출력
	public List<SampleVO> ex05() {
		return List.of(SampleVO.builder()
				.name("홍길동")
				.age(20)
				.hobby(List.of("read", "game"))
				.regDate(new Date())
				.build(),
				SampleVO.builder()
				.name("김유신")
				.age(20)
				.hobby(List.of("read", "game"))
				.regDate(new Date())
				.build());
	}
	
	
	
	
	
	
	
} //end class
