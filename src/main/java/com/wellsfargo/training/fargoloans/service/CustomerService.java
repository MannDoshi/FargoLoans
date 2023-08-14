package com.wellsfargo.training.fargoloans.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.fargoloans.model.Customer;
import com.wellsfargo.training.fargoloans.repository.CustomerRepository;

import jakarta.transaction.Transactional;

/*
 * A service layer is an additional layer in an MVC application that 
 * mediates communication between a controller and repository layer. 
 * The service layer contains business logic. 
 * In particular, it contains validation logic. */

/* @Service annotation allows developers to add business functionalities.
 *  @Transactional annotation allows to manage Database transactions efficiently */

@Service
@Transactional
public class CustomerService {
	
	@Autowired // Dependency Injection - Loose Coupling 
	private CustomerRepository crepo;
	
	public Customer saveCustomer(Customer c) {
		return crepo.save(c); //invokes save() method of Jpa Repository
	}
	
	
	
	public List<Customer> listAll(){
		return crepo.findAll(); //defined in JPARepo
	}
	
	public Optional<Customer> loginCustomer(String email){
		return crepo.findByEmail(email);
	}
}
