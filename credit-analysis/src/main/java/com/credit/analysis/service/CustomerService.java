package com.credit.analysis.service;

import com.credit.analysis.dto.CustomerDTO;
import com.credit.analysis.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public void createNewCustomer(CustomerDTO customerDTO) {
		System.out.println(customerDTO);
		customerRepository.save(customerDTO.toNewCustoner());
	}
}