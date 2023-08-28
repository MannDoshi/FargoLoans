package com.wellsfargo.training.fargoloans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wellsfargo.training.fargoloans.model.EmployeeCard;

public interface EmployeeCardRepository extends JpaRepository<EmployeeCard, Long> {
}
