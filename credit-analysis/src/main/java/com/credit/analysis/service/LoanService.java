package com.credit.analysis.service;

import com.credit.analysis.model.LoanModel;
import com.credit.analysis.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {
	@Autowired
	private LoanRepository loanRepository;

	public LoanModel createNewLoan(LoanModel loanModel) {
		return loanRepository.save(loanModel);
	}
}