package com.musephoria.entity;
// default package
// Generated Nov 1, 2015 2:58:38 PM by Hibernate Tools 4.0.0.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Customer generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "customer", catalog = "musephoria")
public class Customer implements java.io.Serializable {

	private Integer customerId;
	private String userName;
	private String password;
	private String customerName;
	private Date dateOfBirth;
	private String sex;
	private String address;
	private String city;
	private String province;
	private String country;
	private String zipCode;
	private String email;
	private String phone;
	private String defaultPaymentInfo;
	private Boolean isCustomerActive;
	private Set<Purchaseorder> purchaseorders = new HashSet<Purchaseorder>(0);

	public Customer() {
	}

	public Customer(String userName, String password, String customerName, Date dateOfBirth, String sex, String address,
			String city, String province, String country, String zipCode, String email, String phone,
			String defaultPaymentInfo, Boolean isCustomerActive, Set<Purchaseorder> purchaseorders) {
		this.userName = userName;
		this.password = password;
		this.customerName = customerName;
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
		this.address = address;
		this.city = city;
		this.province = province;
		this.country = country;
		this.zipCode = zipCode;
		this.email = email;
		this.phone = phone;
		this.defaultPaymentInfo = defaultPaymentInfo;
		this.isCustomerActive = isCustomerActive;
		this.purchaseorders = purchaseorders;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "CustomerId", unique = true, nullable = false)
	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Column(name = "UserName", length = 45)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "Password", length = 25)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "CustomerName", length = 45)
	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DateOfBirth", length = 10)
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "Sex", length = 6)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "Address", length = 45)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "City", length = 45)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "Province", length = 45)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "Country", length = 45)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "ZipCode", length = 7)
	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Column(name = "Email", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Phone", length = 45)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "DefaultPaymentInfo", length = 7)
	public String getDefaultPaymentInfo() {
		return this.defaultPaymentInfo;
	}

	public void setDefaultPaymentInfo(String defaultPaymentInfo) {
		this.defaultPaymentInfo = defaultPaymentInfo;
	}

	@Column(name = "IsCustomerActive")
	public Boolean getIsCustomerActive() {
		return this.isCustomerActive;
	}

	public void setIsCustomerActive(Boolean isCustomerActive) {
		this.isCustomerActive = isCustomerActive;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<Purchaseorder> getPurchaseorders() {
		return this.purchaseorders;
	}

	public void setPurchaseorders(Set<Purchaseorder> purchaseorders) {
		this.purchaseorders = purchaseorders;
	}

}