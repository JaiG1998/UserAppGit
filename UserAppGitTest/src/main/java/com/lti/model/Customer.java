package com.lti.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb1_customer")
public class Customer {
	
	@Id
	@SequenceGenerator(name="seq_customer",initialValue=10, allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_customer")
	private int customerId;
	
	@Column(nullable=false)
	private String customerName;
	
	@Column
	private String customerCity;
	
	@OneToOne(mappedBy="customer", cascade=CascadeType.ALL)
	private Account account;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerCity="
				+ customerCity + "]";
	}
	
	
	

}
