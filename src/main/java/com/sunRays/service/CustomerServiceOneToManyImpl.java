package com.sunRays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.sunRays.dao.CustomerDaoOneToMany;
import com.sunRays.model.CustomerOneToMany;

@Service("customerServiceOneToMany")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CustomerServiceOneToManyImpl implements CustomerServiceOneToMany {

	@Autowired
	private CustomerDaoOneToMany customerDaoOneToMany;
	
	@Override
	public CustomerOneToMany getCustomer(Integer custId) {
		return customerDaoOneToMany.getCustomer(custId);
	}

	@Override
	public List<CustomerOneToMany> geCustomerList() {
		return customerDaoOneToMany.getCustomerList();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void save(CustomerOneToMany customer) {
		customerDaoOneToMany.save(customer);
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(CustomerOneToMany customer) {
		customerDaoOneToMany.delete(customer);
		
	}

}
