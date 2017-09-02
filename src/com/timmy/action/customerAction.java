package com.timmy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.timmy.entity.Customer;
import com.timmy.entity.CustomerService;

public class customerAction extends ActionSupport implements ModelDriven<Customer> {

	private CustomerService customerService;
	
	private Customer customer=new Customer();
	

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}


	@Override
	public String execute() throws Exception {
		return NONE;
	}


	@Override
	public Customer getModel() {
		return customer;
	}
	
	public String add()
	{
		customerService.add(customer);
		
		System.out.println("add..................");
		return "addsuccess";
	}
	
	public String toaddpage()
	{
		
		
		return "toaddpage";
	}
	
	

}
