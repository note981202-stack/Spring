package com.example.demo.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy	=	GenerationType.SEQUENCE)
	private Long id;
	
	private String zipcode;
	private String address;
	private String detail_address;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	Customer customer;
	
	
	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "customer_id") //커스터머랑 연결해서 address조회하면 관련 정보다 다 출력됨
	 * private Customer customer;
	 */
}
