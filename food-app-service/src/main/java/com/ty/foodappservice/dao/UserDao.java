package com.ty.foodappservice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodappservice.dto.User;
import com.ty.foodappservice.repository.UserRepository;

@Repository
public class UserDao {
	@Autowired
	private UserRepository userRepository;
	public User saveUser(User user)
	{
		return userRepository.save(user);
	}
}
