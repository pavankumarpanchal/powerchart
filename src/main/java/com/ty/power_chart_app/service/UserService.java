package com.ty.power_chart_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.power_chart_app.dao.UserDao;

import com.ty.power_chart_app.dto.ResponseStructure;
import com.ty.power_chart_app.dto.User;
import com.ty.power_chart_app.exception.EmailNotFoundException;
import com.ty.power_chart_app.exception.IdNotFoundException;
import com.ty.power_chart_app.exception.PhoneNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("Success");
		structure.setData(userDao.saveUser(user));
		return new ResponseEntity<>(structure, HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<User>> findUserById(int id) {
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		User user = userDao.findUserById(id);
		if (user != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(user);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id Not Found");
		}
	}
	public ResponseEntity<ResponseStructure<User>> updateUser(User user) {
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		User user1 =userDao.findUserById(user.getId());
		if (user1 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(userDao.saveUser(user));
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id Not Found");
		}
	}
	public ResponseEntity<ResponseStructure<String>> deleteUserById(int id) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		User user = userDao.deleteUserById(id);
		if (user != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(null);
			return new ResponseEntity<>(structure, HttpStatus.OK);

		} else {
			throw new IdNotFoundException("Id Not Found");
		}

	}
	public ResponseEntity<ResponseStructure<User>> findUserByPhone(long phone) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		User user = userDao.findUserByPhone(phone);
		if (user != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(userDao.saveUser(user));
			return new ResponseEntity<>(structure, HttpStatus.OK);

		} else {
			throw new PhoneNotFoundException("Invalid PhoneNumber");

		}

	}public ResponseEntity<ResponseStructure<User>> findUserByEmail(String email) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		User user = userDao.findUserByEmail(email);
		if (user != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(userDao.saveUser(user));
			return new ResponseEntity<>(structure, HttpStatus.OK);

		} else {
			throw new EmailNotFoundException("Invalid Email Id");
		}

	}
	


}
