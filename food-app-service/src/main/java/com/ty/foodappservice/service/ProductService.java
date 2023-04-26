package com.ty.foodappservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodappservice.dao.ProductDao;
import com.ty.foodappservice.dto.Product;
import com.ty.foodappservice.dto.ResponseStructure;
import com.ty.foodappservice.exception.IdNotFoundException;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;

	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		ResponseEntity<ResponseStructure<Product>> resp;
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();

		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(productDao.saveProduct(product));
		resp=new ResponseEntity<ResponseStructure<Product>>(HttpStatus.OK);

		return resp;
	}

	public ResponseEntity<ResponseStructure<List<Product>>> getAllProduct() {
		
		ResponseEntity<ResponseStructure<List<Product>>> resp;
		ResponseStructure<List<Product>> responseStructure = new ResponseStructure<>();
		List<Product> product = productDao.getAllProduct();
		if (!product.isEmpty()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(product);
			resp=new ResponseEntity<ResponseStructure<List<Product>>>(HttpStatus.OK);

		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Products not found :" + product + ", ");
			responseStructure.setData(product);
			resp=new ResponseEntity<ResponseStructure<List<Product>>>(HttpStatus.NOT_FOUND);

		}

		return resp;
	}

	public ResponseEntity<ResponseStructure<Product>> getProductById(int id) {
		
		ResponseEntity<ResponseStructure<Product>> resp;
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		Product product = productDao.getProductById(id);

		if (product != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(product);
	         resp=new ResponseEntity<ResponseStructure<Product>>(HttpStatus.OK);

		} else {
			throw new IdNotFoundException("not found id : " + id+""); 

		}

		return resp;
	}

	public ResponseEntity<ResponseStructure<String>> deleteProductById(int id) {
		
		ResponseEntity<ResponseStructure<String>> resp;
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		if (productDao.deleteProductById(id)) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData("product has been deleted ");
			resp=new ResponseEntity<ResponseStructure<String>>(HttpStatus.OK);

		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("ID :" + id + "not deleted");
			resp=new ResponseEntity<ResponseStructure<String>>(HttpStatus.NOT_FOUND);

		}

		return resp;
	}

	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product) {
		ResponseEntity<ResponseStructure<Product>> resp;
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(productDao.saveProduct(product));
		resp=new ResponseEntity<ResponseStructure<Product>>(HttpStatus.OK);

		return resp;
	}
}
