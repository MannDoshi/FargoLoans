package com.wellsfargo.training.fargoloans.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.training.fargoloans.model.Employee;
import com.wellsfargo.training.fargoloans.model.EmployeeIssue;
import com.wellsfargo.training.fargoloans.model.Loan;

public interface LoanRepository extends JpaRepository<Loan,Long> {
	public List<Loan> findAllBy();
//	public List<Loan> findAllby(Employee employee);

	public List<Loan> findAllByLoans(List<EmployeeIssue> employeeIssues);
}
