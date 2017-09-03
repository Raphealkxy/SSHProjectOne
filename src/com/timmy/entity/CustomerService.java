package com.timmy.entity;

import java.util.List;

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
	public List<Customer> findAll() {
		
		List<Customer> lists=customerDao.findAll();
		return lists;
	}
	public Customer findone(int cid) {
		return customerDao.findone(cid);
	}
	public void delete(Customer c) {
                     customerDao.delete(c);		
	}
	public void update(Customer c) {
              customerDao.update(c);		
	}

}
