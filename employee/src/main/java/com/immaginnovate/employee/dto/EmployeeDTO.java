package com.immaginnovate.employee.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {

	@NotBlank(message = "The first name is required.")
	private String firstName;
	@NotBlank(message = "The last name is required.")
	private String lastName;
	@Email(message = "The email address is invalid.")
	@NotBlank(message = "The email ID is required.")
	private String emailId;
	@JsonFormat(pattern="yyyy-MM-dd")
	@NotNull(message = "Date of Joining cannot be empty")
	private LocalDate dateOfJoining;
	@NotNull(message = "At least one phone number has to be specified")
	private List<String> phoneNumbers;
	@NotNull(message = "Salary cannot be null")
	private int salary;
	
}
