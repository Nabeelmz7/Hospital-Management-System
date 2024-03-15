package com.jsp.HospitalManagementSystem.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "name cannot be null")
	private String name;
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	private long phone;
	@NotNull(message = "manager cannot be null")
	private String manager;
		
	@ManyToOne
	private Hospital hospital;
	
	@OneToOne
	private Address address;
}
