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
import com.wellsfargo.training.fargoloans.model.EmployeeIssue;
import com.wellsfargo.training.fargoloans.model.Item;
import com.wellsfargo.training.fargoloans.model.Loan;
import com.wellsfargo.training.fargoloans.repository.EmployeeIssueRepository;
import com.wellsfargo.training.fargoloans.repository.EmployeeRepository;
import com.wellsfargo.training.fargoloans.repository.ItemRepository;
import com.wellsfargo.training.fargoloans.repository.LoanRepository;
import com.wellsfargo.training.fargoloans.service.EmployeeIssueService;
import com.wellsfargo.training.fargoloans.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value="/api/employeeissue")
public class EmployeeIssueController {
	@Autowired
	private EmployeeIssueService eiservice;
	
	@Autowired
	private EmployeeIssueRepository employeeIssueRepository;
	
	@Autowired
	private ItemRepository Irepo;
	
	@Autowired
	private LoanRepository Lrepo;
	
	@Autowired 
	private EmployeeRepository Erepo;
	
	@Autowired
	private EmployeeService eservice;
	
	
	
	@PostMapping("/{empId}/{itemId}/{loanId}")
	public void addEmployeeIssue(@PathVariable Long empId, @PathVariable Long itemId, @PathVariable Long loanId, @Validated @RequestBody EmployeeIssue ei) throws ResourceNotFoundException {

//		 Erepo.findById(empId).map(e ->{
//			//System.out.println(ei);
//			ei.setEmployee(e);
////			Irepo.findById(itemId).map(i -> {
////				ei.setItem(i);
////	
////			});
//			
//			return eiservice.saveEmployeeIssue(ei);
//		}).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this Id :"+empId));//ma
		
		Optional<Employee> oe = Erepo.findById(empId);
		if(oe.isPresent()) {
			Employee e = oe.get();
			ei.setEmployee(e);
		}
//		else {
//			throw new ResourceNotFoundException("Employee not found for this Id :"+empId);
//		}
		Optional<Item> oi = Irepo.findById(itemId);
		if(oi.isPresent()) {
			Item i = oi.get();
			ei.setItem(i);
		}
		
		Optional<Loan> ol = Lrepo.findById(loanId);
		if(ol.isPresent()) {
			Loan l = ol.get();
			ei.setLoan(l);
		}
		
			
		eiservice.saveEmployeeIssue(ei);
//		}).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this Id :"+empId));//ma
		
	}
	
	@GetMapping("/all")
	  public ResponseEntity<List<EmployeeIssue>> allEmployeeIssue() {
		  return new ResponseEntity<List<EmployeeIssue>>(employeeIssueRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	 public Optional<EmployeeIssue> getEmployeeIssue(@PathVariable Long id) {		
		Optional<EmployeeIssue> res = eiservice.getEmployeeIssue(id);
		 return res;
	}
	
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteProduct(@PathVariable(value="id") Long pId) throws ResourceNotFoundException{
		EmployeeIssue e = eiservice.getSingleEmployeeIssue(pId).orElseThrow(() -> new ResourceNotFoundException("EmployeeIssue not found for this Id :"+pId));
		eiservice.deleteEmployeeIssue(pId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return response;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeIssue> updateEmployeeIssue(@PathVariable(value="id") Long pId, @Validated @RequestBody EmployeeIssue ei) throws ResourceNotFoundException{
		EmployeeIssue employeeIssue = eiservice.getSingleEmployeeIssue(pId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this Id :"+pId));
		employeeIssue.setIssueDate(ei.getIssueDate());
		employeeIssue.setReturn_date(ei.getReturn_date());
		final EmployeeIssue updatedEI = eiservice.saveEmployeeIssue(employeeIssue);
		return ResponseEntity.ok().body(updatedEI);
	}
}
