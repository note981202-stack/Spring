package com.example.demo.hr.mapper;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmpRequestVO {   //조회용 VO
		String employeeId;
		@Size(min = 10, max = 200, message = "글자길이는 10 and 20 입니다.")
		String firstName;
		
		@NotEmpty(message = "이름은 필수 입력입니다.") //string은 notEmpty / date는 notnull
		String lastName;
		
		@Email(message = "이메일 형식이 아닙니다")
		@NotEmpty(message = "이메일은 필수 입력항목 입니다.")
		String email;
		
		@DateTimeFormat(pattern = "yyyy/MM/dd")
		@NotNull
		Date hireDate;
		
		Integer salary;
		
		Double commissionPct;
		
		@NotEmpty
		String jobId;
		String departmentId;
		String managerId;
		
		@Pattern(regexp = "0\\d{1,2}-\\d{1,4}-\\d{4}", message = "xxx-xxxx-xxxx 형식")
		String phoneNumber;
}
