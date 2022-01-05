package com.credit.analysis.service;

import com.credit.analysis.model.LoanModel;
import com.credit.analysis.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LoanService {
	@Autowired
	private LoanRepository loanRepository;

	public LoanModel createNewLoan(LoanModel loanModel) {
		LocalDate DateOfTomorrow = LocalDate.now().plusDays(1);
		LocalDate DateMaximaFirstInstallment = DateOfTomorrow.plusMonths(3);
		if (loanModel.getAmountPortion() > 60) {
			throw new RuntimeException("O número máximo de parcelas são 60.");
		} else if (!(loanModel.getDatePortion().isBefore(DateMaximaFirstInstallment) || loanModel.getDatePortion().isEqual(DateMaximaFirstInstallment))) {
			throw new RuntimeException("Data da primeira parcela é inválida, a data limite para a primeira parcela é: " + DateMaximaFirstInstallment);
		}
		return loanRepository.save(loanModel);
	}
}