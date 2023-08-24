package com.wellsfargo.training.fargoloans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.fargoloans.model.Loan;
import com.wellsfargo.training.fargoloans.service.LoanService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value="/api")
public class LoanController {

	@Autowired
	private LoanService Lservice;
	
	@PostMapping("/loan")
	private Loan saveLoan(@Validated @RequestBody Loan l) {
		Loan l2 = Lservice.saveLoans(l);
		return l2;
	}
}
