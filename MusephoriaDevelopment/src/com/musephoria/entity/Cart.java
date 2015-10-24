package com.musephoria.entity;
// Generated Oct 19, 2015 11:46:19 PM by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Cart generated by hbm2java
 */
@Entity
@Table(name = "cart", catalog = "musephoria")
@SuppressWarnings("serial")
public class Cart implements java.io.Serializable {

	private Integer cartId;
	private Customer customer;
	private float baseAmount;
	private float tax;
	private float totalAmount;
	private boolean isCartActive;
	private Set<Cartitem> cartitems = new HashSet<Cartitem>(0);

	public Cart() {
	}

	public Cart(Customer customer, float baseAmount, float tax, float totalAmount, boolean isCartActive) {
		this.customer = customer;
		this.baseAmount = baseAmount;
		this.tax = tax;
		this.totalAmount = totalAmount;
		this.isCartActive = isCartActive;
	}

	public Cart(Customer customer, float baseAmount, float tax, float totalAmount, boolean isCartActive,
			Set<Cartitem> cartitems) {
		this.customer = customer;
		this.baseAmount = baseAmount;
		this.tax = tax;
		this.totalAmount = totalAmount;
		this.isCartActive = isCartActive;
		this.cartitems = cartitems;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "CartId", unique = true, nullable = false)
	public Integer getCartId() {
		return this.cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CustomerId", nullable = false)
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Column(name = "BaseAmount", nullable = false, precision = 12, scale = 0)
	public float getBaseAmount() {
		return this.baseAmount;
	}

	public void setBaseAmount(float baseAmount) {
		this.baseAmount = baseAmount;
	}

	@Column(name = "Tax", nullable = false, precision = 12, scale = 0)
	public float getTax() {
		return this.tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	@Column(name = "TotalAmount", nullable = false, precision = 12, scale = 0)
	public float getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Column(name = "IsCartActive", nullable = false)
	public boolean isIsCartActive() {
		return this.isCartActive;
	}

	public void setIsCartActive(boolean isCartActive) {
		this.isCartActive = isCartActive;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cart")
	public Set<Cartitem> getCartitems() {
		return this.cartitems;
	}

	public void setCartitems(Set<Cartitem> cartitems) {
		this.cartitems = cartitems;
	}

}