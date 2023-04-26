package com.ty.foodappservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.foodappservice.dto.FoodOrder;
import com.ty.foodappservice.dto.ResponseStructure;
import com.ty.foodappservice.service.FoodOrderService;

@RestController
@RequestMapping("/place")
public class FoodOrderController {
	@Autowired
	private FoodOrderService foodOrderService;

	@PostMapping
	public ResponseEntity<ResponseStructure<FoodOrder>> placeOrder(@RequestBody FoodOrder  foodorder) {
		return foodOrderService.placeOrder(foodorder);
	}
}