package com.wellsfargo.training.fargoloans.controller;


import java.sql.Date;
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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.wellsfargo.training.fargoloans.dataviews.ItemDetails;
import com.wellsfargo.training.fargoloans.exception.ResourceNotFoundException;
import com.wellsfargo.training.fargoloans.model.Item;
import com.wellsfargo.training.fargoloans.model.User;
import com.wellsfargo.training.fargoloans.repository.ItemRepository;
import com.wellsfargo.training.fargoloans.repository.ItemRepository;
import com.wellsfargo.training.fargoloans.service.ItemService;
import com.wellsfargo.training.fargoloans.service.ItemService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value="/api/item")
public class ItemController {
	
	@Autowired
	private ItemService iservice;
	
	
	
	
	@PostMapping("/")
	public Item addItem(@Validated @RequestBody Item e) {
		Item e2 = iservice.saveItem(e);
		return e2;
	}
//	@GetMapping("/all")
//	  public ResponseEntity<List<Item>> allItem() {
//		  return new ResponseEntity<List<Item>>(iservice.getItems(), HttpStatus.OK);
//	 }
//
//	@GetMapping("/{id}")
//	 public Optional<Item> getItem(@PathVariable Long id) {
////		
//		Optional<Item> res=iservice.getItem(id);
//		 return res;
//	}
//	@PutMapping("/{id}")
//	public ResponseEntity<Item> updateProduct(@PathVariable(value="id") Long pId, @Validated @RequestBody Item e) throws ResourceNotFoundException{
//		Item Item=iservice.getSingleProduct(pId).orElseThrow(() -> new ResourceNotFoundException("Item not found for this Id :"+pId));
//		Item.setDepartment(e.getDepartment());
//		Item.setDesignation(e.getDesignation());
//		Item.setDob(e.getDob());
//		Item.setDoj(e.getDoj());
//		Item.setEmpName(e.getEmpName());
//		final Item updateProduct=iservice.saveItem(Item);
//		return ResponseEntity.ok().body(updateProduct);
//	}
//	
//	@DeleteMapping("/{id}")
//	public Map<String, Boolean> deleteProduct(@PathVariable(value="id") Long pId) throws ResourceNotFoundException{
//		Item e=iservice.getSingleProduct(pId).orElseThrow(() -> new ResourceNotFoundException("Item not found for this Id :"+pId));
//		iservice.deleteProduct(pId);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put("Deleted", Boolean.TRUE);
//		return response;
//	}

}
