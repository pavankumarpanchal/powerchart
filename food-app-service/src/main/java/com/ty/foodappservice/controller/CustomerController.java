package com.ty.foodappservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.foodappservice.dto.Customer;
import com.ty.foodappservice.dto.ResponseStructure;
import com.ty.foodappservice.service.CustomerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
//@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	
	@ApiOperation(value="save customer" ,notes="input is customer object and return same obj with id")
	@ApiResponses(value= {@ApiResponse(code=201,message = "successfully saved"),
			@ApiResponse(code=404,message="input mismatch")})
	@PostMapping(value="/customers",consumes = {MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE})
	
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody @Valid Customer customer) {
		return customerService.saveCustomer(customer);
	}
	@ApiOperation(value="find customer by email" ,notes="we can fetch the student object by passing email")
	@ApiResponses(value= {@ApiResponse(code=404,message = " Email Not Found Exception"),
			@ApiResponse(code=404,message="input mismatch")})
	@GetMapping(value="/customers/{email}",consumes = {MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<Customer>> findCustomerByEmail(@PathVariable  String email)
	{
		return customerService.findCustomerByEmail(email);
	}
	@ApiOperation(value="find customer by phone number" ,notes="we can fetch the student object by passing phone number")
	@ApiResponses(value= {@ApiResponse(code=404,message = "phone number not found exception"),
			@ApiResponse(code=404,message="input mismatch")})
	@GetMapping(value="/customers",consumes = {MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<Customer>> findCustomerByPhone( @RequestParam long phone)
	{
		return customerService.findCustomerByPhone(phone);
	}

}
