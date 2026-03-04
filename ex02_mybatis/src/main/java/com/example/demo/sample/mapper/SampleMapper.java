package com.example.demo.sample.mapper;

import org.apache.ibatis.annotations.Insert;

public interface SampleMapper {

	@Insert("insert into sample1 values (#{data})")
	void add1(String data);
	
	@Insert("insert into sample2 values (#{data})")
	void add2(String data);
}
