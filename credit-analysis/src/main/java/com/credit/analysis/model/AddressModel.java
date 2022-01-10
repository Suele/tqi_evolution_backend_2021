package com.credit.analysis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "AddressEntity")
@Table(name = "address")
public class AddressModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private Long addressId;

	@NotBlank(message = "O nome da rua é obrigatório.")
	@Column(length = 40)
	private String street;

	@NotNull(message = "O número da rua é obrigatório.")
	@Column(name = "street_number")
	private Integer streetNumber;

	@NotBlank(message = "O CEP é obrigatório.")
	@Length(max = 8, message = "O CEP têm 8 caracteres.")
	@Column(length = 8)
	private String zipCode;

	@NotBlank(message = "A cidade é obrigatória.")
	@Length(min = 5, max = 40, message = "A cidade deve ser entre 5 e 40 caracteres.")
	@Column(length = 40)
	private String city;

	@NotBlank(message = "O estado é obrigatorio.")
	@Length(min = 5, max = 40, message = "O estado deve ser entre 5 e 40 caracteres.")
	@Column(length = 45)
	private String state;
	//many - AddressModel, one-CustomerModel
	@ManyToOne
	@JoinColumn(name = "address_customer_id")
	@JsonIgnore
	private CustomerModel customer;

	@Enumerated(EnumType.STRING)
	@Column(name = "address_type", nullable = false, length = 15)
	private AddressType addressType;

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(Integer streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public CustomerModel getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerModel customer) {
		this.customer = customer;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	@Override
	public String toString() {
		return "AddressModel{" +
				"addressId=" + addressId +
				", street='" + street + '\'' +
				", streetNumber=" + streetNumber +
				", zipCode='" + zipCode + '\'' +
				", city='" + city + '\'' +
				", state='" + state + '\'' +
				", customer=" + customer +
				", addressType=" + addressType +
				'}';
	}
}