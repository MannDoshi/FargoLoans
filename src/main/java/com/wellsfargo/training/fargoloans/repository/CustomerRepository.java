package com.wellsfargo.training.fargoloans.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.training.fargoloans.model.Customer;

/**
 * 

 * JPA Repository is mainly used for managing the data in a Spring Boot Application. 
 * JpaRepository is particularly a JPA specific extension for Repository.
 * Jpa Repository contains the APIs for basic CRUD operations, the APIS for 
 * pagination, and the APIs for sorting.
 * This Layer interacts with Database
 */
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	//Long is data type of id field of Customer class
	/*
     * This interface has save(),findAll(),findById(),deleteById(),count()
       etc.. inbuilt methods of jpa repository for various database operations.
       This interface will be implemented by class automatically
    */	
	public Optional<Customer> findByEmail(String email);
}
