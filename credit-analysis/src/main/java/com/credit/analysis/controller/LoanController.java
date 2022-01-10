package com.credit.analysis.controller;

import com.credit.analysis.dto.ListLoanDTO;
import com.credit.analysis.dto.LoanDetailDTO;
import com.credit.analysis.model.LoanModel;
import com.credit.analysis.repository.LoanRepository;
import com.credit.analysis.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("loan")
public class LoanController {
	@Autowired
	private LoanService loanService;

	@Autowired
	private LoanRepository loanRepository;


	@GetMapping("/{cpf}")
	public ResponseEntity<List<ListLoanDTO>> getCustomer(@PathVariable("cpf") String cpf) {
		return ResponseEntity.status(200).body(loanService.listLoan(cpf));
	}


	@GetMapping("/detail/{cpf}")
	public ResponseEntity<List<LoanDetailDTO>> detail(@PathVariable("cpf") String cpf) {
		return ResponseEntity.status(200).body(loanService.loanDetail(cpf));
	}

	@PostMapping("/{customerId}")
	public ResponseEntity<LoanModel> createNewLoan(@Valid @RequestBody LoanModel loanModel, @PathVariable("customerId") Long customerId) {
		Optional<LoanModel> customerIdExist = loanRepository.findById(customerId);
		if (customerIdExist.isPresent()) {

			loanModel.setCustomer(customerIdExist.get().getCustomer());
			loanModel.setAmountLoan(loanModel.getAmountLoan());
			loanModel.setAmountPortion(loanModel.getAmountPortion());
			loanModel.setDatePortion(loanModel.getDatePortion());
			return ResponseEntity.status(201).body(loanService.createNewLoan(loanModel));
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Verifique se os dados foram preenchidos corretamente.");
	}
}