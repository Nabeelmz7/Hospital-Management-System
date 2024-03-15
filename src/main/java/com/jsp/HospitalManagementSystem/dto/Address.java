package com.jsp.HospitalManagementSystem.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Aid;
	@NotNull(message = "state cannot be null")
	private String state;
	@NotNull (message = "city cannot be null")
	private String city;
	@NotNull(message = "pincode cannot be null")
	private long pincode;
}
