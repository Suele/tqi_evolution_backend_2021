package com.credit.analysis.dto;

import com.credit.analysis.model.LoanModel;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LoanDTO {

	@NotBlank(message = "O código do empréstimo é obrigatorio.")
	private Long loanId;

	@NotBlank(message = "O valor do empréstimo é Obrigatorio.")
	private BigDecimal amountLoan;

	@Future(message = "Data da parcela é invalida.")
	private LocalDate datePortion;

	@Max(value = 60, message = "O número máximo de parcelas são 60.")
	private Long amountPortion;

	public Long getLoanId() {
		return loanId;
	}

	public BigDecimal getAmountLoan() {
		return amountLoan;
	}

	public void setAmountLoan(BigDecimal amountLoan) {
		this.amountLoan = amountLoan;
	}

	public LocalDate getDatePortion() {
		return datePortion;
	}

	public void setDatePortion(LocalDate datePortion) {
		this.datePortion = datePortion;
	}

	public Long getAmountPortion() {
		return amountPortion;
	}

	public void setAmountPortion(Long amountPortion) {
		this.amountPortion = amountPortion;
	}

	public LoanModel toNewLoan(LoanDTO newLoan) {
		LoanModel loanModel = new LoanModel(newLoan.amountLoan, newLoan.datePortion, newLoan.amountPortion);
		return loanModel;
	}
}