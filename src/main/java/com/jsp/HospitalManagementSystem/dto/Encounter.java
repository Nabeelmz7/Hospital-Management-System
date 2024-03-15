package com.jsp.HospitalManagementSystem.dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Eid;
	@NotNull(message = "reason cannot be null")
	private String reason;
	@NotNull(message = "cost cannot be null")
	private double cost;
	
	@ManyToOne
	private Person person;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Branch> list;
}
