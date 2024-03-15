package com.jsp.HospitalManagementSystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.HospitalManagementSystem.dto.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

}
