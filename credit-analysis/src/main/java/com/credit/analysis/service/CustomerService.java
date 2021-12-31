package com.credit.analysis.service;

import com.credit.analysis.model.CustomerModel;
import com.credit.analysis.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public CustomerModel createNewCustomer(CustomerModel customerModel) {
		return customerRepository.save(customerModel);
	}
}