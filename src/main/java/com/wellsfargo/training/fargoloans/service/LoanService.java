package com.wellsfargo.training.fargoloans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.fargoloans.model.Loan;
import com.wellsfargo.training.fargoloans.repository.LoanRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LoanService {

	 @Autowired
	 private LoanRepository Lrepo;
	 
	 public Loan saveLoans(Loan l) {
		 return Lrepo.save(l);
	 }
}
