package com.wellsfargo.training.fargoloans.controller;

import java.sql.Date;
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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.fargoloans.dataviews.EmployeeDetails;
import com.wellsfargo.training.fargoloans.exception.ResourceNotFoundException;
import com.wellsfargo.training.fargoloans.model.Employee;
import com.wellsfargo.training.fargoloans.model.User;
import com.wellsfargo.training.fargoloans.payload.response.MessageResponse;
import com.wellsfargo.training.fargoloans.repository.EmployeeRepository;
import com.wellsfargo.training.fargoloans.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value="/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService eservice;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@PostMapping("/")
	public Employee addEmployee(@Validated @RequestBody Employee e) {
		Employee e2 = eservice.saveEmployee(e);
		return e2;
	}
	@PostMapping("/register")
	public ResponseEntity<?>registerEmployee(@Validated @RequestBody Employee e) throws ResourceNotFoundException{
		Employee e1 = eservice.getEmployee(e.getEmpId()).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this Id :"));
		boolean b = true;
		System.out.println(e.getEmpName());
		System.out.println(e1.getEmpName());
		if(!(e1.getEmpName().equals(e.getEmpName()))) {
			b=false;
			return ResponseEntity.badRequest().body("empName Wrong creds added");
			
		}
		if(!(e1.getDesignation().equals(e.getDesignation()))) {
			b= false;
			return ResponseEntity.badRequest().body("empDes Wrong creds added");
			
		}
		if(!(e1.getDepartment().equals(e.getDepartment()))) {
			b= false;
			return ResponseEntity.badRequest().body("empDep Wrong creds added");
			
		}
		if(  e1.getDob().compareTo(e.getDob()) == 0 ) {
			b= false;
			
		}
		if(  e1.getDoj().compareTo(e.getDoj()) == 0 ) {
			b= false;
			
		}
		
		if(!b) {
			return ResponseEntity.badRequest().body("wrong creds added");
		}
		
		e1.setPassword(e.getPassword());
		eservice.saveEmployee(e1);
		return ResponseEntity.ok().body("Registered");
		
	} 
	@GetMapping("/all")
	  public ResponseEntity<List<EmployeeDetails>> allEmployee() {
		  return new ResponseEntity<List<EmployeeDetails>>(employeeRepository.findAllBy(), HttpStatus.OK);
	 }

	@GetMapping("/{id}")
	 public Optional<Employee> getEmployee(@PathVariable Long id) {
//		
		Optional<Employee> res=eservice.getEmployee(id);
		 return res;
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateProduct(@PathVariable(value="id") Long pId, @Validated @RequestBody Employee e) throws ResourceNotFoundException{
		Employee employee=eservice.getSingleProduct(pId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this Id :"+pId));
		employee.setDepartment(e.getDepartment());
		employee.setDesignation(e.getDesignation());
		employee.setDob(e.getDob());
		employee.setDoj(e.getDoj());
		employee.setEmpName(e.getEmpName());
		final Employee updateProduct=eservice.saveEmployee(employee);
		return ResponseEntity.ok().body(updateProduct);
	}
	
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteProduct(@PathVariable(value="id") Long pId) throws ResourceNotFoundException{
		Employee e=eservice.getSingleProduct(pId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this Id :"+pId));
		eservice.deleteProduct(pId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return response;
	}

}
