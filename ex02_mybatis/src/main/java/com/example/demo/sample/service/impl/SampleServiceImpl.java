package com.example.demo.sample.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.sample.mapper.SampleMapper;
import com.example.demo.sample.service.SampleService;

import lombok.RequiredArgsConstructor;

//구현클래스임
@Service  //스프링 컨테이너에 빈 등록
@RequiredArgsConstructor

public class SampleServiceImpl 
	   implements SampleService{

	final SampleMapper sampleMapper; 
	
	@Transactional
	@Override
	public void add(String data) {
		sampleMapper.add1(data);
		sampleMapper.add2(data);
		
	}
}
