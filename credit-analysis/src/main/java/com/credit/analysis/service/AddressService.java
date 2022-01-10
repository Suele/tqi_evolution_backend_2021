package com.credit.analysis.service;

import com.credit.analysis.model.AddressModel;
import com.credit.analysis.model.CustomerModel;
import com.credit.analysis.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;

	public AddressModel createNewAddress(AddressModel addressModel) {
		return addressRepository.save((addressModel));
	}

	public CustomerModel verifyCustomerExit(Long customerId) {
		Optional<AddressModel> customer = addressRepository.findById(customerId);
		if (customer.isPresent()) {
			return customer.get().getCustomer();
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não cadastrado.");
	}
}
