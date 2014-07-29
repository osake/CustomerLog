package com.sunRays.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sunRays.model.Customer;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Customer getCustomer(Integer custId) {
		return (Customer) sessionFactory.getCurrentSession().get(Customer.class, custId);
	}

	@Override
	public List<Customer> getCustomerList() {
		return (List<Customer>) sessionFactory.getCurrentSession().createCriteria(Customer.class).list();
	}

	@Override
	public void save(Customer customer) {
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
		
	}

	@Override
	public void delete(Customer customer) {
		sessionFactory.getCurrentSession().delete(customer);
		
	}
	
}
