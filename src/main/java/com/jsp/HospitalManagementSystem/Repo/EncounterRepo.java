package com.jsp.HospitalManagementSystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.HospitalManagementSystem.dto.Encounter;

public interface EncounterRepo extends JpaRepository<Encounter, Integer> {
	
}
