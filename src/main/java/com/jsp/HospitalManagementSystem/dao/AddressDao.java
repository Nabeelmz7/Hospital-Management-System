package com.jsp.HospitalManagementSystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.HospitalManagementSystem.Repo.AddressRepo;
import com.jsp.HospitalManagementSystem.dto.Address;

@Repository
public class AddressDao {
	@Autowired
	private AddressRepo addressRepo;
	
	public Address saveAddress(Address address) {
		return addressRepo.save(address);
	}
	
	public Address updateAddress(int id, Address address) {
		if (addressRepo.findById(id).isPresent()) {
			address.setAid(id);
			return addressRepo.save(address);
		}else {
			return null;
		}		
	}
	
	public Address deleteAddress(int id) {
		if (addressRepo.findById(id).isPresent()) {
			Address address=addressRepo.findById(id).get();
			addressRepo.deleteById(id);
			return address;
		}else {
			return null;
		}
	}
	
	public Address getAddressById(int id) {
		if (addressRepo.findById(id).isPresent()) {
			return addressRepo.findById(id).get();
		}else {
			return null;
		}
	}
}
