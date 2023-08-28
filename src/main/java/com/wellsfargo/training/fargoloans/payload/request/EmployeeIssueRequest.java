package com.wellsfargo.training.fargoloans.payload.request;

public class EmployeeIssueRequest {
	private long employeeId;
	private long itemId;
	private long LoanId;

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public long getLoanId() {
		return LoanId;
	}

	public void setLoanId(long loanId) {
		LoanId = loanId;
	}
}