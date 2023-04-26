package com.ty.foodappservice.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodappservice.dto.Product;
import com.ty.foodappservice.repository.ProductRepository;

@Repository
public class ProductDao {
	@Autowired
	private ProductRepository productRepository;

	public Product saveProduct(Product product) {
 return productRepository.save(product);
	
	}
	public List<Product> getAllProduct()
	{
		return productRepository.findAll();
	}
	public Product getProductById(int id)
	{
		Optional<Product> opt=productRepository.findById(id);
		if(opt.isPresent())
		{
			return opt.get();
		}
		else
		{
			return null;
		}
	}
	public boolean deleteProductById(int id)
	{
		Optional<Product> opt=productRepository.findById(id);
		if(opt.isPresent())
		{
			productRepository.delete(opt.get());
			return true;
		}
		else
		{
			return false;
		}

	}
	public Product updateProduct(Product product) {
		 return productRepository.save(product);
			
			}

}
