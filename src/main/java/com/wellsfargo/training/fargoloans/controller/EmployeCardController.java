package com.wellsfargo.training.fargoloans.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.fargoloans.dataviews.EmployeeDetails;
import com.wellsfargo.training.fargoloans.exception.ResourceNotFoundException;
import com.wellsfargo.training.fargoloans.model.Employee;
import com.wellsfargo.training.fargoloans.model.EmployeeCard;
import com.wellsfargo.training.fargoloans.repository.EmployeeCardRepository;
import com.wellsfargo.training.fargoloans.repository.EmployeeRepository;
import com.wellsfargo.training.fargoloans.service.EmployeeCardService;
import com.wellsfargo.training.fargoloans.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value="/api/employeecard")
public class EmployeCardController {
	@Autowired
	private EmployeeCardService ecservice;
	
//	@Autowired
	private EmployeeCardRepository employeeCardRepository;
	
	
	@PostMapping("/")
	public EmployeeCard addEmployeeCard(@Validated @RequestBody EmployeeCard ec) {
		EmployeeCard e2 = ecservice.saveEmployeeCard(ec);
		return e2;
	}
	
	@GetMapping("/all")
	  public ResponseEntity<List<EmployeeCard>> allEmployeeCard() {
		  return new ResponseEntity<List<EmployeeCard>>(employeeCardRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	 public Optional<EmployeeCard> getEmployeeCard(@PathVariable Long id) {		
		Optional<EmployeeCard> res = ecservice.getEmployeeCard(id);
		 return res;
	}
	
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteProduct(@PathVariable(value="id") Long pId) throws ResourceNotFoundException{
		EmployeeCard e = ecservice.getSingleEmployeeCard(pId).orElseThrow(() -> new ResourceNotFoundException("EmployeeCard not found for this Id :"+pId));
		ecservice.deleteEmployeeCard(pId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return response;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeCard> updateEmployeeCard(@PathVariable(value="id") Long pId, @Validated @RequestBody EmployeeCard ec) throws ResourceNotFoundException{
		EmployeeCard employeeCard = ecservice.getSingleEmployeeCard(pId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this Id :"+pId));
		employeeCard.setCardIssueDate(ec.getCardIssueDate());
		final EmployeeCard updatedEC = ecservice.saveEmployeeCard(employeeCard);
		return ResponseEntity.ok().body(updatedEC);
	}
}
