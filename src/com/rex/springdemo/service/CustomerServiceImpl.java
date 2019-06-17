package com.rex.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rex.springdemo.dao.CustomerDAO;
import com.rex.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	/*
	 * now here we have to use @Transactional not on CustomerDAO, 
	 * because now transaction start and end on service layer
	 * */
	@Transactional  
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();		
	}

	@Override
	@Transactional 
	public void saveCustomer(Customer theCustomer) {
		
		System.out.println("customerService : "+theCustomer.getFirstName()+":::"+theCustomer.getLastName());
		
		customerDAO.saveCustomer(theCustomer);
		
	}

	@Override
	@Transactional 
	public Customer getCustomer(int theId) {

		
		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional 
	public void deleteCustomer(int theId) {

      customerDAO.deleteCustomer(theId);
		
	}

}
