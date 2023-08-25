package com.wellsfargo.training.fargoloans.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.wellsfargo.training.fargoloans.model.EmployeeCard;

public interface EmployeeCardRepository extends JpaRepository<EmployeeCard,Long> {
//	public List<EmployeeCard> findAllBy();
}
