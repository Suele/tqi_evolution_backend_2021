package com.credit.analysis.model;

import com.credit.analysis.validationDate.DateFirstPortion;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Entity(name = "LoanEntity")
@Table(name = "loan")
public class LoanModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loan_id")
	private Long loanId;

	@Column(name = "amount_loan")
	@NotNull(message = "O valor do empréstimo é obrigatorio.")
	@Digits(integer = 5, fraction = 2, message = "Valor digitado do empréstimo não é valido.")
	private BigDecimal amountLoan;

	@DateFirstPortion
	@NotNull(message = "A data da primeira parcela é obrigatoria.")
	@Column(name = "date_portion")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate datePortion;


	@NotNull(message = "O número de parcelas é obrigatorio.")
	@Max(value = 60, message = "O número máximo de parcelas são 60.")
	@Column(name = "amount_portion")
	private Long amountPortion;

	@ManyToOne
	@JoinColumn(name = "loan_customer_id")
	@JsonIgnore
	private CustomerModel customer;

	public LoanModel() {
	}

	public LoanModel(BigDecimal amountLoan, LocalDate datePortion, Long amountPortion, CustomerModel customer) {
		this.amountLoan = amountLoan;
		this.datePortion = datePortion;
		this.amountPortion = amountPortion;
		this.customer = customer;
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

	@Override
	public String toString() {
		return "LoanModel{" +
				"loanId=" + loanId +
				", amountLoan=" + amountLoan +
				", datePortion=" + datePortion +
				", amountPortion=" + amountPortion +
				", customer=" + customer +
				'}';
	}
}