/**
 *
 */
package com.musephoria.webservice;

import java.util.List;

import com.musephoria.entity.Customer;
import com.musephoria.entity.Paymentinfo;
import com.musephoria.entity.Purchaseorder;
import com.musephoria.entity.Result;
import com.musephoria.entity.Shipping;

/**
 * @author FanaticCoders
 *
 */
public interface IOrderProcessService {
	/**
	 * Interface method to create an order.
	 * @param shoppingCartInfo
	 * @param purchaseOrder
	 * @param shippingInfo
	 * @return
	 */
	public int createOrder(List<Integer> shoppingCartInfo, Purchaseorder purchaseOrder, Shipping shippingInfo);

	/**
	 * Interface method to create an account.
	 * @param accountName
	 * @param accountInfo
	 * @return
	 */
	public String createAccount(String accountName, Customer accountInfo);

	/**
	 *
	 * Interface method to get an account.
	 * @param accountName
	 * @param accountPassword
	 * @param accountInfo
	 * @return
	 */
	public Result getAccount(String accountName, String accountPassword, Customer accountInfo);

	/**
	 * Interface method to confirm an order.
	 * @param orderInfo
	 * @param shippingInfo
	 * @param paymentInfo
	 * @return
	 */
	public boolean confirmOrder(Purchaseorder orderInfo, Shipping shippingInfo, Paymentinfo paymentInfo);
}
