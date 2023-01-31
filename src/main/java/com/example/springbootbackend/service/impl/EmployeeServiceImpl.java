package com.example.springbootbackend.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.springbootbackend.DTO.AddressDTO;
import com.example.springbootbackend.DTO.EmployeeDTO;
import com.example.springbootbackend.exeception.ResourceNotFoundException;
import com.example.springbootbackend.model.Address;
import com.example.springbootbackend.model.Employee;
import com.example.springbootbackend.repository.EmployeeRepository;
import com.example.springbootbackend.service.AddressService;
import com.example.springbootbackend.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
    public AddressService addressServie  ;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository,AddressService addressServie) {
		super();
		this.employeeRepository = employeeRepository;
		this.addressServie= addressServie;
	}


	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
		
		Employee employee=employeeRepository.save(Employee.getEmployee(employeeDTO));
		
		return EmployeeDTO.getEmployeeDTO(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		
		  Optional<Employee> employee =employeeRepository.findById(id);
		  
		  if(employee.isPresent()) { 
			  
			  return employee.get();
		  
		  } else { 
			  
			  throw new ResourceNotFoundException("Employee", "id", employee); 
			  
		  }
		 
		// Lambda Expression
		/*
		 * return employeeRepository.findById(id).orElseThrow(() ->
		 * 
		 * new ResourceNotFoundException("Employee", "Id", id));
		 */
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		//check whether the employee with given id is available or not in DB
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "Id", id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		//saving the Updated Employee to DB
		employeeRepository.save(existingEmployee);
		
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		
		//check whether that ID is available or not
		
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		
		employeeRepository.deleteById(id);
		
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		
		List<Employee> employees = employeeRepository.findByEmail(email);
		
		if (CollectionUtils.isEmpty(employees)) {
			throw new ResourceNotFoundException("Employee", "email", email);
		}
		
		return employees.get(0);
		
	
	}

	@Override
	public EmployeeDTO getEmployeeDetails(long id) {
		
		Optional<Employee> employeeOption = employeeRepository.findById(id);
		
		
		if(employeeOption.isPresent()) {
			
			List<Address> addressList = addressServie.getAddessByEmployeeId(id);//[0,1,2,3..]
			
			
			List<AddressDTO> addressDTOList = new ArrayList<AddressDTO>();
			
			for (int i=0;i<addressList.size();i++) {
				
				addressDTOList.add(AddressDTO.getAddressDTO(addressList.get(i)));		
				
			}
			
			EmployeeDTO employeeDTO = new EmployeeDTO();
			
			employeeDTO.setId(employeeOption.get().getId());
			employeeDTO.setEmail(employeeOption.get().getEmail());
			employeeDTO.setFirstName(employeeOption.get().getFirstName());
			employeeDTO.setLastName(employeeOption.get().getLastName());
			employeeDTO.setAddresses(addressDTOList);
			
		
			return employeeDTO;
			
		}else
		{
			
			throw new ResourceNotFoundException("Employee", "id", id);
			
		}
		
				
		
		
	}
	
	
		

	
	

}
