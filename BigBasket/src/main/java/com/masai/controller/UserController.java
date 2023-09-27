package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.models.Orders;
import com.masai.models.Product;
import com.masai.models.User;
import com.masai.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService uService;
	
	
	//userAPI
	@PostMapping("/user")
	public ResponseEntity<User> registerUser(@RequestBody User user){
		User saveUser = uService.registerUser(user);
		return new ResponseEntity<User>(saveUser,HttpStatus.OK);
	}
	
	
	//userAPI
	@GetMapping("/{userId}/Orderss")
	public ResponseEntity<List<Orders>> ordHistory(@PathVariable Long userId){
		List<Orders> OrdersHistory = uService.getOrdersHistory(userId);
		return new ResponseEntity<List<Orders>> (OrdersHistory,HttpStatus.OK);
	}
	
	//userAPI
	@GetMapping("/{userId}/recomProd")
	public ResponseEntity<List<Product>> recomProduct(@PathVariable Long userId){
		List<Product> recomendedProduct = uService.getRecomProducts(userId);
		return new ResponseEntity<List<Product>>  (recomendedProduct,HttpStatus.OK);
	}
	
}