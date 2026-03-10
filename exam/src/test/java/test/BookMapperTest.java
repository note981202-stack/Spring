package test;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import com.exam.book.service.BookVO;
import com.exam.book.service.impl.BookMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BookMapperTest {

	@Autowired BookMapper bookMapper;
	
	@Test
	@DisplayName("도서 목록 전체 조회")
	public void findAll() {
		
		//given
		String order = "book_no";
		
		//when
		List<BookVO>list = bookMapper.findAll(order);
		
		//then
		list.stream().forEach(book->System.out.println(book.getBOOK_NO()));
	} //findAll end
	
	
	
	
	
	
	
	
} //class end
