package com.credit.analysis.dto;

import com.credit.analysis.model.CustomerModel;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * No detalhe do empréstimo, devemos retornar:
 * código do empréstimo,
 * valor,
 * quantidade de parcelas,
 * data da primeira parcela,
 * e-mail do cliente e
 * renda do cliente.
 */

public class LoanDetailDTO {
	private Long loanId;
	private BigDecimal amountLoan;
	private LocalDate datePortion;
	private Long amountPortion;
	private String email;
	private BigDecimal income;

	public LoanDetailDTO() {
	}

	public LoanDetailDTO(Long loanId, BigDecimal amountLoan,
						 LocalDate datePortion, Long amountPortion, String email,
						 BigDecimal income) {
		this.loanId = loanId;
		this.amountLoan = amountLoan;
		this.datePortion = datePortion;
		this.amountPortion = amountPortion;
		this.email = email;
		this.income = income;
	}

	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getIncome() {
		return income;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}

	@Override
	public String toString() {
		return "LoanDetailDTO{" +
				"loanId=" + loanId +
				", amountLoan=" + amountLoan +
				", datePortion=" + datePortion +
				", amountPortion=" + amountPortion +
				", email='" + email + '\'' +
				", income=" + income +
				'}';
	}
}