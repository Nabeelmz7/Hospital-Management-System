package com.jsp.HospitalManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.HospitalManagementSystem.dao.MedorderDao;
import com.jsp.HospitalManagementSystem.dto.Medorder;
import com.jsp.HospitalManagementSystem.exception.IdNotFoundException;
import com.jsp.HospitalManagementSystem.util.ResponseStructure;

@Service
public class MedorderService {
	@Autowired
	private MedorderDao medorderDao;
	
	ResponseStructure<Medorder> responseStructure=new ResponseStructure<Medorder>();
	
	public ResponseEntity<ResponseStructure<Medorder>> saveMedorder(Medorder medorder, int eid){
		responseStructure.setMessage("Medorder saved successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(medorderDao.saveMedorder(eid, medorder));
		return new ResponseEntity<ResponseStructure<Medorder>>(responseStructure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Medorder>> updateMedorder(int id, Medorder medorder){
		Medorder dbMedorder=medorderDao.getMedorderById(id);
		medorder.setEncounter(dbMedorder.getEncounter());
		Medorder medorder2=medorderDao.updateMedorder(id, medorder);
		responseStructure.setMessage("Medorder updated successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(medorder2);
		return new ResponseEntity<ResponseStructure<Medorder>>(responseStructure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Medorder>> deleteMedorder(int id){
		Medorder medorder=medorderDao.deleteMedorder(id);
		if (medorder!=null) {
			responseStructure.setMessage("Medorder deleted successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(medorder);
			return new ResponseEntity<ResponseStructure<Medorder>>(responseStructure, HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Medorder>> getMedorderById(int id){
		Medorder medorder=medorderDao.getMedorderById(id);
		if (medorder!=null) {
			responseStructure.setMessage("Medorder data found successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(medorder);
			return new ResponseEntity<ResponseStructure<Medorder>>(responseStructure, HttpStatus.FOUND);
		}else {
			throw new IdNotFoundException();
		}
	}
}
