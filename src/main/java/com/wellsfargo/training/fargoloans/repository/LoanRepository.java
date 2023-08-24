package com.wellsfargo.training.fargoloans.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.training.fargoloans.model.Loan;

public interface LoanRepository extends JpaRepository<Loan,Long> {

}
