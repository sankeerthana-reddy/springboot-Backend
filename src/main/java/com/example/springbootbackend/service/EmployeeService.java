package com.example.springbootbackend.service;

import java.util.List;

import com.example.springbootbackend.DTO.EmployeeDTO;
import com.example.springbootbackend.model.Employee;

public interface EmployeeService {

	EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(long id);
	
	Employee getEmployeeByEmail(String email);
	
	Employee updateEmployee(Employee employee , long id);
	
	void deleteEmployee(long id);
	
	
	EmployeeDTO getEmployeeDetails(long id);
	
	
}
