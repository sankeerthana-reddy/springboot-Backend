package com.example.springbootbackend.DTO;

import java.util.List;

import com.example.springbootbackend.model.Employee;




public class EmployeeDTO {

	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private List<AddressDTO> addresses;
	
	
	public static EmployeeDTO getEmployeeDTO(Employee employee) {
		
		
		EmployeeDTO employeeDTO= new EmployeeDTO();
		
		employeeDTO.setEmail(employee.getEmail());
		employeeDTO.setFirstName(employee.getFirstName());
		employeeDTO.setLastName(employee.getLastName());
		employeeDTO.setId(employee.getId());
		
		
		return employeeDTO;
	}

	public List<AddressDTO> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressDTO> addresses) {
		this.addresses = addresses;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
