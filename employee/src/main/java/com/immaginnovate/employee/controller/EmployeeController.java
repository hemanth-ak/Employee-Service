package com.immaginnovate.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.immaginnovate.employee.dto.EmployeeDTO;
import com.immaginnovate.employee.dto.EmployeeWithTaxDTO;
import com.immaginnovate.employee.model.Employee;
import com.immaginnovate.employee.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody EmployeeDTO employeeDtoRequest) {
		return new ResponseEntity<>(employeeService.saveEmployee(employeeDtoRequest), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeWithTaxDTO>> getEmployeesWithTax() {
		return new ResponseEntity<>(employeeService.getEmployeesWithTax(), HttpStatus.OK);
	}

}
