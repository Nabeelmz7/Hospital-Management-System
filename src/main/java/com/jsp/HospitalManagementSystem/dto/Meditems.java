package com.jsp.HospitalManagementSystem.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Meditems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mid;
	@NotNull(message = "name cannot be null")
	private String name;
	@NotNull(message = "cost cannot be null")
	private double cost;
	
	@ManyToOne
	private Medorder medorder;
}
