package com.credit.analysis.model;

import javax.persistence.*;

@Entity(name = "AddressEntity")
@Table(name = "address")
public class AddressModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private Long addressId;

	@Column(length = 40, nullable = false)
	private String street;

	@Column(length = 8, nullable = false)
	private String zipCode;

	@Column(length = 40, nullable = false)
	private String city;

	@Column(length = 45, nullable = false)
	private String state;
	//many - AddressModel, one-CustomerModel
	@ManyToOne
	@JoinColumn(name = "address_customer_id")
	private CustomerModel customer;

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
}
