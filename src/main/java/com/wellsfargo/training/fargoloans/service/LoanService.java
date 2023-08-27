package com.wellsfargo.training.fargoloans.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.fargoloans.model.Employee;
import com.wellsfargo.training.fargoloans.model.EmployeeIssue;
import com.wellsfargo.training.fargoloans.model.Loan;
import com.wellsfargo.training.fargoloans.repository.EmployeeIssueRepository;
import com.wellsfargo.training.fargoloans.repository.EmployeeRepository;
import com.wellsfargo.training.fargoloans.repository.LoanRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LoanService {

	 @Autowired
	 private LoanRepository Lrepo;
	 
	 @Autowired
	 private EmployeeRepository ERepo;
	 
	 @Autowired
	 private EmployeeIssueRepository EIRepo;
	 
	 public Loan saveLoans(Loan l) {
		 return Lrepo.save(l);
	 }
	 
	 public Optional<Loan> getSingleLoan(long id){
			return Lrepo.findById(id);
		}
		
		public void deleteLoan(long id)
		{
			Lrepo.deleteById(id);
		}
		public void getLoansOfEmployee(long empId ){
			Optional<Employee> _employee=ERepo.findById(empId);
			Employee employee=_employee.get();
			List<Loan> result=new ArrayList<>();
			_employee.ifPresent((employee)->{
				List < EmployeeIssue > employeeIssues= EIRepo.findAllByEmployee(employee);
				List< Loan > loans= Lrepo.findAllByLoans(employeeIssues);
				
			});
		}

		private void findAllByEmployee(Employee employee) {
			// TODO Auto-generated method stub
			
		}
}
