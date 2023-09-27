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
public class OrdersService {

	private UserRepository uRepo;

	private OrdersRepository oRepo;

	@Autowired
	public OrdersService(UserRepository uRepo, OrdersRepository oRepo) {
		
		this.uRepo = uRepo;
		this.oRepo = oRepo;
	}

	public Orders createOrders(Long userId) {
		User user = uRepo.findById(userId).orElseThrow(()-> new NotFoundException("User not found"));
		
		Orders Orders = new Orders();
		Orders.setUsers(user);
		
		return oRepo.save(Orders);
	}
	
	public Orders addprodtoOrders(Long OrdersId,Product product) {
		Orders Orders = oRepo.findById(OrdersId).orElseThrow(()-> new NotFoundException("User not found"));
		
		if(Orders.getProducts().contains(product)) {
			throw new NotFoundException("Product is already there");
		}
		
		Orders.getProducts().add(product);
		return oRepo.save(Orders);
	}
	
	public Orders updateOrders(Long OrdersId) {
		Orders Orders = oRepo.findById(OrdersId).orElseThrow(()-> new NotFoundException("User not found"));
		
		return oRepo.save(Orders);
	}
 
	public List<Orders> OrdersHistory(Long userId){
		return oRepo.findByUserUserIdOrderByDeliveryDateDesc(userId);
	}
	
}
