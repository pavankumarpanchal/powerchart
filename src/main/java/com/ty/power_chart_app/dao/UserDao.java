package com.ty.power_chart_app.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.power_chart_app.dto.User;
import com.ty.power_chart_app.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User findUserById(int id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public User updateUserById(int id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isPresent()) {
			return userRepository.save(optional.get());
		} else {
			return null;
		}
	}

	public User deleteUserById(int id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isPresent()) {
			userRepository.delete(optional.get());
		} else {
			return null;
		}
		return null;
	}

	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User findUserByPhone(long phone) {
		return userRepository.findByPhone(phone);
	}
}
