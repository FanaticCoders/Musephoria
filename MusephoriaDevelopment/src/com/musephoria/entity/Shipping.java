package com.musephoria.entity;
// default package
// Generated Oct 25, 2015 6:52:40 PM by Hibernate Tools 4.0.0.Final

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Shipping generated by hbm2java
 */
@Entity
@Table(name = "shipping", catalog = "musephoria")
@SuppressWarnings("serial")
public class Shipping implements java.io.Serializable {

	private Integer shippingId;
	private Order order;
	private String address;
	private String status;
	private Boolean isShippingActive;

	public Shipping() {
	}

	public Shipping(Order order, String address, String status) {
		this.order = order;
		this.address = address;
		this.status = status;
	}

	public Shipping(Order order, String address, String status, Boolean isShippingActive) {
		this.order = order;
		this.address = address;
		this.status = status;
		this.isShippingActive = isShippingActive;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ShippingId", unique = true, nullable = false)
	public Integer getShippingId() {
		return this.shippingId;
	}

	public void setShippingId(Integer shippingId) {
		this.shippingId = shippingId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OrderId", nullable = false)
	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Column(name = "Address", nullable = false, length = 45)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "Status", nullable = false, length = 9)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "IsShippingActive")
	public Boolean getIsShippingActive() {
		return this.isShippingActive;
	}

	public void setIsShippingActive(Boolean isShippingActive) {
		this.isShippingActive = isShippingActive;
	}

}
