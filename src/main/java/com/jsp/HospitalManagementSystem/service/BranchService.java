package com.jsp.HospitalManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.HospitalManagementSystem.dao.BranchDao;
import com.jsp.HospitalManagementSystem.dto.Branch;
import com.jsp.HospitalManagementSystem.exception.IdNotFoundException;
import com.jsp.HospitalManagementSystem.util.ResponseStructure;

@Service
public class BranchService {
	@Autowired
	private BranchDao branchDao;
	
	ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
	
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(int hid, int aid, Branch branch){
		responseStructure.setMessage("Branch saved successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(branchDao.saveBranch(hid, aid, branch)); 
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int bid, Branch branch){
		Branch dbBranch=branchDao.updateBranch(bid, branch);
		if (dbBranch!=null) {
			responseStructure.setMessage("Branch data updated successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dbBranch);
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(int bid){
		Branch branch=branchDao.deleteBranch(bid);
		if (branch!=null) {
			responseStructure.setMessage("Branch deleted successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(int id){
		Branch branch=branchDao.getBranchById(id);
		if (branch!=null) {
			responseStructure.setMessage("Branch found successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
		}else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Branch>>> getBranchByHospitalId(int hid){
		ResponseStructure<List<Branch>> responseStructure=new ResponseStructure<List<Branch>>();
		List<Branch> branch=branchDao.getBranchByHospitalId(hid);
		if (branch!=null) {
			responseStructure.setMessage("Branch found successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(branch);
			return new ResponseEntity<ResponseStructure<List<Branch>>>(responseStructure, HttpStatus.FOUND);
		}else {
			throw new IdNotFoundException();
		}
	}
}
