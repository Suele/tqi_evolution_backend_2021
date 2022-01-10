package com.credit.analysis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.aspectj.bridge.Message;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "customerEntity")
@Table(name = "customer")
public class CustomerModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Long customerId;

	@Column(name = "customer_name", length = 100)
	@NotBlank(message = "Nome Completo é obrigatório.")
	@Length(min = 5, max = 100, message = "O nome deve ser entre 5 e 100 caracteres.")
	private String customerName;


	@CPF
	@NotBlank(message = "O CPF é obrigatório.")
	@Column(length = 11, unique = true)
	private String cpf;


	@Min(value = 11)
	@NotBlank(message = "O RG é obrigatório.")
	@Column(length = 11, unique = true)
	private String rg;

	@Digits(integer = 5, fraction = 2, message = "A renda é obrigatória.")
	private BigDecimal income;

	@Email(message = "Email inválido.")
	@NotBlank(message = "O email é obrigatório.")
	@Column(length = 45)
	private String email;

	@NotBlank(message = "A senha é obrigatória.")
	@Column(unique = true, length = 10)
	private String password;

	@NotEmpty()
	@NotNull(message = "O endereço completo é obrigatório")
	@OneToMany(
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			mappedBy = "customer")
	private List<AddressModel> addresses = new ArrayList<>();

	@NotEmpty()
	@NotNull(message = "Os dados do emprestimo são obrigatórios.")
	@OneToMany(
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			mappedBy = "customer")
	private List<LoanModel> loan = new ArrayList<>();

	public CustomerModel() {
	}

	public CustomerModel(String customerName, String cpf, String rg, BigDecimal income, String email,
						 String password, List<AddressModel> addresses, List<LoanModel> loan) {
		this.customerName = customerName;
		this.cpf = cpf;
		this.rg = rg;
		this.income = income;
		this.email = email;
		this.password = password;
		this.addresses = addresses;
		this.loan = loan;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public BigDecimal getIncome() {
		return income;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<AddressModel> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressModel> addresses) {
		this.addresses = addresses;
	}

	public List<LoanModel> getLoan() {
		return loan;
	}

	public void setLoan(List<LoanModel> loan) {
		this.loan = loan;
	}

	public CustomerModel(Long customerId, String customerName,
						 String cpf, String rg, BigDecimal income, String email,
						 String password, List<AddressModel> addresses, List<LoanModel> loan) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.cpf = cpf;
		this.rg = rg;
		this.income = income;
		this.email = email;
		this.password = password;
		this.addresses = addresses;
		this.loan = loan;
	}
}