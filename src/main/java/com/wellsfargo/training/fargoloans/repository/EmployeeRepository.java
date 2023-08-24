package com.wellsfargo.training.fargoloans.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.training.fargoloans.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
         
}
