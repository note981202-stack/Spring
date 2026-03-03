package com.example.demo.hr.mapper;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("Employee")
public class EmpVO {  //xml 파일에 result id를 
		String employeeId;
		String firstName;
		String lastName;
		String email;
		Date hireDate;
		Integer salary;
		Double commissionPct;
		String jobId;
		String jobTitle;
		String departmentId;
		String managerId;
		String phoneNumber;
		String departmentName;
}
