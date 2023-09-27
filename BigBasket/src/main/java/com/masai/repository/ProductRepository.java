package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
