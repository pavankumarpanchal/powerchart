package com.ty.foodappservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodappservice.dao.UserDao;
import com.ty.foodappservice.dto.Product;
import com.ty.foodappservice.dto.ResponseStructure;
import com.ty.foodappservice.dto.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<User>> resp;
		responseStructure.setStatus(200);
		responseStructure.setMessage("success");
		responseStructure.setData(userDao.saveUser(user));
		
		resp=new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
		return resp;
	}
}
