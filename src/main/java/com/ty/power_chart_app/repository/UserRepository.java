package com.ty.power_chart_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.power_chart_app.dto.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmail(String email);
	User findByPhone(long phone);
}
