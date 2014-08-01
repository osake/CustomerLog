package com.sunRays.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sunRays.model.CustomerOneToMany;

@Repository("customerDaoOneToMany")
public class CustomerDaoOneToManyImpl implements CustomerDaoOneToMany {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public CustomerOneToMany getCustomer(Integer custId) {
		return (CustomerOneToMany) sessionFactory.getCurrentSession().get(CustomerOneToMany.class, custId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerOneToMany> getCustomerList() {
		return (List<CustomerOneToMany>) sessionFactory.getCurrentSession().createCriteria(CustomerOneToMany.class).list();
	}

	@Override
	public void save(CustomerOneToMany customer) {
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
		
	}

	@Override
	public void delete(CustomerOneToMany customer) {
		sessionFactory.getCurrentSession().delete(customer);
		
	}
	
}
