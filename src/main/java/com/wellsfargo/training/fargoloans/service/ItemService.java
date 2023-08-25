package com.wellsfargo.training.fargoloans.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.wellsfargo.training.fargoloans.model.Item;
import com.wellsfargo.training.fargoloans.model.Loan;
import com.wellsfargo.training.fargoloans.repository.ItemRepository;
import com.wellsfargo.training.fargoloans.repository.LoanRepository;
import com.wellsfargo.training.fargoloans.model.Employee;
import com.wellsfargo.training.fargoloans.repository.EmployeeRepository;

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

   
   public Item saveItem(Item e) {
		return Irepo.save(e); //invokes predefined save() method of JPA Repository
	}
   
 
	public void deleteItem(long id)
	{
		Irepo.deleteById(id);
	}

	public Optional<Item> getItem(Long id) {
		
		return Irepo.findById(id);
	}	
	public List<Item> getItems(Long id) {
		
		return Irepo.findAll();
	}
	
}

