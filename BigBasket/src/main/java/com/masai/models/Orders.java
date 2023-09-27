package com.masai.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	
	@ManyToOne
	private User users;
	
	@OneToMany
	private List<Product> products;
	
	private LocalDate orderDate;
	
	private LocalDate deliveryDate;
	
	private double totalAmount;
	
	public Orders(LocalDate orderDate, LocalDate deliveryDate, double totalAmount) {
		super();
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.totalAmount = totalAmount;
	}
	
	public Orders() {}
}
