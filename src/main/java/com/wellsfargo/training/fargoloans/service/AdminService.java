package com.wellsfargo.training.fargoloans.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.fargoloans.model.Admin;
import com.wellsfargo.training.fargoloans.repository.AdminRepository;

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
public class AdminService {
	
	@Autowired // Dependency Injection - Loose Coupling 
	private AdminRepository arepo;
	
	public Admin saveAdmin(Admin a) {
		return arepo.save(a); //invokes save() method of Jpa Repository
	}
	
	public List<Admin> listAll(){
		
		return arepo.findAll(); //defined in JPARepo
	}
}