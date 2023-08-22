package com.wellsfargo.training.fargoloans.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.wellsfargo.training.fargoloans.model.ERole;
import com.wellsfargo.training.fargoloans.model.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
