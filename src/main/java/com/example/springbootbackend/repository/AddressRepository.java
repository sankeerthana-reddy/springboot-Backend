package com.example.springbootbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootbackend.model.Address;


public interface AddressRepository extends JpaRepository< Address , Long >{
	

	
 public	List<Address> findByEmployeeId(long employeeId);
 
	
	
}
