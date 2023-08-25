package com.wellsfargo.training.fargoloans.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.training.fargoloans.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
