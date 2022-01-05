package com.credit.analysis.dto;

import com.credit.analysis.validation.annotation.DateFirstPortion;
import com.credit.analysis.model.LoanModel;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LoanDTO {

	@NotNull(message = "O valor do empréstimo é obrigatorio.")
	@Digits(integer = 5, fraction = 2, message = "Valor digitado do empréstimo não é valido.")
	private BigDecimal amountLoan;

	@DateFirstPortion
	@NotNull(message = "A data da primeira parcela é obrigatoria.")
	private LocalDate datePortion;

	@NotNull(message = "O número de parcelas é obrigatorio.")
	@Max(value = 60, message = "O número máximo de parcelas são 60.")
	private Long amountPortion;

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

	public BigDecimal getAmountLoan() {
		return amountLoan;
	}

	public void setAmountLoan(BigDecimal amountLoan) {
		this.amountLoan = new BigDecimal(String.valueOf(amountLoan));
	}

	public LoanModel toNewLoan() {
		LoanModel loanModel = new LoanModel(this.amountLoan, this.datePortion, this.amountPortion);
		return loanModel;
	}
}