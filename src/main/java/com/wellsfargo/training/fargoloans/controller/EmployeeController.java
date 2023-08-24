package com.wellsfargo.training.fargoloans.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.fargoloans.dataviews.EmployeeDetails;
import com.wellsfargo.training.fargoloans.model.Employee;
import com.wellsfargo.training.fargoloans.model.User;
import com.wellsfargo.training.fargoloans.repository.EmployeeRepository;
import com.wellsfargo.training.fargoloans.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value="/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService eservice;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@PostMapping("/employee")
	public Employee addEmployee(@Validated @RequestBody Employee e) {
0		Employee e2 = eservice.saveEmployee(e);
		return e2;
	}
	@GetMapping("/employee/all")
	  public ResponseEntity<List<EmployeeDetails>> allEmployee() {
		  return new ResponseEntity<List<EmployeeDetails>>(employeeRepository.findAllBy(), HttpStatus.OK);
	  }

}
