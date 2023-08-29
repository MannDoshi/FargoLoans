package com.wellsfargo.training.fargoloans.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.training.fargoloans.dataviews.EmployeeDetails;
import com.wellsfargo.training.fargoloans.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	public List<Employee> findAllBy();
}
