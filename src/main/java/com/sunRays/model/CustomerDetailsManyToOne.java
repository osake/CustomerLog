package com.sunRays.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="CustomerDetails")
public class CustomerDetailsManyToOne{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "addressId")
	private int addressId;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "pincode")
	private String pincode;
	
	@ManyToOne
	@JoinColumn(name="custId")
	CustomerOneToMany customer;
	
	public CustomerOneToMany getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerOneToMany customer) {
		this.customer = customer;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
}