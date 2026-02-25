package com.example.demo;

import java.util.Date;
import lombok.Data;

@Data
public class EmpVO {
		String employeeId;
		String firstName;
		String lastName;
		String email;
		Date hireDate;
		int salary;
		String jobId;
		String departmentId;
		String managerId;
}
