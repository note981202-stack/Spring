// mybatis가 잘 작동하는지 확인하는 테스트 코드 
//jdbc 연결을 해줌

package com.example.demo.hr.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest // 스프링 컨테이너 전부 생성
public class EmpMapperTest {

	@Autowired EmpMapper empMapper;

	// 프로시저로 데이터 입력해서 db에 저장 함
	@Test
	@DisplayName("프로시저 호출")
	public void insertDeptProc() {
		DepartmentDTO dto = DepartmentDTO
				.builder()
				.departmentName("AI개발")
				.managerId("100")
				.locationId("1400")
				.build();
		empMapper.insertDeptProc(dto);
	}
	
	
	
	
	
	
	
	
//	@Test
	@DisplayName("여러 건 삭제")
	public void deleteByIds() {
		//given
		Integer[] list = new Integer[]{110, 111, 123};
		
		//when
		Integer cnt = empMapper.deleteByIds(list);
		System.out.println("처리건수: " + cnt);
	}
	
	
	
//	@Test
//	@DisplayName("단 건삭 제")
//	public void deleteById() {
//		//given - 테스트 준비
//				Integer id = 178;
//				
//				//when - 명령문
//				EmpVO vo =empMapper.deleteById(id);
//				
//				//then - 결과 출력
//				System.out.println(vo);
//	}
	
	
	
//	@Test
	@DisplayName("동적쿼리")
	public void findByDeptAndName() {
		//given
		String dno = ""; //"90"
		String fname = "null";//"King"
		
		//when
		List<EmpVO> list = empMapper.findByDeptAndName(dno, fname);
		
		//then
		System.out.println(list);
		
	}
	
	
	
//	@Test
	@DisplayName("사원조회 페이징") // 페이징 처리 방법
	// 사원전체조회
	public void findAllPage() {
	int pageNum = 2;
	int pagesize = 3;
	
	PageInfo<EmpVO> page = PageHelper.startPage(pageNum, pagesize)
					                 .doSelectPageInfo(() -> empMapper.findAll(null));
	System.out.println(page.getList());
	log.info("TotalCount : {}, CurrentPage : {}, PageSize : {}, TotalPage : {}"
            ,page.getTotal()
            ,page.getPageNum()
            ,page.getPageSize()
            ,page.getPages());
	}
	
	
	
//	@Test
	@DisplayName("사원조회(VO)")
	public void findAll() {
		
		//given
		String order = "department_id";
		
		//when - 명령문
		List<EmpVO>list =empMapper.findAll(order);

		//then - 결과 출력
		//firstName, salary 출력
		list.stream().forEach(emp->System.out.println(emp.getFirstName() + ":" +emp.getSalary())); // (emp 를 -> 로 념겨서 오른쪽의 코드로 실행하겠다)
	}
	
	
	
	
	
	
//	@Test
	@DisplayName("사원단건조회(VO)")
public void findById() {
		
		//given - 테스트 준비
		Integer id = 100;
		
		//when - 명령문
		EmpVO vo =empMapper.findById(id);
		
		//then - 결과 출력
		assertEquals(id.toString(), vo.getEmployeeId());
		
		System.out.println(vo);
	}
	
	
	
	
	
	
	
//	@Test
	@DisplayName("사원 번호 목록 조회")
	public void findByIdMap() {
		//when
		List<Map<String,Object>> list = empMapper.findAllMap();
		
		//then
		assertEquals("Steven", (String)list.get(0).get("firstName")); //어설트는 데이터 확인하고 가져오기 위한 조건 - 첫번째 이름이 king인 데이터가 맞으면 리스트를 출력하도록
		list.stream().forEach(emp->System.out.println((String)emp.get("firstName")));
	}
	
	
	
//	@Test
	@DisplayName("사원번호 조회(앱)")
	public void test() {
		
		//given - 테스트 준비
		Integer id = 100;
		
		//when - 명령문
		Map<String,Object> map =empMapper.findByIdMap(id);
		Integer result = ((BigDecimal)map.get("employeeId")).intValue();
		
		//then - 결과 출력
		assertEquals(id, result);
		System.out.println(map.get("firstName")+
					" : " + map.get("LAST_NAME"));
	}
	
//	@Test
//	public void findall() {
//		List<Map> list =empMapper.findAllMap();
//		list.stream().forEach(System.out::println);
	
//	} // find all end
	
	
} //class end
