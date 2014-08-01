package com.sunRays.service;

import java.util.List;

import com.sunRays.model.CustomerOneToMany;

public interface CustomerServiceOneToMany {

	CustomerOneToMany getCustomer(Integer custId);
	List <CustomerOneToMany>  geCustomerList();
	void save(CustomerOneToMany customer);
	void delete(CustomerOneToMany customer);
}
