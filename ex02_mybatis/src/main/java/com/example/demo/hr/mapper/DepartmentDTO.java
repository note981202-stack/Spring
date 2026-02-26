package com.example.demo.hr.mapper;

import lombok.Builder;
import lombok.Data;


@Builder
@Data

public class DepartmentDTO {
	private String departmentId;
	private String departmentName;
	private String managerId;
	private String locationId;
}
