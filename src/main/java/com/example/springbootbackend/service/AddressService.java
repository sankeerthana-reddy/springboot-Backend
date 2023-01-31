package com.example.springbootbackend.service;

import java.util.List;

import com.example.springbootbackend.model.Address;

public interface AddressService {

	
	Address saveAddress(Address address);
	
	List<Address> getAddessByEmployeeId(long employeeId);
	

}
