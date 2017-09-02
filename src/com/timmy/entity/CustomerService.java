package com.timmy.entity;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CustomerService {
	
	
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	public void add(Customer customer)
	{
		customerDao.add(customer);
	}

}
