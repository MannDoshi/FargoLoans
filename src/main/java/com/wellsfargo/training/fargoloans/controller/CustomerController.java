/*Spring RestController annotation is used to create RESTful web services using Spring MVC. 
 * Spring RestController takes care of mapping request data to the defined request handler method. 
 * Once response body is generated from the handler method, it converts it to JSON or XML response. 
 * 
 * @RequestMapping - maps HTTP request with a path to a controller 
 * */
package com.wellsfargo.training.fargoloans.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.fargoloans.model.Customer;
import com.wellsfargo.training.fargoloans.service.CustomerService;
import com.wellsfargo.training.fargoloans.exception.ResourceNotFoundException;

@RestController
@RequestMapping(value="/api")
public class CustomerController {

	@Autowired
	private CustomerService cservice;

	
	/* ResponseEntity represents an HTTP response, including headers, body, and status.
	 *  @RequestBody annotation automatically deserializes the JSON into a Java type
	 *  */
	
	//Open PostMan, make a POST Request - http://localhost:8085/pms/api/products/
    //Select body -> raw -> JSON 
    //Insert JSON product object.
	
	@PostMapping("/customers")
	public Customer saveCustomer(@Validated @RequestBody Customer customer) {
		
		Customer c = cservice.saveCustomer(customer);
		return customer;
	}
	
	//Open PostMan, make a GET Request - http://localhost:8085/pms/api/products/
    //Select body -> raw -> JSON
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		
		return cservice.listAll();
	}
	
	@PostMapping("/login")
	public Boolean loginCustomer(@Validated @RequestBody Customer customer) throws ResourceNotFoundException {
		Boolean a=false;
		String email=customer.getEmail();
		String password=customer.getPassword();
		
		Customer c = cservice.loginCustomer(email).orElseThrow(() -> new ResourceNotFoundException("Customer not found for id :: "));
		
		if(email.equals(c.getEmail()) && password.equals(c.getPassword())){
			a=true;
		}
		return a;
	}
}