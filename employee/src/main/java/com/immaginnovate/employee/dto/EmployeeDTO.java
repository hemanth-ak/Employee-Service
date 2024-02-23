package com.immaginnovate.employee.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {
	
	private String firstName;
	private String lastName;
	private String emailId;
	private LocalDate dateOfJoining;
	private List<String> phoneNumbers;
	private int salary;
	
}
