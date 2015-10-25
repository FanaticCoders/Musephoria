package com.musephoria.entity;
// default package
// Generated Oct 25, 2015 6:52:40 PM by Hibernate Tools 4.0.0.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * Paymentinfo generated by hbm2java
 */
@Entity
@Table(name = "paymentinfo", catalog = "musephoria")
@SuppressWarnings("serial")
public class Paymentinfo implements java.io.Serializable {

	private Integer paymentInfoId;
	private Date timeStamp;
	private Customer customer;
	private int cardNumber;
	private String paymentInfoStatus;

	public Paymentinfo() {
	}

	public Paymentinfo(Customer customer, int cardNumber, String paymentInfoStatus) {
		this.customer = customer;
		this.cardNumber = cardNumber;
		this.paymentInfoStatus = paymentInfoStatus;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "PaymentInfoId", unique = true, nullable = false)
	public Integer getPaymentInfoId() {
		return this.paymentInfoId;
	}

	public void setPaymentInfoId(Integer paymentInfoId) {
		this.paymentInfoId = paymentInfoId;
	}

	@Version
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TimeStamp", nullable = false, length = 19)
	public Date getTimeStamp() {
		return this.timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CustomerId", nullable = false)
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Column(name = "CardNumber", nullable = false)
	public int getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Column(name = "PaymentInfoStatus", nullable = false, length = 9)
	public String getPaymentInfoStatus() {
		return this.paymentInfoStatus;
	}

	public void setPaymentInfoStatus(String paymentInfoStatus) {
		this.paymentInfoStatus = paymentInfoStatus;
	}

}
