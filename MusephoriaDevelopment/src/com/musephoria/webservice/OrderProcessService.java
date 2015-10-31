/**
 *
 */
package com.musephoria.webservice;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.musephoria.dao.CustomerHome;
import com.musephoria.dao.PurchaseorderHome;
import com.musephoria.entity.Customer;
import com.musephoria.entity.Paymentinfo;
import com.musephoria.entity.Purchaseorder;
import com.musephoria.entity.Result;
import com.musephoria.entity.Shipping;

/**
 * @author FanaticCoders
 *
 */
public class OrderProcessService implements IOrderProcessService {

	/**
	 * Creates an order based on shopping cart info & shipping info.
	 */
	@Override
	public int createOrder(List<Integer> shoppingCartInfo, Purchaseorder purchaseOrder, Shipping shippingInfo) {
		PurchaseorderHome poDao = new PurchaseorderHome();
		int result = poDao.createOrder(shoppingCartInfo, purchaseOrder, shippingInfo);
		return result;
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
		Result resObj = customerDao.getAccount(accountName, accountPassword, accountInfo);
		return resObj;
	}

	/**
	 * Confirms the order based on payment info.
	 */
	@Override
	public boolean confirmOrder(Purchaseorder purchaseOrder, Shipping shippingInfo, Paymentinfo paymentInfo) {
		PurchaseorderHome poDao = new PurchaseorderHome();
		boolean result = poDao.confirmOrder(purchaseOrder, shippingInfo, paymentInfo);
		return result;
	}

}
