package com.jsp.HospitalManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.HospitalManagementSystem.dto.Address;
import com.jsp.HospitalManagementSystem.service.AddressService;
import com.jsp.HospitalManagementSystem.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@ApiOperation(value = "save Address", notes="Api is used to save the address")
	@ApiResponses(value = {@ApiResponse(code=200, message="successfully saved")})
	@PostMapping
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address){
		return addressService.saveAddress(address);	
	}
	
	@ApiOperation(value = "Update Address",notes = "Api is used to update the Address")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "succesfully updated"),
			@ApiResponse(code = 404,message = "id not found")})	
	@PutMapping
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestParam int aid, @RequestBody Address address){
		return addressService.updateAddress(aid, address);
	}
	
	@ApiOperation(value = "Delete Address",notes = "Api is used to delete the address")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "succesfully deleted"),
			@ApiResponse(code = 404,message = "id not found")})
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(@RequestParam int aid){
		return addressService.deleteAddress(aid);	
	}
	
	@ApiOperation(value = "Get address By Id",notes = "Api is used to find the address based on id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "succesfully found"),
			@ApiResponse(code = 404,message = "id not found")})
	@GetMapping
	public ResponseEntity<ResponseStructure<Address>> getaddressbyid(@RequestParam int aid){
		return addressService.getAddressById(aid);	
	}
}
