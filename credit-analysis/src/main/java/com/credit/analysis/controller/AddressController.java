package com.credit.analysis.controller;

import com.credit.analysis.model.AddressModel;
import com.credit.analysis.model.CustomerModel;
import com.credit.analysis.model.LoanModel;
import com.credit.analysis.repository.AddressRepository;
import com.credit.analysis.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("address")
public class AddressController {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private AddressService addressService;

	@PostMapping("/{customerId}")
	public ResponseEntity<AddressModel> createNewLoan(@Valid @RequestBody AddressModel addressModel,
													  @PathVariable("customerId") Long customerId) {

		CustomerModel customer = addressService.verifyCustomerExit(customerId);
		addressModel.setCustomer(customer);
		addressModel.setStreet(addressModel.getStreet());
		addressModel.setStreetNumber(addressModel.getStreetNumber());
		addressModel.setZipCode(addressModel.getZipCode());
		addressModel.setCity(addressModel.getCity());
		addressModel.setState(addressModel.getState());
		addressModel.setAddressType(addressModel.getAddressType());
		return ResponseEntity.status(201).body(addressService.createNewAddress(addressModel));
	}
}
