package com.sunRays.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class CustomerOneToOne{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "custId")
	private int custId;
	
	@Column(name="custName")
	private String custName;
	
	@Column(name="contactNo")
	private String contactNo;
	
	
	@OneToOne(mappedBy="customer")
	CustomerDetailOneToOne custDetails;
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public CustomerDetailOneToOne getCustDetails() {
		return custDetails;
	}
	public void setCustDetails(CustomerDetailOneToOne custDetails) {
		this.custDetails = custDetails;
	}
	
//	public List<CustomerDetails> getCustDetails() {
//		return custDetails;
//	}
//	public void setCustDetails(List<CustomerDetails> custDetails) {
//		this.custDetails = custDetails;
//	}
	
	
}