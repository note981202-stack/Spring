package com.example.demo;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.sample.mapper.SampleVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperTest {

	@Test
	@DisplayName("자바 객체를 JSON으로 변환")
	public void toJson() throws JsonProcessingException { //예외처리
		SampleVO vo = SampleVO.builder()
				.name("홍길동")
				.age(20)
				.hobby(List.of("read", "game"))
				.regDate(new Date())
				.build();
		
		ObjectMapper mapper = new ObjectMapper(); //객체 형성
		String result = mapper.writeValueAsString(vo);
		System.out.println(result); 
	} //end
	
//	@Test
	@DisplayName("json string을 자바객체로 변환")
	public void fromJson() throws JsonMappingException, JsonProcessingException {
		String json = "{\"name\":\"홍길동\",\"age\":20,\"hobby\":[\"read\",\"game\"]}\r\n"
				+ "";
		ObjectMapper mapper = new ObjectMapper();
		SampleVO vo = mapper.readValue(json, SampleVO.class); // 이게 변환 되는 것
		System.out.println(vo);
	} //end
	
	
	
}//class end
