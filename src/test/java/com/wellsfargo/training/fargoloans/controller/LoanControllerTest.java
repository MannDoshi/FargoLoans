package com.wellsfargo.training.fargoloans.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.wellsfargo.training.fargoloans.model.Employee;
import com.wellsfargo.training.fargoloans.model.Loan;
import com.wellsfargo.training.fargoloans.repository.LoanRepository;
import com.wellsfargo.training.fargoloans.service.LoanService;

@SpringBootTest
class LoanControllerTest {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	
	@Autowired
	private LoanService loanService;
	
	@MockBean
	private LoanRepository loanRepository;
	
	@BeforeEach
	void setup() {
//		Optional<Loan> loan1 = Optional.of(new Loan());
		Optional<Loan> loan = Optional.of(new Loan(1,"a",1));
		Mockito.when(loanRepository.findById((long) 1)).thenReturn(loan);
	}
	
	@Test
	public void getLoanByIdTest() {
		String loanType = "a";
		Optional<Loan> testLoan = loanService.getSingleLoan(1);
		
		Loan l = testLoan.get();
		assertEquals(loanType, l.getLoanType());
	}

}
