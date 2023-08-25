package com.wellsfargo.training.fargoloans.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.fargoloans.model.EmployeeCard;
import com.wellsfargo.training.fargoloans.repository.EmployeeCardRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeCardService {

	@Autowired
	private EmployeeCardRepository ECrepo;
	
	public EmployeeCard saveEmployeeCard(EmployeeCard e) {
		return ECrepo.save(e); //invokes predefined save() method of JPA Repository
	}
   
   public Optional<EmployeeCard> getSingleEmployeeCard(long id){
		return ECrepo.findById(id);
	}
	
	public void deleteEmployeeCard(long id)
	{
		ECrepo.deleteById(id);
	}

	public Optional<EmployeeCard> getEmployeeCard(Long id) {
		
		return ECrepo.findById(id);
	}
	
}
