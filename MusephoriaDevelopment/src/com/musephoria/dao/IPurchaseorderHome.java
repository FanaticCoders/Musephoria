/**
 * 
 */
package com.musephoria.dao;

import com.musephoria.entity.Paymentinfo;
import com.musephoria.entity.Purchaseorder;
import com.musephoria.entity.Shipping;

/**
 * @author Admin
 *
 */
public interface IPurchaseorderHome {

	/**
	 * Creates an order by saving Purchase order, Purchase Order Items &
	 * Shipping Information.
	 *
	 * @param shoppingCartInfo
	 * @param purchaseOrder
	 * @param shippingInfo
	 * @return
	 */
	int createOrder(int[] shoppingCartInfo, Purchaseorder purchaseOrder, Shipping shippingInfo);

	/**
	 * Confirms the order based on payment info status
	 *
	 * @param purchaseOrder
	 * @param shippingInfo
	 * @param paymentInfo
	 * @return
	 */
	boolean confirmOrder(Purchaseorder purchaseOrder, Shipping shippingInfo, Paymentinfo paymentInfo);

}