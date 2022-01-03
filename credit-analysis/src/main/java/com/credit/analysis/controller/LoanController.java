package com.credit.analysis.controller;

import com.credit.analysis.dto.LoanDTO;
import com.credit.analysis.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("loan")
public class LoanController {
	@Autowired
	private LoanService loanService;

	@GetMapping("/register")
	public String formLoan(LoanDTO loanDTO) {
		return "loan";
	}

	@PostMapping("/register-new")
	public String cresteNewLoan(@Valid LoanDTO loanDTO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "loan";
		}
		loanService.createNewLoan(loanDTO.toNewLoan());
		return "loan";
	}
}