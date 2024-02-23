package com.immaginnovate.employee.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employeeId;
    
	@NotBlank(message = "The first name is required.")
	private String firstName;
	
	@NotBlank(message = "The last name is required.")
	private String lastName;
	
	@Email(message = "The email address is invalid.")
	@NotBlank(message = "The email ID is required.")
	private String emailId;
	
	private List<String> phoneNumbers;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dateOfJoining;
	
	private int salary;
}
