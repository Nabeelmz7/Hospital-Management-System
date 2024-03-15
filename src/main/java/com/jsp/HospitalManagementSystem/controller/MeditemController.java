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

import com.jsp.HospitalManagementSystem.dto.Meditems;
import com.jsp.HospitalManagementSystem.service.MeditemService;
import com.jsp.HospitalManagementSystem.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/meditem")
public class MeditemController {
	@Autowired
	private MeditemService meditemService;
	
	@ApiOperation(value = "save meditem", notes="Api is used to save the meditem")
	@ApiResponses(value = {@ApiResponse(code=200, message="successfully saved")})
	@PostMapping
	public ResponseEntity<ResponseStructure<Meditems>> saveMeditem(@RequestParam int id, @RequestBody Meditems meditems){
		return meditemService.saveMeditems(meditems, id);
	}
	
	@ApiOperation(value = "Update meditem",notes = "Api is used to update the meditem")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "succesfully updated"),
			@ApiResponse(code = 404,message = "id not found")})	
	@PutMapping
	public ResponseEntity<ResponseStructure<Meditems>> updateMeditem(@RequestParam int mid, @RequestBody Meditems meditems){
		return meditemService.updateMeditems(mid, meditems);
	}
	
	@ApiOperation(value = "Delete meditem",notes = "Api is used to delete the meditem")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "succesfully deleted"),
			@ApiResponse(code = 404,message = "id not found")})
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Meditems>> deleteMeditem(@RequestParam int mid){
		return meditemService.deleteMeditems(mid);
	}
	
	@ApiOperation(value = "Get meditem By Id",notes = "Api is used to find the meditem based on id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "succesfully found"),
			@ApiResponse(code = 404,message = "id not found")})
	@GetMapping
	public ResponseEntity<ResponseStructure<Meditems>> getmeditembyid(@RequestParam int mid){
		return meditemService.getMeditemsById(mid);
	}
}
