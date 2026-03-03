//SQL 호출 목적

package com.example.demo.hr.mapper; //메퍼 파일만 만들면 테스트파일에서 sql 확인 가능

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

//@Mapper // 스프링이 자동으로 빈등록해줌
public interface EmpMapper {
	public Map findByIdMap(int id); //단일 조회 - xml에서 보낸 아이디를 적어야 함
	public List<Map<String,Object>> findAllMap(); //전체 조회
	
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
	
	int deleteByIds(Integer[] employeeId);
	public List<EmpVO> findByDeptAndName(   //부서명 이름 조회
			@Param("deptId") String dept, 
			@Param("fname") String name); //목록으로 받을거임
	
	
	
	void insertDeptProc(DepartmentDTO dto);
}
