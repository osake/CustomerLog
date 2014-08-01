package com.sunRays.controller.rest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sunRays.model.CustomerDetailsManyToOne;
import com.sunRays.model.CustomerOneToMany;
import com.sunRays.service.CustomerService;
import com.sunRays.service.CustomerServiceOneToMany;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/applicationContext.xml"})
public class CustomerOneToManyTest {
	@Autowired
	private CustomerServiceOneToMany customerServiceOneToMany;
	
	@Test
	public void testSaveCustomerOneToMany(){
		List<CustomerDetailsManyToOne> cdList=new ArrayList<CustomerDetailsManyToOne>();
		CustomerDetailsManyToOne cd;
		cd=new CustomerDetailsManyToOne();
		cd.setAddress("Pune");
		cdList.add(cd);
		cd=new CustomerDetailsManyToOne();
		cd.setAddress("Mumbai");
		cdList.add(cd);
		CustomerOneToMany customer=new CustomerOneToMany();
		customer.setCustName("Jaydip");
		customer.setContactNo("9561702843");
		customer.setCustDetails(cdList);
		customerServiceOneToMany.save(customer);
	}
	
	
	//@Test
	public void testGetCustomerInteger(){
		Integer custId=102;
		//Customer expected = new Customer();
		//expected.setCustId(custId);
		CustomerOneToMany cust=customerServiceOneToMany.getCustomer(custId);
		showCust(cust);
		
	}
	private void showCust(CustomerOneToMany cust) {
		System.out.println("Id: "+cust.getCustId());
		System.out.println("Name: "+cust.getCustName());
		System.out.println("Contact: "+cust.getContactNo());
		List<CustomerDetailsManyToOne> cdList=cust.getCustDetails();
		if(cdList!=null){
			Iterator<CustomerDetailsManyToOne> cdItr=cdList.iterator();
			while(cdItr.hasNext()){
				CustomerDetailsManyToOne cd=cdItr.next();
				System.out.println("Id: "+cd.getAddressId());
				System.out.println("Address: "+cd.getAddress());
				System.out.println("PinCode: "+cd.getPincode());
			}
		}else{
			System.out.println("getCustDetails() is null");
		}
		
	}
}
