package com.sunRays.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sunRays.model.CustomerOneToOne;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public CustomerOneToOne getCustomer(Integer custId) {
		return (CustomerOneToOne) sessionFactory.getCurrentSession().get(CustomerOneToOne.class, custId);
	}

	@Override
	public List<CustomerOneToOne> getCustomerList() {
		return (List<CustomerOneToOne>) sessionFactory.getCurrentSession().createCriteria(CustomerOneToOne.class).list();
	}

	@Override
	public void save(CustomerOneToOne customer) {
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
		
	}

	@Override
	public void delete(CustomerOneToOne customer) {
		sessionFactory.getCurrentSession().delete(customer);
		
	}
	
}
