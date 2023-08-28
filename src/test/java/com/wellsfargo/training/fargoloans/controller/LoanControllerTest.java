package com.wellsfargo.training.fargoloans.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
	
	@Test
    public void testSaveLoan() {
        Loan loanToSave = new Loan(2, "b", 2);

        when(loanRepository.save(loanToSave)).thenReturn(loanToSave);

        Loan savedLoan = loanService.saveLoans(loanToSave);

        assertEquals("b", savedLoan.getLoanType());
    }

    @Test
    public void testDeleteLoan() {
        doNothing().when(loanRepository).deleteById(1L);

        loanService.deleteLoan(1L);

        verify(loanRepository, times(1)).deleteById(1L);
    }

//    @Test
//    public void testUpdateLoan() {
//        Loan existingLoan = new Loan(1, "a", 1);
//        Loan updatedLoan = new Loan(1, "updated", 2);
//
//        when(loanRepository.findById(1L)).thenReturn(Optional.of(existingLoan));
//        when(loanRepository.save(updatedLoan)).thenReturn(updatedLoan);
//
//        Loan result = loanService.updateLoan(1L, updatedLoan);
//
//        assertEquals("updated", result.getLoanType());
//        assertEquals(2, result.getDuration());
//    }
}
