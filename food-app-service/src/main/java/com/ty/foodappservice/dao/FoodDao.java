package com.ty.foodappservice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodappservice.dto.FoodOrder;
import com.ty.foodappservice.repository.FoodOrderRepository;

@Repository
public class FoodDao {
	@Autowired
	private FoodOrderRepository foodOrderRepository;

	public FoodOrder placeOrder(FoodOrder foodorder) {
		return foodOrderRepository.save(foodorder);
	}
}
