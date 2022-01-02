package com.credit.analysis.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "LoanEntity")
@Table(name = "loan")
public class LoanModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loan_id")
	private Long loanId;

	@Column(name = "amount_loan", nullable = false)
	private BigDecimal amountLoan;

	@Column(name = "date_portion", nullable = false)
	private LocalDate datePortion;

	@Column(name = "amount_portion", nullable = false)
	private Long amountPortion;

	@ManyToOne
	@JoinColumn(name = "loan_customer_id")
	private CustomerModel customer;

	public LoanModel(BigDecimal amountLoan, LocalDate datePortion, Long amountPortion) {
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

	public CustomerModel getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerModel customer) {
		this.customer = customer;
	}
}