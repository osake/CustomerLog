package com.sunRays.dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;

import com.sunRays.model.CustomerOneToOne;


public class CustomerDaoImplTest {

@Test
public void testGetCustomerInteger(){
	Integer custId=101;
	CustomerOneToOne expected = new CustomerOneToOne();
	expected.setCustId(custId);
	
	SessionFactory sessionFactory=Mockito.mock(SessionFactory.class);
	Session session=Mockito.mock(Session.class);
	Mockito.when(sessionFactory.getCurrentSession()).thenReturn(session);
	
	CustomerDaoImpl custDao=new CustomerDaoImpl();
	Whitebox.setInternalState(custDao, SessionFactory.class, sessionFactory);
	Mockito.when(session.get(CustomerOneToOne.class, custId)).thenReturn(expected);
	
	
	CustomerOneToOne actual = custDao.getCustomer(custId);
	Assert.assertEquals(expected, actual);
	
	
	
}


}
