package com.jsp.HospitalManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.HospitalManagementSystem.dao.MeditemsDao;
import com.jsp.HospitalManagementSystem.dto.Meditems;
import com.jsp.HospitalManagementSystem.exception.IdNotFoundException;
import com.jsp.HospitalManagementSystem.util.ResponseStructure;

@Service
public class MeditemService {
	@Autowired
	private MeditemsDao meditemsDao;
	
	ResponseStructure<Meditems> responseStructure=new ResponseStructure<Meditems>();
	
	public ResponseEntity<ResponseStructure<Meditems>> saveMeditems(Meditems meditems, int id){
		responseStructure.setMessage("Meditems saved successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(meditemsDao.saveMeditems(id, meditems));
		return new ResponseEntity<ResponseStructure<Meditems>>(responseStructure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Meditems>> updateMeditems(int mid, Meditems meditems) {
		Meditems dbMeditems=meditemsDao.getMeditemsById(mid);
		meditems.setMedorder(dbMeditems.getMedorder());
		Meditems meditems2=meditemsDao.updateMeditems(mid, meditems);
		if (meditems2!=null) {
			responseStructure.setMessage("Meditems updated successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(meditems2);
			return new ResponseEntity<ResponseStructure<Meditems>>(responseStructure, HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Meditems>> deleteMeditems(int mid){
		Meditems meditems=meditemsDao.deletemMeditems(mid);
		if (meditems!=null) {
			responseStructure.setMessage("Meditems deleted successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(meditems);
			return new ResponseEntity<ResponseStructure<Meditems>> (responseStructure, HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}	
	}
	
	public ResponseEntity<ResponseStructure<Meditems>> getMeditemsById(int mid){
		Meditems meditems=meditemsDao.getMeditemsById(mid);
		if (meditems!=null) {
			responseStructure.setMessage("Meditems found successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(meditems);
			return new ResponseEntity<ResponseStructure<Meditems>> (responseStructure, HttpStatus.FOUND);
		}else {
			throw new IdNotFoundException();
		}	
	}
}