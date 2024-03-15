package com.jsp.HospitalManagementSystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.HospitalManagementSystem.dto.Medorder;

public interface MedorderRepo extends JpaRepository<Medorder, Integer> {

}
