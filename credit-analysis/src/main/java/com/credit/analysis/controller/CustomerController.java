package com.credit.analysis.controller;

import com.credit.analysis.dto.LoanDetailDTO;
import com.credit.analysis.model.CustomerModel;
import com.credit.analysis.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping
	public ResponseEntity<CustomerModel> createNewCustomer(@Valid @RequestBody CustomerModel customerModel) {
		return ResponseEntity.status(201).body(customerService.createNewCustomer(customerModel));
	}
}