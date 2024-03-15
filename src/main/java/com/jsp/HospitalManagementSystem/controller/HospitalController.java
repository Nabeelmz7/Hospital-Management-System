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

import com.jsp.HospitalManagementSystem.dto.Hospital;
import com.jsp.HospitalManagementSystem.service.HospitalService;
import com.jsp.HospitalManagementSystem.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
	
	@Autowired
	private  HospitalService hospitalService;
	
	@ApiOperation(value = "save hospital", notes="Api is used to save the hospital")
	@ApiResponses(value = {@ApiResponse(code=200, message="successfully saved")})
	@PostMapping
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital){
		return hospitalService.savehospital(hospital);
	}
	
	@ApiOperation(value = "Update hospital",notes = "Api is used to update the hospital")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "succesfully updated"),
			@ApiResponse(code = 404,message = "id not found")})	
	@PutMapping
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@RequestParam int Hid, @RequestBody Hospital hospital){
		return hospitalService.updatehospital(Hid, hospital);
	}
	
	@ApiOperation(value = "Delete hospital",notes = "Api is used to delete the hospital")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "succesfully deleted"),
			@ApiResponse(code = 404,message = "id not found")})
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(@RequestParam int Hid){
		return hospitalService.deletehospital(Hid);
	}
	
	@ApiOperation(value = "Get hospital By Id",notes = "Api is used to find the hospital based on id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "succesfully found"),
			@ApiResponse(code = 404,message = "id not found")})
	@GetMapping
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(@RequestParam int Hid){
		return hospitalService.gethospitalbyid(Hid);	
	}
	
	@ApiOperation(value = "Get hospital By email",notes = "Api is used to find the hospital based on email")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "succesfully found"),
			@ApiResponse(code = 404,message = "email not found")})
	@GetMapping("/getbyemail")
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalByEmail(@RequestParam String email){
		return hospitalService.getHospitalByEmail(email);	
	}
}
