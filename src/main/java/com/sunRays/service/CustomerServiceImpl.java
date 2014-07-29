package com.sunRays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sunRays.dao.CustomerDao;
import com.sunRays.model.Customer;

@Service("customerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Customer getCustomer(Integer custId) {
		return customerDao.getCustomer(custId);
	}

	@Override
	public List<Customer> geCustomerList() {
		return customerDao.getCustomerList();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void save(Customer customer) {
		customerDao.save(customer);
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Customer customer) {
		customerDao.delete(customer);
		
	}

}
