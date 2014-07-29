package com.sunRays.dao;

import java.util.List;

import com.sunRays.model.Customer;

public interface CustomerDao {
	Customer getCustomer(Integer custId);
	List <Customer>  getCustomerList();
	void save(Customer customer);
	void delete(Customer customer);
}
