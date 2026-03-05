package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.Address;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.Customer;
import com.example.demo.repository.CustomerRepository;

@SpringBootTest
public class CustomerRepositoryTest {
	@Autowired CustomerRepository customerRepository;
	@Autowired AddressRepository addressRepository;

	
	@Test
	@Transactional
	@Commit
	public void manytoOneTest() {
		//address
		Address addr1 = Address.builder()
				.address("대구")
				.zipcode("31411")
				.detail_address("중구")
				.build();
		
		Address addr2 = Address.builder()
				.address("부산")
				.zipcode("31400")
				.detail_address("북구")
				.build();
		
		addressRepository.save(addr1);
		addressRepository.save(addr2);

		Customer cust = Customer.builder()
					.name("홍길동")
					.phone("011")
					.address(List.of(addr1, addr2))
					.build();

		//customer
		Customer result = customerRepository.save(cust);
		Customer customer = customerRepository.findById(result.getId()).get();
		customer.getAddress().forEach(ad-> System.out.println(ad.getDetail_address()));
		
	}
	
	
	@Transactional
	@Commit
//	@Test
	@DisplayName("고객정보등록")
	public void save() {
		
		//given
		Address addr = Address.builder()
						.address("대구")
						.zipcode("31411")
						.detail_address("중구")
						.build();
		Address address = addressRepository.save(addr);
		
//		Customer cust = Customer.builder()
//					.name("홍길동")
//					.phone("011")
//					.address(addr)
//					.build();
//		Customer result = customerRepository.save(cust);
//		//when
//		Customer customer = customerRepository.findById(result.getId()).get();
//		
//		//then
//		System.out.println(">>>>"+customer.getAddress().getDetail_address());
//		assertEquals(cust.getName(), result.getName());
	}
	
	@Transactional
	@Commit
//	@Test
	@DisplayName("고객정보수정")
	public void merge() {
		
		//given
		Customer cust = customerRepository.findById(2L).orElse(new Customer());
		cust.setName("이순신");
		
		//when
		Customer result = customerRepository.save(cust);
		
		//then
		assertEquals(cust.getName(), result.getName());
	}
	
	@Transactional
	@Commit
//	@Test
	@DisplayName("고객정보삭제")
	public void delete() {
		
		//given
		Customer cust = customerRepository.findById(2L).orElse(new Customer());
		
		//when
		customerRepository.delete(cust);
		
		//then
		Customer result = customerRepository.findById(2L).get();
		assertNull(result);
	}
	
//	@Test
	@DisplayName("이름검색")
	public void findByName() {
		//given
		customerRepository.deleteAll();
		customerRepository.save(new	Customer("Jack", "010"));
		customerRepository.save(new	Customer("Chloe", "111"));
		customerRepository.save(new	Customer("Kim",	"222"));
		customerRepository.save(new	Customer("David", "333"));
		customerRepository.save(new	Customer("Kim", "444"));
		
		
		//when
		List<Customer> list = customerRepository.findByOrderByNameDesc();
		
		//then
//		assertEquals(list.size(), 2);
		list.forEach(c-> System.out.println(c.getName()));
		
	}
	@BeforeEach
	public void before() {
		customerRepository.deleteAll();
		customerRepository.save(new	Customer("Jack", "010"));
		customerRepository.save(new	Customer("Chloe", "111"));
		customerRepository.save(new	Customer("Kim",	"222"));
		customerRepository.save(new	Customer("David", "333"));
		customerRepository.save(new	Customer("Kim", "444"));
	}
	
//	@Test
	@DisplayName("폰검색")
	public void findByPhone() {
		
		//given
		String phone = "010";
		
		//when
		Customer cust = customerRepository.findByPhone(phone);
		
		//then
		assertEquals(cust.getPhone(), phone);
		
	}
	
//	@Test
	@DisplayName("네이티브 쿼리")
	public void query() {
		List<Map<String, Object>> list = customerRepository.findAllByPhone();
		list.forEach(map -> System.out.println(map.get("id") + " " + map.get("name")));
		
	}
	
	
}
