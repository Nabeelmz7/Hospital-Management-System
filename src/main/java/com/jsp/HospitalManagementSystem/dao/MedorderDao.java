package com.jsp.HospitalManagementSystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.HospitalManagementSystem.Repo.MedorderRepo;
import com.jsp.HospitalManagementSystem.dto.Encounter;
import com.jsp.HospitalManagementSystem.dto.Medorder;

@Repository
public class MedorderDao {
	@Autowired
	private MedorderRepo medorderRepo;
	
	@Autowired
	private EncounterDao encounterDao;
	
	public Medorder saveMedorder(int eid, Medorder medorder) {
		Encounter encounter=encounterDao.getEncounterById(eid);
		medorder.setEncounter(encounter);
		return medorderRepo.save(medorder);	
	}
	
	public Medorder updateMedorder(int id, Medorder medorder) {
		if (medorderRepo.findById(id).isPresent()) {
			medorder.setId(id);
			return medorderRepo.save(medorder);
		}else {
			return null;
		}		
	}
	
	public Medorder deleteMedorder(int id) {
		if (medorderRepo.findById(id).isPresent()) {
			Medorder medorder=medorderRepo.findById(id).get();
			medorderRepo.deleteById(id);
			return medorder;
		}else {
			return null;	
		}
	}
	
	public Medorder getMedorderById(int id) {
		return medorderRepo.findById(id).get();	
	}
}
