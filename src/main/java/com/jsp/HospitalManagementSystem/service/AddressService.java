package com.jsp.HospitalManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.HospitalManagementSystem.dao.AddressDao;
import com.jsp.HospitalManagementSystem.dto.Address;
import com.jsp.HospitalManagementSystem.exception.IdNotFoundException;
import com.jsp.HospitalManagementSystem.util.ResponseStructure;

@Service
public class AddressService {
	@Autowired
	private AddressDao addressDao;
	
	ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
	
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address){
		responseStructure.setMessage("Address saved successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(addressDao.saveAddress(address));	
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.CREATED);	
	}
	
	public ResponseEntity<ResponseStructure<Address>> updateAddress(int aid,Address address){
		Address dbAddress=addressDao.updateAddress(aid, address);
		if (dbAddress!=null) {	
			responseStructure.setMessage("Address updated successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dbAddress);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int aid){
		Address address=addressDao.deleteAddress(aid);
		if (address!=null) {
			responseStructure.setMessage("Address deleted successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}			
	}
	
	public ResponseEntity<ResponseStructure<Address>> getAddressById(int aid){
		Address address=addressDao.getAddressById(aid);
		if (address!=null) {
			responseStructure.setMessage("Address found successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.FOUND);
		}else {
			throw new IdNotFoundException();
		}
	}
}
