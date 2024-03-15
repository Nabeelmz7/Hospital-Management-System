package com.jsp.HospitalManagementSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.HospitalManagementSystem.dao.BranchDao;
import com.jsp.HospitalManagementSystem.dao.EncounterDao;
import com.jsp.HospitalManagementSystem.dao.PersonDao;
import com.jsp.HospitalManagementSystem.dto.Branch;
import com.jsp.HospitalManagementSystem.dto.Encounter;
import com.jsp.HospitalManagementSystem.dto.Person;
import com.jsp.HospitalManagementSystem.exception.IdNotFoundException;
import com.jsp.HospitalManagementSystem.util.ResponseStructure;

@Service
public class EncounterService {
	@Autowired
	private EncounterDao encounterDao;
	@Autowired
	private BranchDao branchDao;
	@Autowired
	private PersonDao personDao;
	
	ResponseStructure<Encounter> responseStructure=new ResponseStructure<Encounter>();
	
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter, int pid, int bid){
		Person person=personDao.getPersonById(pid);
		Branch branch=branchDao.getBranchById(bid);
		
		encounter.setPerson(person);
		List<Branch> list=new ArrayList<>();
		list.add(branch);
		encounter.setList(list);
		responseStructure.setMessage("Encounter saved successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(encounterDao.saveEncounter(encounter));
		return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter( int eid, Encounter encounter, int bid){
		Encounter dbEncounter=encounterDao.getEncounterById(eid);
		Branch branch=branchDao.getBranchById(bid);
		
		List<Branch> list=dbEncounter.getList();
		encounter.setList(dbEncounter.getList());
		encounter.setPerson(dbEncounter.getPerson());
		
		responseStructure.setMessage("Branch updated successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(encounterDao.updateEncounter(eid, encounter));
		return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(int eid){
		Encounter encounter=encounterDao.deleteEncounter(eid);
		if (encounter!=null) {
			responseStructure.setMessage("Encounter deleted successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(encounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(int eid){
		Encounter encounter=encounterDao.getEncounterById(eid);
		if (encounter!=null) {
			responseStructure.setMessage("Encounter found successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(encounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.FOUND);
		}else {
			throw new IdNotFoundException();
		}
	}
}
