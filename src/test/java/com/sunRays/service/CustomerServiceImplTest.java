package com.sunRays.service;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;

import com.sunRays.dao.CustomerDao;
import com.sunRays.model.CustomerOneToOne;



public class CustomerServiceImplTest {
@Test
public void testGetCustomerInteger(){
	Integer custId=101;
	CustomerOneToOne expected = new CustomerOneToOne();
	expected.setCustId(custId);
	
	CustomerServiceImpl custImp=new CustomerServiceImpl();
	
	//creating Mockito stub 
	CustomerDao custDao=Mockito.mock(CustomerDao.class);
	//private and autowired hence use Whitebox.setInternalState(...) 
	Whitebox.setInternalState(custImp, CustomerDao.class, custDao);
	Mockito.when(custImp.getCustomer(custId)).thenReturn(expected);

	CustomerOneToOne actual = custImp.getCustomer(custId);
	
	Assert.assertEquals(expected, actual);
}
}
