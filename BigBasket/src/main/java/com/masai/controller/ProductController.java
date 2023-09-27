package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.models.Product;
import com.masai.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
  @Autowired
  private ProductService pservice;
  
  
  //adminAPI
  @PostMapping("/{supplierId}")
  public ResponseEntity<Product> addProduct(@PathVariable Long supplierId,@RequestBody Product product){
	  Product addProd = pservice.addProduct(supplierId,product);
	  return new ResponseEntity<Product>(addProd,HttpStatus.CREATED.OK);
  }
  
  

  @GetMapping("/admin")
  public ResponseEntity<List<Product>> allproductsAdmin(@RequestParam int page, @RequestParam int size, @RequestParam String sort ){
	
	 Page<Product> prodPage = pservice.allproductsAdmin(PageRequest.of(page, size,Sort.by(sort)));
	  
	  return new ResponseEntity<List<Product>>(prodPage.getContent(),HttpStatus.CREATED.OK);
  }
  
}