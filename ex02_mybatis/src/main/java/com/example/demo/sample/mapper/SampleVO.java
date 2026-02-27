package com.example.demo.sample.mapper;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL) // null은 출력하지 마
public class SampleVO {
	
	@Schema(description = "사용자이름", example = "홍길동")
	@JsonProperty("username") // 이거 넣으면 name 부분이 username으로 바궈서 출력됨
	private String name; 
	
	@JsonIgnore // 이거 넣으면 age는 출력이 안됨
	private Integer age;
	
	@Schema(description = "가입일자", example = "2025-01-01")
	@DateTimeFormat(pattern = "yyyy-MM-dd") // 날짜 변환 형식
	@JsonFormat(pattern = "yyyy-MM-dd hh", timezone = "Asia/Seoul") // 시간 형식을 바꿔 주고 서울시간으로 맞춰 줌
	private Date regDate; //현재시간
	
	@Schema(description = "주소", example = "addr")
	private String addr; //주소 / null
	private List<String> hobby;
	
}
