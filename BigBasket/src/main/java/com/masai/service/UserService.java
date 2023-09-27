package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.NotFoundException;
import com.masai.models.Orders;
import com.masai.models.Product;
import com.masai.models.User;
import com.masai.repository.OrdersRepository;
import com.masai.repository.UserRepository;

@Service
public class UserService {
	private UserRepository uRepo;

	private OrdersRepository oRepo;
	
	@Autowired
	public UserService(UserRepository uRepo, OrdersRepository oRepo) {
		super();
		this.uRepo = uRepo;
		this.oRepo = oRepo;
	}

	public User registerUser(User user) {
		return uRepo.save(user);
	}
	
	
	
	public List<Orders> getOrdersHistory(Long UserId){
		User user = uRepo.findById(UserId).orElseThrow(()-> new NotFoundException("User not found"));
		
		return oRepo.findByUserUserIdOrderByDeliveryDateDesc(UserId);
	}

	public List<Product> getRecomProducts(Long userId) {
		User user = uRepo.findById(userId).orElseThrow(()-> new NotFoundException("Invalid User Id"));
		List<Orders> order = user.getOrders();
		
		return null;
	}
	
	

}
