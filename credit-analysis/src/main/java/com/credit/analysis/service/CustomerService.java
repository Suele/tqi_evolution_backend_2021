package com.credit.analysis.service;

import com.credit.analysis.dto.LoanDetailDTO;
import com.credit.analysis.model.CustomerModel;
import com.credit.analysis.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public CustomerModel createNewCustomer(CustomerModel customerModel) {
		if (customerModel != null) {
			return customerRepository.save(customerModel);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possivel slvar.");
	}

	public List<CustomerModel> getCustomer() {
		return customerRepository.findAll();
	}
}