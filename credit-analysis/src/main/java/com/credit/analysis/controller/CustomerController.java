package com.credit.analysis.controller;

import com.credit.analysis.dto.CustomerDTO;
import com.credit.analysis.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("/register")
	public String formCustomer(CustomerDTO customerDTO) {
		return "registration";
	}


	@PostMapping("/teste")
	public String createNewCustomer(@Valid CustomerDTO customerDTO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		customerService.createNewCustomer(customerDTO.toNewCustoner());
		return "registration";
	}
}