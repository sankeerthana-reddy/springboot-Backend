package com.example.springbootbackend.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.example.springbootbackend.exeception.ResourceNotFoundException;
import com.example.springbootbackend.model.Address;
import com.example.springbootbackend.repository.AddressRepository;
import com.example.springbootbackend.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{

	
	private AddressRepository addressrepository;
	
	
	public AddressServiceImpl(AddressRepository addressrepository) {
		super();
		this.addressrepository = addressrepository;
	}

	@Override
	public Address saveAddress(Address address) {
		
		
		return addressrepository.save(address);
	}

	@Override
	public List<Address> getAddessByEmployeeId(long employeeId) {
		
		List<Address> addresses =addressrepository.findByEmployeeId(employeeId);
		
		if(CollectionUtils.isEmpty(addresses)){
			
			 throw new ResourceNotFoundException("Address","employeeId",employeeId);
		}
		
		return  addresses;
	}


}
