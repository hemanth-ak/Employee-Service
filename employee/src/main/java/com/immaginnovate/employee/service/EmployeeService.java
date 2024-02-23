package com.immaginnovate.employee.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.immaginnovate.employee.dto.EmployeeDTO;
import com.immaginnovate.employee.dto.EmployeeWithTaxDTO;
import com.immaginnovate.employee.model.Employee;
import com.immaginnovate.employee.repository.EmployeeRepository;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {


	private final EmployeeRepository employeeRepository;
	private final TaxCalculatorService taxCalculatorService;
	private static final List<Integer> financialYearList = List.of(1, 2, 3);
	
	public Employee saveEmployee(EmployeeDTO employeeDtoRequest) {
		Employee employee = Employee.builder()
				.firstName(employeeDtoRequest.getFirstName())
				.lastName(employeeDtoRequest.getLastName())
				.emailId(employeeDtoRequest.getEmailId())
				.phoneNumbers(employeeDtoRequest.getPhoneNumbers())
				.salary(employeeDtoRequest.getSalary())
				.dateOfJoining(employeeDtoRequest.getDateOfJoining())
				.build();
		return employeeRepository.save(employee);
	}
	
	public List<EmployeeWithTaxDTO> getEmployeesWithTax() {
		List<Employee> employeeList =  employeeRepository.findAll();
		return employeeList.stream()
				.map(this::buildEmployeeWithTaxDTO)
				.toList();
	}

	private EmployeeWithTaxDTO buildEmployeeWithTaxDTO(Employee employee) {
		int salary = calculateSalary(employee.getSalary(), employee.getDateOfJoining());
		return EmployeeWithTaxDTO.builder()
				.employeeId(employee.getEmployeeId())
				.firstName(employee.getFirstName())
				.lastName(employee.getLastName())
				.emailId(employee.getEmailId())
				.phoneNumbers(employee.getPhoneNumbers())
				.salary(employee.getSalary())
				.dateOfJoining(employee.getDateOfJoining())
				.tax(taxCalculatorService.calculateTax(salary))
				.cess(taxCalculatorService.calculateCess(salary))
				.build();
	}

	private int calculateSalary(int salary, LocalDate dateOfJoining) {
		LocalDate financialYearStartDate = fetchFinancialYearStartDate();
		if (financialYearStartDate.isBefore(dateOfJoining)) {
			Period period = Period.between(financialYearStartDate, dateOfJoining);
			int months = Math.abs(period.getMonths());
			int days = Math.abs(period.getDays());
			int salaryPerMonth = salary/12;
			return salary - ((salaryPerMonth * months) + (salaryPerMonth/30) * days);
		}
		return salary;
	}

	private LocalDate fetchFinancialYearStartDate() {
		LocalDate currentDate = LocalDate.now();
		if(financialYearList.contains(currentDate.getMonthValue())) {
			return LocalDate.of(currentDate.getYear() - 1, 4, 1);
		} else {
			return LocalDate.of(currentDate.getYear(), 4, 1);
		}
	}
}
