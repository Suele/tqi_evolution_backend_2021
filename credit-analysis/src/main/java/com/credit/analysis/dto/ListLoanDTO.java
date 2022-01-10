package com.credit.analysis.dto;

import com.credit.analysis.model.CustomerModel;

import java.math.BigDecimal;

/**
 * Na listagem, devemos retornar no mínimo
 * o código do empréstimo,
 * o valor
 * e a quantidade de parcelas.
 */

public class ListLoanDTO {

	private Long loanId;
	private BigDecimal amountLoan;
	private Long amountPortion;
	private CustomerModel customer;

	public ListLoanDTO() {
	}

	public ListLoanDTO(Long loanId, BigDecimal amountLoan, Long amountPortion
						 ) {
		this.loanId = loanId;
		this.amountLoan = amountLoan;
		this.amountPortion = amountPortion;
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

	public Long getAmountPortion() {
		return amountPortion;
	}

	public void setAmountPortion(Long amountPortion) {
		this.amountPortion = amountPortion;
	}

	@Override
	public String toString() {
		return "ListLoanDTO{" +
				"loanId=" + loanId +
				", amountLoan=" + amountLoan +
				", amountPortion=" + amountPortion +
				'}';
	}
}
