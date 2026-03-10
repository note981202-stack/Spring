package com.exam.book.service;

import java.util.Date;

import lombok.Data;

@Data
public class RentVO {

	Integer rentNo;     
	Integer bookNo;           
	Integer rentPrice;          
	Date rentDate;            
	String rentStatus; 
}
