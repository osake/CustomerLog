package com.sunRays.service;

import java.util.List;

import com.sunRays.model.CustomerOneToOne;

public interface CustomerService {

	CustomerOneToOne getCustomer(Integer custId);
	List <CustomerOneToOne>  geCustomerList();
	void save(CustomerOneToOne customer);
	void delete(CustomerOneToOne customer);
}
