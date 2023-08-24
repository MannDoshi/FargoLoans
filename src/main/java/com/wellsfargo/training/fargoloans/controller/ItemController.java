package com.wellsfargo.training.fargoloans.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.fargoloans.exception.ResourceNotFoundException;
import com.wellsfargo.training.fargoloans.model.Item;
import com.wellsfargo.training.fargoloans.repository.ItemRepository;
import com.wellsfargo.training.fargoloans.service.ItemService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value="/api/item/")
public class ItemController {

	@Autowired
	private ItemService Iservice;
	
	@Autowired 
	private ItemRepository Irepo;
	
	@PostMapping("/")
	private Item saveItem(@Validated @RequestBody Item i) {
		Item i2 = Iservice.saveItems(i);
		return i2;
	}
	
	@GetMapping("/all")
	  public ResponseEntity<List<Item>> allEmployee() {
		  return new ResponseEntity<List<Item>>(Irepo.findAllBy(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	 public Optional<Item> getEmployee(@PathVariable Long id) {
		Optional<Item> res=Irepo.findById(id);
		 return res;
	}
	@PutMapping("/{id}")
	public ResponseEntity<Item> updateLoan(@PathVariable(value="id") Long pId, @Validated @RequestBody Item l) throws ResourceNotFoundException{
		Item loan=Iservice.getSingleItem(pId).orElseThrow(() -> new ResourceNotFoundException("Loan not found for this Id :"+pId));
          loan.setItemDesc(l.getItemDesc());
          loan.setItemCategory(l.getItemCategory());
          loan.setIssueStatus(l.getIssueStatus());
          loan.setItemMake(l.getItemMake());
          loan.setItemValuation(l.getItemValuation());
          
		
//		loan.setLoanType(l.getLoanType());
//           loan.setDurationInYears(l.getDurationInYears());
           
          final Item updatedLoan = Iservice.saveItems(loan);
          return ResponseEntity.ok().body(updatedLoan);
		
	}
	
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteLoan(@PathVariable(value="id") Long pId) throws ResourceNotFoundException{
		Item l=Iservice.getSingleItem(pId).orElseThrow(() -> new ResourceNotFoundException("Loan not found for this Id :"+pId));
		Iservice.deleteItem(pId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return response;
	
	}
	
	}
