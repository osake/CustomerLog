package com.sunRays.controller.rest;

import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sunRays.model.Customer;
import com.sunRays.model.CustomerDetails;
import com.sunRays.service.CustomerService;

@Component
@Scope("prototype")
@Path("/customer")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	@GET
	@Path("/hello/{custId}")
	 public void get(@PathParam ("custId") String custId){
		Customer cust= null;
		 try{
			 if(custId!=null && custId.length()>0){
				 cust=customerService.getCustomer(Integer.parseInt(custId));
				 showCust(cust);
			 }
		 } catch (IllegalArgumentException e) {
		      throw new WebApplicationException(Response.status(Status.BAD_REQUEST).entity( e.getMessage() ).build());
		 }
	 }

	private void showCust(Customer cust) {
		System.out.println("Id: "+cust.getCustId());
		System.out.println("Name: "+cust.getCustName());
		System.out.println("Contact: "+cust.getContactNo());
		List<CustomerDetails> cdList=cust.getCustDetails();
		if(cdList!=null){
			Iterator<CustomerDetails> cdItr=cdList.iterator();
			while(cdItr.hasNext()){
				CustomerDetails cd=cdItr.next();
				System.out.println("Id: "+cd.getAddressId());
				System.out.println("Address: "+cd.getAddress());
				System.out.println("PinCode: "+cd.getPincode());
			}
		}else{
			System.out.println("getCustDetails() is null");
		}
		
	}
	
}
