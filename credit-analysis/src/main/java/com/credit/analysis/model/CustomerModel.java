package com.credit.analysis.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "customerEntity")
@Table(name = "customer")
public class CustomerModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Long customerId;

	@Column(name = "customer_name", nullable = false, length = 100)
	private String customerName;

	@Column(nullable = false, length = 11, unique = true)
	private String cpf;

	@Column(nullable = false, length = 11, unique = true)
	private String rg;

	@Column(nullable = false, precision = 0)
	private BigDecimal income;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false, unique = true)
	private String password;

	@OneToMany
	@JoinColumn(name = "address_customer_id")
	private List<AddressModel> addresses;

	public CustomerModel() {
	}

	public CustomerModel(String customerName, String cpf, String rg, BigDecimal income, String email, String password) {
		this.customerName = customerName;
		this.cpf = cpf;
		this.rg = rg;
		this.income = income;
		this.email = email;
		this.password = password;
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
}