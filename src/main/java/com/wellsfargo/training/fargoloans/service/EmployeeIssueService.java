package com.wellsfargo.training.fargoloans.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.fargoloans.enums.EmployeeIssueStatus;
import com.wellsfargo.training.fargoloans.model.Employee;
import com.wellsfargo.training.fargoloans.model.EmployeeIssue;
import com.wellsfargo.training.fargoloans.repository.EmployeeIssueRepository;
import com.wellsfargo.training.fargoloans.repository.EmployeeRepository;
import com.wellsfargo.training.fargoloans.repository.LoanRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeIssueService {

	@Autowired
	private EmployeeIssueRepository EIrepo;
	
	@Autowired
	 private LoanRepository Lrepo;

	 @Autowired
	 private EmployeeRepository Erepo;

	
	public EmployeeIssue saveEmployeeIssue(EmployeeIssue e) {
		return EIrepo.save(e); //invokes predefined save() method of JPA Repository
	}
   
   public Optional<EmployeeIssue> getSingleEmployeeIssue(long id){
		return EIrepo.findById(id);
	}
	
	public void deleteEmployeeIssue(long id)
	{
		EIrepo.deleteById(id);
	}

	public Optional<EmployeeIssue> getEmployeeIssue(Long id) {
		
		return EIrepo.findById(id);
	}
	public List<EmployeeIssue> getEmployeeIssueByEmployeeId( long empId){
		Optional<Employee> _employee=Erepo.findById(empId);
		Employee employee=_employee.get();
		List < EmployeeIssue > employeeIssues= EIrepo.findAllByEmployee(employee);
		return employeeIssues;
	}
	public List<EmployeeIssue> getEmployeeIssueByEmployeeIdByIssueStatus( long empId ,EmployeeIssueStatus status){
		Optional<Employee> _employee=Erepo.findById(empId);
		Employee employee=_employee.get();
		List < EmployeeIssue > employeeIssues= EIrepo.findAllByEmployeeAndIssueStatus(employee,status);
		return employeeIssues;
	}
	public List<EmployeeIssue> getEmployeeIssueByIssueStatus(EmployeeIssueStatus status){
		List < EmployeeIssue > employeeIssues= EIrepo.findAllByIssueStatus(status);
		return employeeIssues;
	}
}
