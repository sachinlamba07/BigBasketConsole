package com.masai.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	private String name;
	private long supplierId;
	private long categoryId;
	private double price;
	
	public Product(String name, long supplierId, long categoryId, double price) {
		super();
		this.name = name;
		this.supplierId = supplierId;
		this.categoryId = categoryId;
		this.price = price;
	}
}
