package com.ty.foodappservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.foodappservice.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
