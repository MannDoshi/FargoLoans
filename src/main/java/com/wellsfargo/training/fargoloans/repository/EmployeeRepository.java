package com.wellsfargo.training.fargoloans.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.training.fargoloans.dataviews.EmployeeDetails;
import com.wellsfargo.training.fargoloans.model.Employee;
import com.wellsfargo.training.fargoloans.model.User;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<EmployeeDetails> findAllBy();

}
