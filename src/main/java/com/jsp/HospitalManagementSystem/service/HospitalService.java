package com.jsp.HospitalManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.HospitalManagementSystem.dao.HospitalDao;
import com.jsp.HospitalManagementSystem.dto.Hospital;
import com.jsp.HospitalManagementSystem.exception.IdNotFoundException;
import com.jsp.HospitalManagementSystem.util.ResponseStructure;

@Service
public class HospitalService {
	
	@Autowired
	private HospitalDao hospitalDao;
	
	ResponseStructure<Hospital> responseStructure=new ResponseStructure<Hospital>();
	
	public ResponseEntity<ResponseStructure<Hospital>> savehospital(Hospital hospital){
		responseStructure.setMessage("Hospital data saved successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(hospitalDao.saveHospital(hospital));
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> updatehospital(int hid, Hospital hospital){
		Hospital dbHospital=hospitalDao.updateHospital(hid, hospital);
		if (dbHospital!=null) {
			responseStructure.setMessage("Hospital data updated successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dbHospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}	
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> deletehospital(int hid){
		Hospital hospital=hospitalDao.deleteHospital(hid);
		if (hospital!=null) {
			responseStructure.setMessage("Hospital data deleted successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> gethospitalbyid(int id){
		Hospital hospital=hospitalDao.getHospitalById(id);
		if (hospital!=null) {
			responseStructure.setMessage("Hospital found successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>> (responseStructure, HttpStatus.FOUND);
		}else {
			throw new IdNotFoundException();
		}		
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalByEmail(String email){
		Hospital hospital=hospitalDao.getHospitalByEmail(email);
		if (hospital!=null) {
			responseStructure.setMessage("Hospital found successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.FOUND);
		}else {
			throw new IdNotFoundException();
		}	
	}
}
