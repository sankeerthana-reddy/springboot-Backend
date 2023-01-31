package com.example.springbootbackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootbackend.DTO.EmployeeDTO;
import com.example.springbootbackend.model.Employee;
import com.example.springbootbackend.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	
	//build create employee Rest API
	@PostMapping()
	public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO){
		
		return new ResponseEntity<EmployeeDTO>(employeeService.saveEmployee(employeeDTO), HttpStatus.CREATED);
		
	}
	
	
	//build get all the employees RestAPI
	@GetMapping
	public List<Employee> getAllEmployee(){
		
		return employeeService.getAllEmployees();
		
	}
	
	//To get an particular employee based on id
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeByID(@PathVariable("id") long id) {
		
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.OK) ;
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable("email") String email) {
		
		return new ResponseEntity<Employee>(employeeService.getEmployeeByEmail(email),HttpStatus.OK) ;
	}
		
	//Build Update Employee Rest API
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee){
	
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
	}
	
	
	//Delete an Employee RestAPI
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
		
		employeeService.deleteEmployee(id);
		
		return new ResponseEntity<String>("Employee Deleted Successfully!.",HttpStatus.OK);
	}
	
	
	@GetMapping("/Details/{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeDetails(@PathVariable("id") long id){
		
		
		return new ResponseEntity<EmployeeDTO>(employeeService.getEmployeeDetails(id),HttpStatus.OK);
		
	}

}
