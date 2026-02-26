package com.example.demo.sample.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.sample.mapper.SampleVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController //핸들러 리턴결과가 json, xml로 자동 변환
public class SampleRestController {
	
	@GetMapping("/ex1") //커멘드핸들러 , 커멘드객체
	public String ex1(SampleVO vo) { //객체형 타입 - 이렇게 쓰면 아래와 같이 귀찮게 안써도 됨
		log.info(vo.toString());
		return vo.toString();
	}
	         
	@GetMapping("/ex02") //ex2?name=choi  
	public String ex2(@RequestParam(required = false, //원시형 타입 - 개별 / requestparam은 써도 되고 안써도 됨
									defaultValue = "choi",
									name = "nm") String name,
					Integer age,
					String[] hobby) {  
		log.info(name, age);
		return name + " : " + age;
	}
	
	@GetMapping("/em03/{name}/{age}") //ex3/choi/20   ex3/park/10
	public String ex3(@PathVariable String name, 
					  @PathVariable Integer age ) {
		log.info(name, age);
		return name + " : " + age;
	}
	
}
