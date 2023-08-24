package com.wellsfargo.training.fargoloans.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.fargoloans.model.Item;
import com.wellsfargo.training.fargoloans.model.Loan;
import com.wellsfargo.training.fargoloans.repository.ItemRepository;
import com.wellsfargo.training.fargoloans.repository.LoanRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ItemService {

	 @Autowired
	 private ItemRepository Irepo;
	 
	 public Item saveItems(Item i) {
		 return Irepo.save(i);
	 }
	 
	 public Optional<Item> getSingleItem(long id){
			return Irepo.findById(id);
		}
		
		public void deleteItem(long id)
		{
			Irepo.deleteById(id);
		}
}

