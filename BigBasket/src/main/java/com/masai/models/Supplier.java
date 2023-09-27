package com.masai.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long supplierId;
	private String name;
	private String email;
	
	public Supplier() {
		
	}
	
	public Supplier(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

}
