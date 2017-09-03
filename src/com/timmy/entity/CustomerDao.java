package com.timmy.entity;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
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

	public int findtotal() {
		//hibernate模板用find进行查询，返回的是一个list值。
		List<Object> objs=(List<Object>) hibernateTemplate.find("select count(*) from Customer");
		if(objs!=null&&objs.size()!=0)
		{
			Object object=objs.get(0);
			//先变成long型，再变成int型
			Long obj=(Long) object;
			int value=obj.intValue();
			return value;
		}
		return 0;
	}

	public List<Customer> findlist(int begin, int pagesize) {
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Customer.class);
		List<Customer>list=(List<Customer>) hibernateTemplate.findByCriteria(detachedCriteria,begin,pagesize);
		
		return list;
	}

	



}
