package com.ty.foodappservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodappservice.dao.FoodDao;
import com.ty.foodappservice.dto.FoodOrder;
import com.ty.foodappservice.dto.Item;
import com.ty.foodappservice.dto.ResponseStructure;

@Service
public class FoodOrderService {
	@Autowired
	private FoodDao foodDao;

	public ResponseEntity<ResponseStructure<FoodOrder>> placeOrder(FoodOrder foodorder) {
		ResponseEntity<ResponseStructure<FoodOrder>> resp;
		ResponseStructure<FoodOrder> responseStructure=new ResponseStructure<>();
		double total = 0;
		List<Item> items = foodorder.getItem();
		for (Item item : items) {
			total += item.getQuantity() * item.getCost();
			item.setFoodorder(foodorder);
		}
		foodorder.setTotalcost(total);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure. setData(foodDao.placeOrder(foodorder));
		resp =new ResponseEntity<ResponseStructure<FoodOrder>>(HttpStatus.OK);
		 
		 return resp;
	}
}
