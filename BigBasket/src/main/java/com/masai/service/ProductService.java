package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.masai.exception.NotFoundException;
import com.masai.models.Product;
import com.masai.models.Supplier;
import com.masai.repository.ProductRepository;
import com.masai.repository.SupplierRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository prepo;
	
	@Autowired
	private SupplierRepository srepo;
	
	public Product addProduct(Long supplierId, Product product) {
		Optional<Supplier> suplier = srepo.findById(supplierId);
		if(!suplier.isPresent()) {
			throw new NotFoundException("suplier not found");
			
		}
		
		return prepo.save(product);
		
	}
	
	public Page<Product> allproductsAdmin(Pageable pageable){
		return prepo.findAll( pageable);
	}
	
	
	
}
