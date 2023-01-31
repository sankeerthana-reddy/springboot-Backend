package com.example.springbootbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.springbootbackend.model.Employee;



public interface EmployeeRepository extends JpaRepository< Employee , Long > {
	
	
	public List<Employee> findByEmail(String email);
	
	@Query(
			  value = "SELECT * FROM employees WHERE name = TRIM(?1)", 
			  nativeQuery = true)
	public List<Employee> findByName(String name);
	
	
	public Employee findByFirstName(String firstName);
	
	
}
