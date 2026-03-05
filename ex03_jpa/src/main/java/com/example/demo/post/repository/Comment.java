package com.example.demo.post.repository;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.example.demo.repository.Customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Table(name = "comments")
@Entity
public class Comment //comment테이블을 객체로 만든것
		extends BaseTimeEntity {
	
	@Builder
	public Comment(String comment, Posts posts, Customer customer) {
			super();
			this.comments = comment;
			this.posts = posts;
			this.customer = customer;
		}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "clob", nullable = false)
	private String comments; // 댓글 내용     
	
//	@Column(name = "created_date")
//	@CreatedDate
//	private String createdDate;
//	
//	@Column(name = "modified_date")
//	@LastModifiedDate
//	private String modifiedDate;
	
	@ManyToOne // post_id 한개에 댓글 여러개
	@JoinColumn(name = "posts_id")
	private Posts posts;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer; // 작성자

}
