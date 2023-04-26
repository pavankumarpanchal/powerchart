package com.ty.foodappservice.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.foodappservice.dto.Customer;
import com.ty.foodappservice.repository.CustomerRepository;

@Repository
public class CustomerDao {
@Autowired
private CustomerRepository customerRepository;

	public Customer saveCustomer(Customer customer)
	{
		return customerRepository.save(customer);
	}
	public Customer findCustomerByEmail(String email)
	{
		Optional<Customer> optional=customerRepository.findByEmail(email);
		if(optional.isPresent())
		{
			return optional.get();
		}
		else
		{
			return null;
		}
	}
	public Customer findCustomerByPhone(long phone)
	{
		Optional<Customer> customer= customerRepository.findByPhone(phone);
		 
		if(customer.isPresent())
		{
			return customer.get();
		}
		else
		{
			return null;
		}
	}
}
