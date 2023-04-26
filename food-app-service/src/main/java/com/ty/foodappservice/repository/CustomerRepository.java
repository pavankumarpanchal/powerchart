package com.ty.foodappservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.foodappservice.dto.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	Optional<Customer> findByEmail(String email);
	Optional<Customer> findByPhone(long phone);


}
