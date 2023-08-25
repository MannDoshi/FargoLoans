package com.wellsfargo.training.fargoloans.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.fargoloans.model.Employee;
import com.wellsfargo.training.fargoloans.repository.EmployeeRepository;


import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {
	
   @Autowired
   private EmployeeRepository Erepo;
   
   public Employee saveEmployee(Employee e) {
		return Erepo.save(e); //invokes predefined save() method of JPA Repository
	}
   
   public Optional<Employee> getSingleProduct(long id){
		return Erepo.findById(id);
	}
	
	public void deleteProduct(long id)
	{
		Erepo.deleteById(id);
	}

	public Optional<Employee> getEmployee(Long id) {
		
		return Erepo.findById(id);
	}	
	public List<Employee> getEmployees() {
		
		return Erepo.findAll();
	}
	
}
