package com.wellsfargo.training.fargoloans.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name="item_master")
@NoArgsConstructor 
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="item_id")
	private long itemId;
	
	@Column(name="itm_description")
	private String itemDesc;

	
	@Column(name="item_make")
	private String itemMake;
	
	@Column(name="item_category")
	private String itemCategory;
	
	@Column(name="item_valuation")
	private long itemValuation;

	@OneToMany(cascade=CascadeType.ALL, mappedBy = "item")
	@Column(name="issue_ids")
	@JsonBackReference
	private List<EmployeeIssue> issueIdList= new ArrayList<>();

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}



	public String getItemMake() {
		return itemMake;
	}

	public void setItemMake(String itemMake) {
		this.itemMake = itemMake;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public long getItemValuation() {
		return itemValuation;
	}

	public void setItemValuation(long itemValuation) {
		this.itemValuation = itemValuation;
	}

	public List<EmployeeIssue> getIssueIdList() {
		return issueIdList;
	}

	public void setIssueIdList(List<EmployeeIssue> issueIdList) {
		this.issueIdList = issueIdList;
	}
	
	
}
