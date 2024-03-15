package com.jsp.HospitalManagementSystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.HospitalManagementSystem.Repo.MeditemsRepo;
import com.jsp.HospitalManagementSystem.dto.Meditems;
import com.jsp.HospitalManagementSystem.dto.Medorder;

@Repository
public class MeditemsDao {
	@Autowired
	private MeditemsRepo meditemsRepo;
	
	@Autowired
	private MedorderDao medorderDao;
	
	public Meditems saveMeditems(int mid, Meditems meditems) {
		Medorder medorder=medorderDao.getMedorderById(mid);
		meditems.setMedorder(medorder);
		return meditemsRepo.save(meditems);
	}
	
	public Meditems updateMeditems(int mid, Meditems meditems) {
		if (meditemsRepo.findById(mid).isPresent()) {
			meditems.setMid(mid);
			return meditemsRepo.save(meditems);
		}else {
			return null;	
		}
	}
	
	public Meditems deletemMeditems(int mid) {
		if (meditemsRepo.findById(mid).isPresent()) {
			Meditems meditems=meditemsRepo.findById(mid).get();
			meditemsRepo.deleteById(mid);
			return meditems;
		}else {
			return null;
		}
	}
	
	public Meditems getMeditemsById(int mid) {
		return meditemsRepo.findById(mid).get();	
	}
}
