package com.sunRays.service;

import java.util.List;

import com.sunRays.model.Customer;

public interface CustomerService {

	Customer getCustomer(Integer custId);
	List <Customer>  geCustomerList();
	void save(Customer customer);
	void delete(Customer customer);
}
