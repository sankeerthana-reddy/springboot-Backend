package com.example.springbootbackend.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootbackend.model.Address;
import com.example.springbootbackend.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {
	
	public AddressService addressService;

	public AddressController(AddressService addressService) {
		super();
		this.addressService = addressService;
	}
	
	@PostMapping
	public ResponseEntity<Address>  saveAddress(@RequestBody Address address){
		
		return new ResponseEntity<Address>(addressService.saveAddress(address) , HttpStatus.CREATED);
	}
	

	@GetMapping("{employeeId}")
	public List<Address> getAddessByEmployeeId(@PathVariable("employeeId") long employeeId){
		
		//return  new ResponseEntity<Address>(addressService.getAddessByEmployeeId(employeeId));
		
		return addressService.getAddessByEmployeeId(employeeId);
		
	}
	
}
