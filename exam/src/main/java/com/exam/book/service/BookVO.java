package com.exam.book.service;

import java.util.Date;

import lombok.Data;

@Data
public class BookVO {
	
	Integer bookNo;           
	String bookName;                
	String bookCoverimg;          
	Date bookDate;                         
	Integer bookPrice;                     
	String bookPublisher;       
	String bookInfo;

}
