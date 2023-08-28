package com.wellsfargo.training.fargoloans.repository;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.wellsfargo.training.fargoloans.enums.EmployeeIssueStatus;
import com.wellsfargo.training.fargoloans.model.Employee;
import com.wellsfargo.training.fargoloans.model.EmployeeIssue;

public interface EmployeeIssueRepository extends JpaRepository<EmployeeIssue,Long> {
//	public List<EmployeeCard> findAllBy();
	public List<EmployeeIssue> findAllByEmployee(Employee employee);
	public List<EmployeeIssue> findAllByEmployeeAndIssueStatus(Employee employee, EmployeeIssueStatus issueStatus);
	public List<EmployeeIssue> findAllByIssueStatus( EmployeeIssueStatus issueStatus);
}
