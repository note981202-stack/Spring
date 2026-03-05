package com.example.demo.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import	lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Entity
public class Customer { //entity class 가 sql을 자동으로 만들어줌
	@Id
	@GeneratedValue(strategy	=	GenerationType.AUTO)
	private	Long	id;
	@Column(length	=	20,	nullable = false)
	private	String	name;
	@Column(length	=	20,	nullable = false,	unique	=	true)
	private	String	phone;
	
	@Builder.Default
	@OneToMany(mappedBy = "customer")
	private List<Address> address = new ArrayList<>();
	
	@Transient //DB컬럼으로 저장하지 않음
	private Integer grade;
	
	@Temporal(TemporalType.DATE)
	private Date regdate;
	
//	@OneToOne
//	@JoinColumn(name = "address_id")  //address랑 연결해서 회원 정보 조회하면 주소도 같이 뜸
//	private Address address;
	
	public Customer(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}					
}

