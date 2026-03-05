package com.example.demo.post.repository; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository  //comment 테이블을 저장 수정 삭제 등 하는 파일
		extends JpaRepository<Comment, Long>{
			
		}


