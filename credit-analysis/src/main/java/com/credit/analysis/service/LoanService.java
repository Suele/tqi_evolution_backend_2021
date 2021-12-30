package com.credit.analysis.service;

import com.credit.analysis.dto.LoanDTO;
import com.credit.analysis.model.LoanModel;
import com.credit.analysis.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {
	@Autowired
	private LoanRepository loanRepository;

	// solicitar emprestimo
	public void requestLoan(LoanDTO newLoan) {

	}
}