package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.models.Orders;
import com.masai.models.Product;
import com.masai.service.OrdersService;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    
	
	@Autowired
	private OrdersService oService;
	
	
	//userAPI
	@PostMapping("/{userId}")
	public ResponseEntity<Orders> createOrder(@PathVariable Long userId){
		Orders ordercreated = oService.createOrders(userId);
		
		return new ResponseEntity<Orders>(ordercreated,HttpStatus.CREATED.OK);
	}
	
	
	//userAPI
	@PutMapping("/{orderId}/products")
	public ResponseEntity<Orders> prodToOrder(@PathVariable Long orderId,@PathVariable Product product){
		Orders orderadded = oService.addprodtoOrders(orderId, product);
		
		return new ResponseEntity<Orders>(orderadded,HttpStatus.CREATED.OK);
	}
	
	
	//userAPI
	@PutMapping("/{orderId}")
	public ResponseEntity<Orders> updOrder(@PathVariable Long orderId,@RequestBody Orders order){
		Orders orderadded = oService.updateOrders(orderId);
		
		return new ResponseEntity<Orders>(orderadded,HttpStatus.CREATED.OK);
	}
	
	
	
	
	
}