/**
 *
 */
package com.musephoria.webservice;

import org.apache.commons.lang3.StringUtils;

import com.musephoria.dao.CustomerHome;
import com.musephoria.dao.PurchaseorderHome;
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
public class OrderProcessService implements IOrderProcessService {

	/**
	 * Creates an order based on shopping cart info & shipping info.
	 */
	@Override
	public Result createOrder(ShoppingCart shoppingCartInfo, Shipping shippingInfo) {
		PurchaseorderHome poDao = new PurchaseorderHome();
		Result resObj = poDao.createOrder(shoppingCartInfo, shippingInfo);
		return resObj;

	}

	/**
	 * Creates an account if the account doesn't exists.
	 */
	@Override
	public String createAccount(String accountName, Customer accountInfo) {
		CustomerHome customerDao = new CustomerHome();
		String status = StringUtils.EMPTY;

		Result resultObj = customerDao.createAccount(accountName, accountInfo);
		if (!resultObj.equals(null)) {

			status = resultObj.getStatusMessage();
		}
		return status;

	}

	/**
	 * Gets the account if the credentials match.
	 */

	@Override
	public Result getAccount(String accountName, String accountPassword, Customer accountInfo) {
		CustomerHome customerDao = new CustomerHome();
		return customerDao.getAccount(accountName, accountPassword, accountInfo);
	}

	@Override
	public Result confirmOrder(Purchaseorder orderInfo, Shipping shippingInfo, Paymentinfo paymentInfo) {
		// TODO Auto-generated method stub
		return null;
	}

}
