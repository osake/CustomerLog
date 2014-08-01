package com.sunRays.controller.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sunRays.model.CustomerOneToOne;
import com.sunRays.model.CustomerDetailOneToOne;
import com.sunRays.service.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/applicationContext.xml"})
public class CustomerOneToOneTest {
	@Autowired
	private CustomerService customerService;
	
	@Test
	public void testGetCustomerInteger(){
		Integer custId=101;
		//Customer expected = new Customer();
		//expected.setCustId(custId);
		CustomerOneToOne cust=customerService.getCustomer(custId);
		showCust(cust);
		
	}
	private void showCust(CustomerOneToOne cust) {
		System.out.println("Id: "+cust.getCustId());
		System.out.println("Name: "+cust.getCustName());
		System.out.println("Contact: "+cust.getContactNo());
		CustomerDetailOneToOne cd=cust.getCustDetails();
		System.out.println("Id: "+cd.getAddressId());
		System.out.println("Address: "+cd.getAddress());
		System.out.println("PinCode: "+cd.getPincode());
		
		
//		List<CustomerDetails> cdList=cust.getCustDetails();
//		if(cdList!=null){
//			Iterator<CustomerDetails> cdItr=cdList.iterator();
//			while(cdItr.hasNext()){
//				CustomerDetails cd=cdItr.next();
//				System.out.println("Id: "+cd.getAddressId());
//				System.out.println("Address: "+cd.getAddress());
//				System.out.println("PinCode: "+cd.getPincode());
//			}
//		}else{
//			System.out.println("getCustDetails() is null");
//		}
		
	}
}
