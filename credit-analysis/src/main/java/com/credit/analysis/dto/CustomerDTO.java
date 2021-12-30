package com.credit.analysis.dto;

import com.credit.analysis.model.CustomerModel;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class CustomerDTO {
	@NotBlank(message = "Nome Completo é obrigatorio.")
	private String customerName;

	@CPF
	private String cpf;

	@Length(max = 11)
	private String rg;

	@Digits(integer = 5, fraction = 2)
	private BigDecimal income;

	@Email
	private String email;

	@NotBlank(message = "A senha é obrigatoria.")
	private String password;

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

	public CustomerModel toNewCustoner() {
		CustomerModel customerModel = new CustomerModel(this.customerName, this.cpf, this.rg,
				this.income, this.email, this.password);

		return customerModel;
	}
}