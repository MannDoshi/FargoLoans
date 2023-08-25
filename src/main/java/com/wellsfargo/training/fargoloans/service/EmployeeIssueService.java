package com.wellsfargo.training.fargoloans.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.fargoloans.model.EmployeeIssue;
import com.wellsfargo.training.fargoloans.repository.EmployeeIssueRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeIssueService {

	@Autowired
	private EmployeeIssueRepository EIrepo;
	
	public EmployeeIssue saveEmployeeIssue(EmployeeIssue e) {
		return EIrepo.save(e); //invokes predefined save() method of JPA Repository
	}
   
   public Optional<EmployeeIssue> getSingleEmployeeIssue(long id){
		return EIrepo.findById(id);
	}
	
	public void deleteEmployeeIssue(long id)
	{
		EIrepo.deleteById(id);
	}

	public Optional<EmployeeIssue> getEmployeeIssue(Long id) {
		
		return EIrepo.findById(id);
	}
	
}
