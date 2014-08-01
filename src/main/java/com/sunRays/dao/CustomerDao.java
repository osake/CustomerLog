package com.sunRays.dao;

import java.util.List;

import com.sunRays.model.CustomerOneToOne;

public interface CustomerDao {
	CustomerOneToOne getCustomer(Integer custId);
	List <CustomerOneToOne>  getCustomerList();
	void save(CustomerOneToOne customer);
	void delete(CustomerOneToOne customer);
}
