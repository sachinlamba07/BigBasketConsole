package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
