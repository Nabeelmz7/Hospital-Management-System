package com.jsp.HospitalManagementSystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.HospitalManagementSystem.Repo.HospitalRepo;
import com.jsp.HospitalManagementSystem.dto.Hospital;

@Repository
public class HospitalDao {
	
	@Autowired
	private HospitalRepo hospitalRepo;
	
	public Hospital saveHospital(Hospital hospital) {
		return hospitalRepo.save(hospital);		
	}
	
	public Hospital updateHospital(int Hid, Hospital hospital) {
		if (hospitalRepo.findById(Hid).isPresent()) {
			hospital.setHid(Hid);
			return hospitalRepo.save(hospital);
		}else {
			return null;
		}
	}
	
	public Hospital deleteHospital(int Hid) {
		if (hospitalRepo.findById(Hid).isPresent()) {
			Hospital hospital=hospitalRepo.findById(Hid).get();
			hospitalRepo.deleteById(Hid);
			return hospital;
		}else {
			return null;
		}
	}
	
	public Hospital getHospitalById(int Hid) {
		Hospital hospital = hospitalRepo.findById(Hid).get();
		return hospital;
		
	}
	
	public Hospital getHospitalByEmail(String email) {
		return hospitalRepo.findHospitalbyemail(email);
	}
}
