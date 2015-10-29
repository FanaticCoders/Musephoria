/**
 *
 */
package com.musephoria.webservice;

import com.musephoria.entity.Customer;
import com.musephoria.entity.Paymentinfo;
import com.musephoria.entity.Purchaseorder;
import com.musephoria.entity.Result;
import com.musephoria.entity.Shipping;
import com.musephoria.shoppingcart.ShoppingCart;

/**
 * @author FanaticCoders
 *
 */
public interface IOrderProcessService {
	public Result createOrder(ShoppingCart shoppingCartInfo, Shipping shippingInfo);

	public String createAccount(String accountName, Customer accountInfo);

	public Result getAccount(String accountName, String accountPassword, Customer accountInfo);

	public Result confirmOrder(Purchaseorder orderInfo, Shipping shippingInfo, Paymentinfo paymentInfo);
}
