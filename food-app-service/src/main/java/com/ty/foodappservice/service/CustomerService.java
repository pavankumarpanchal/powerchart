package com.ty.foodappservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodappservice.dto.ResponseStructure;
import com.ty.foodappservice.exception.EmailNotFoundException;
import com.ty.foodappservice.exception.PhoneNumberNotFoundException;
import com.ty.foodappservice.dao.CustomerDao;
import com.ty.foodappservice.dto.Customer;

@Service
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer)
	{
		ResponseEntity<ResponseStructure<Customer>> resp;
		 ResponseStructure<Customer> responseStructure=new ResponseStructure<>();

		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(customerDao.saveCustomer(customer));
		resp=new ResponseEntity<ResponseStructure<Customer>>(HttpStatus.OK);
		return resp;
	
	}
	public ResponseEntity<ResponseStructure<Customer>> findCustomerByEmail(String email)
	{
		ResponseEntity<ResponseStructure<Customer>> resp;

		
		 ResponseStructure<Customer> responseStructure=new ResponseStructure<>();
		 
		Customer customer=customerDao.findCustomerByEmail(email);
		
		if(customer!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(customer);
			return resp=new ResponseEntity<ResponseStructure<Customer>>(HttpStatus.OK);

		}
		else
		{
			throw new EmailNotFoundException("email not found"+email+"");
		}
		 
	}
	public ResponseEntity<ResponseStructure<Customer>> findCustomerByPhone(long phone)
	{
		ResponseEntity<ResponseStructure<Customer>> resp;

		 ResponseStructure<Customer> responseStructure=new ResponseStructure<>();

		 Customer customer=customerDao.findCustomerByPhone(phone);
		 if(customer!=null)
			{
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setMessage("success");
				responseStructure.setData(customer);
				return resp=new ResponseEntity<ResponseStructure<Customer>>(HttpStatus.OK);

			}
			else
			{
				
              throw new PhoneNumberNotFoundException("Phone Number :"+phone+"  "+" Not Found");
			}
		
	}
	
}
