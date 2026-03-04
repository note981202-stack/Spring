package com.example.demo.hr.service;

import java.util.List;

import com.example.demo.hr.mapper.EmpRequestVO;
import com.example.demo.hr.mapper.EmpVO;

public interface EmpService {
	
	    //전체 조회
		public List<EmpVO> findAll(String order);
		//단건 조회
		public EmpVO findById(int id); //map 아니라 empvo로 읽어 올거임
		//삭제
		int deleteById(Integer employeeId);
		//등록
		int insert(EmpRequestVO vo);
		//수정
		int upadate(EmpVO vo);

}
