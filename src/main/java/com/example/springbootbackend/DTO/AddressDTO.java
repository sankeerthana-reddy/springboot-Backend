package com.example.springbootbackend.DTO;

import com.example.springbootbackend.model.Address;

public class AddressDTO {
	
	private long id;
	
	private long employeeId;
	
	private String street;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private long pincode;

	public static AddressDTO getAddressDTO(Address address) {
		
		AddressDTO addressDTO = new AddressDTO();
		
		addressDTO.setCity(address.getCity());
		addressDTO.setCountry(address.getCountry());
		addressDTO.setEmployeeId(address.getEmployeeId());
		addressDTO.setId(address.getId());
		addressDTO.setPincode(address.getPincode());
		addressDTO.setState(address.getState());
		addressDTO.setStreet(address.getStreet());
				
		return addressDTO;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}


}
