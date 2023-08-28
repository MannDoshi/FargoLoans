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
import com.wellsfargo.training.fargoloans.model.Loan;
import com.wellsfargo.training.fargoloans.repository.LoanRepository;
import com.wellsfargo.training.fargoloans.service.LoanService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/loan")
public class LoanController {

	@Autowired
	private LoanService Lservice;

	@Autowired
	private LoanRepository Lrepo;

	@PostMapping("/")
	public Loan saveLoan(@Validated @RequestBody Loan l) {
		Loan l2 = Lservice.saveLoans(l);
		return l2;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Loan>> allEmployee() {
		return new ResponseEntity<List<Loan>>(Lrepo.findAllBy(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public Optional<Loan> getEmployee(@PathVariable Long id) {
		Optional<Loan> res = Lrepo.findById(id);
		return res;
	}

	@PutMapping("/{id}")
	public ResponseEntity<Loan> updateLoan(@PathVariable(value = "id") Long pId, @Validated @RequestBody Loan l)
			throws ResourceNotFoundException {
		Loan loan = Lservice.getSingleLoan(pId)
				.orElseThrow(() -> new ResourceNotFoundException("Loan not found for this Id :" + pId));
		loan.setLoanType(l.getLoanType());
		loan.setDurationInYears(l.getDurationInYears());

		final Loan updatedLoan = Lservice.saveLoans(loan);
		return ResponseEntity.ok().body(updatedLoan);

	}

	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteLoan(@PathVariable(value = "id") Long pId) throws ResourceNotFoundException {
		Loan l = Lservice.getSingleLoan(pId)
				.orElseThrow(() -> new ResourceNotFoundException("Loan not found for this Id :" + pId));
		Lservice.deleteLoan(pId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return response;

	}

}
