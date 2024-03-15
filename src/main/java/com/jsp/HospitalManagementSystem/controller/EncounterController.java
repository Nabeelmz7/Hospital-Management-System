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

import com.jsp.HospitalManagementSystem.dto.Encounter;
import com.jsp.HospitalManagementSystem.service.EncounterService;
import com.jsp.HospitalManagementSystem.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/encounter")
public class EncounterController {
	@Autowired
	private EncounterService encounterService;
	
	@ApiOperation(value = "save encounter", notes="Api is used to save the encounter")
	@ApiResponses(value = {@ApiResponse(code=200, message="successfully saved")})
	@PostMapping
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@RequestBody Encounter encounter, @RequestParam int pid, @RequestParam int bid){
		return encounterService.saveEncounter(encounter, pid, bid);
	}
	
	@ApiOperation(value = "Update encounter",notes = "Api is used to update the encounter")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "succesfully updated"),
			@ApiResponse(code = 404,message = "id not found")})
	@PutMapping
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(@RequestParam int eid, @RequestParam int bid, @RequestBody Encounter encounter){
		return encounterService.updateEncounter(bid, encounter, eid);
	}
	
	@ApiOperation(value = "Delete encounter",notes = "Api is used to delete the encounter")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "succesfully deleted"),
			@ApiResponse(code = 404,message = "id not found")})
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(@RequestParam int eid){
		return encounterService.deleteEncounter(eid);
	}
	
	@ApiOperation(value = "Get encounter By Id",notes = "Api is used to find the encounter based on id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "succesfully found"),
			@ApiResponse(code = 404,message = "id not found")})
	@GetMapping
	public ResponseEntity<ResponseStructure<Encounter>> getencounterbyid(@RequestParam int eid){
		return encounterService.getEncounterById(eid);
	}
}
