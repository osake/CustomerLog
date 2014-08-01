package com.sunRays.dao;

import java.util.List;

import com.sunRays.model.CustomerOneToMany;

public interface CustomerDaoOneToMany {
	CustomerOneToMany getCustomer(Integer custId);
	List <CustomerOneToMany>  getCustomerList();
	void save(CustomerOneToMany customer);
	void delete(CustomerOneToMany customer);
}
