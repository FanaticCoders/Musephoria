/**
 *
 */
package com.musephoria.webservice;

import com.musephoria.entity.Cartitem;
import com.musephoria.entity.Customer;
import com.musephoria.entity.Customerdetail;
import com.musephoria.entity.Order;
import com.musephoria.entity.Paymentinfo;
import com.musephoria.entity.Result;
import com.musephoria.entity.Shipping;

/**
 * @author FanaticCoders
 *
 */
public interface IOrderProcessService {
	public Result createOrder(Cartitem shoppingCartInfo, Shipping shippingInfo);

	public Result createAccount(String accountName, Customer loginInfo, Customerdetail addressInfo);

	public Customer getAccount(String accountName, String accountPassword, Customer accountInfo);

	public Result confirmOrder(Order orderInfo, Shipping shippingInfo, Paymentinfo paymentInfo);
}
