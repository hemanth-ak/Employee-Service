package com.immaginnovate.employee.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class EmployeeWithTaxDTO {

	private long employeeId;
	private String firstName;
	private String lastName;
	private String emailId;
	private LocalDate dateOfJoining;
	private List<String> phoneNumbers;
	private int salary;
	private int tax;
	private int cess;
}
