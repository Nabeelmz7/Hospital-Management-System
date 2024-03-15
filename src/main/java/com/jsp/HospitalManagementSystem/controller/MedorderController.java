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

import com.jsp.HospitalManagementSystem.dto.Medorder;
import com.jsp.HospitalManagementSystem.service.MedorderService;
import com.jsp.HospitalManagementSystem.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/medorder")
public class MedorderController {
	
	@Autowired
	private MedorderService medorderService;
	
	@ApiOperation(value = "save medorder", notes="api is used to save medorder")
	@ApiResponses(value = {@ApiResponse(code=200, message=" successfully saved")})
	@PostMapping
	public ResponseEntity<ResponseStructure<Medorder>> saveMedorder(@RequestBody Medorder medorder, @RequestParam int eid){
		return medorderService.saveMedorder(medorder, eid);	
	}
	
	@ApiOperation(value = "update medorder", notes = "api is used to update medorder")
	@ApiResponses(value = {@ApiResponse(code=201, message = "successfully updated")})
	@ApiResponse(code = 404, message = "id not found")
	@PutMapping
	public ResponseEntity<ResponseStructure<Medorder>> updateMedorder(@RequestBody Medorder medorder,@RequestParam int id){
		return medorderService.updateMedorder(id, medorder);
	}
	
	@ApiOperation(value = "delete medorder", notes = "api is used to delete medorder")
	@ApiResponses(value = {@ApiResponse(code=200, message = "successfully deleted")})
	@ApiResponse(code = 404, message = "id not found")
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Medorder>> deleteMedorder(@RequestParam int id){
		return medorderService.deleteMedorder(id);
	}
	
	@ApiOperation(value = "get medorder by id", notes = "api is used to get medorder based on id")
	@ApiResponses(value = {@ApiResponse(code = 302, message = "successfully found")})
	@ApiResponse(code = 404, message = "id not found")
	@GetMapping
	public ResponseEntity<ResponseStructure<Medorder>> getmedorderbyid(@RequestParam int id){
		return medorderService.getMedorderById(id);
	}
}
