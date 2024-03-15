package com.jsp.HospitalManagementSystem.controller;

import java.util.List;

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

import com.jsp.HospitalManagementSystem.dto.Branch;
import com.jsp.HospitalManagementSystem.service.BranchService;
import com.jsp.HospitalManagementSystem.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/branch")
public class BranchController {
	
	@Autowired
	private BranchService branchService;
	
	@ApiOperation(value = "save branch", notes="Api is used to save the branch")
	@ApiResponses(value = {@ApiResponse(code=200, message="successfully saved")})
	@PostMapping
	public ResponseEntity<ResponseStructure<Branch>> savebranch(@RequestParam int hid, @RequestParam int aid, @RequestBody Branch branch){
		return branchService.saveBranch(hid, aid, branch);
	}
	
	@ApiOperation(value = "Update branch",notes = "Api is used to update the branch")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "succesfully updated"),
			@ApiResponse(code = 404,message = "id not found")})
	@PutMapping
	public ResponseEntity<ResponseStructure<Branch>> updatebranch(@RequestParam int bid, @RequestBody Branch branch){
		return branchService.updateBranch(bid, branch);	
	}
	
	@ApiOperation(value = "Delete branch",notes = "Api is used to delete the branch")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "succesfully deleted"),
			@ApiResponse(code = 404,message = "id not found")})
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Branch>> deletebranch(@RequestParam int bid){
		return branchService.deleteBranchById(bid);
	}
	
	@ApiOperation(value = "Get branch By Id",notes = "Api is used to find the branch based on id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "succesfully found"),
			@ApiResponse(code = 404,message = "id not found")})
	@GetMapping
	public ResponseEntity<ResponseStructure<Branch>> getbranchbyid(@RequestParam int bid){
		return branchService.getBranchById(bid);
	}
	
	@ApiOperation(value = "Get branch By Hospital Id",notes = "Api is used to find the branch based on hospital id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "succesfully found"),
			@ApiResponse(code = 404,message = "id not found")})
	@GetMapping("/getbranchbyhospital")
	public ResponseEntity<ResponseStructure<List<Branch>>> getbranchbyhospitalid(@RequestParam int hid){
		return branchService.getBranchByHospitalId(hid);
	}
}
