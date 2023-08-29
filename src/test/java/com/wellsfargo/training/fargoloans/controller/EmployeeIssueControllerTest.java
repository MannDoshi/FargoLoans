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
import org.springframework.test.context.ContextConfiguration;

import com.wellsfargo.training.fargoloans.model.Employee;
import com.wellsfargo.training.fargoloans.model.EmployeeIssue;
import com.wellsfargo.training.fargoloans.model.Loan;
import com.wellsfargo.training.fargoloans.repository.EmployeeIssueRepository;
import com.wellsfargo.training.fargoloans.repository.LoanRepository;
import com.wellsfargo.training.fargoloans.service.EmployeeIssueService;
import com.wellsfargo.training.fargoloans.service.LoanService;
import com.wellsfargo.training.fargoloans.enums.EmployeeIssueStatus;

@SpringBootTest
//@ContextConfiguration(classes= {EmployeeIssueService.class})
class EmployeeIssueControllerTest {
	
	@Autowired
	private EmployeeIssueService eisService;
	@MockBean
	private EmployeeIssueRepository employeeIssueRepository;
	@Test
	public void checkEmployeeIsseDefaultStatus() {
		EmployeeIssue ei=new EmployeeIssue();
		when(employeeIssueRepository.save(ei)).thenReturn(ei);
//		Long id=eisService.saveEmployeeIssue(ei).getIssueId();
//		Optional<EmployeeIssue> testEmployeeIssue = eisService.getSingleEmployeeIssue(id);
//		EmployeeIssue savedEI = testEmployeeIssue.get();
		assertEquals(EmployeeIssueStatus.WAITING, ei.getIssueStatus());
	}

}
