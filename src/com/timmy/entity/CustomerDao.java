package com.timmy.entity;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

public class CustomerDao {
	
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public void add(Customer customer)
	{
		hibernateTemplate.save(customer);
	}

	public List<Customer> findAll() {
		List<Customer>lists=(List<Customer>) hibernateTemplate.find("from Customer");
		if(lists!=null&&lists.size()!=0)
		{
			return lists;
		}else{
			return null;
		}
	}

	public Customer findone(int cid) {
		Customer customer=hibernateTemplate.get(Customer.class, cid);
		if(customer!=null)
		return customer;
		else {
			return null;
		}
	}

	public void delete(Customer c) {
              hibernateTemplate.delete(c);		
	}

	public void update(Customer c) {
         hibernateTemplate.update(c);
         
	}



}
