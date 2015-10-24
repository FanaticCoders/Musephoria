/**
 *
 */
package com.musephoria.webservice;

import java.util.Iterator;

import com.musephoria.dao.CustomerHome;
import com.musephoria.entity.Cartitem;
import com.musephoria.entity.Customer;
import com.musephoria.entity.Customerdetail;
import com.musephoria.entity.Order;
import com.musephoria.entity.Payment;
import com.musephoria.entity.Result;
import com.musephoria.entity.Shipping;
import com.musephoria.util.Constants;

/**
 * @author FanaticCoders
 *
 */
public class OrderProcessService implements IOrderProcessService {

	@Override
	public Result createOrder(Cartitem shoppingCartInfo, Shipping shippingInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result createAccount(String accountName, Customer loginInfo, Customerdetail addressInfo) {
		CustomerHome customerDao = new CustomerHome();
		Result resultObj = new Result();
		boolean flag = customerDao.checkIfAccountExists(accountName);

		if (flag) {
			resultObj.setStatusCode(Constants.errorUserNameExists);
			resultObj.setStatusMessage(Constants.userNameExists);
		} else {
			resultObj = customerDao.createAccount(loginInfo);
		}

		return resultObj;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Customer getAccount(String accountName, String accountPassword, Customer accountInfo) {
		CustomerHome customerDao = new CustomerHome();
		Customer customer = new Customer();
		Result resObj = customerDao.getAccount(accountInfo);

		if (!resObj.equals(null)) {
			if (!resObj.getResultList().isEmpty()) {
				Iterator<Customer> temp = (Iterator<Customer>) resObj.getResultList().iterator();
				if (temp.hasNext()) {
					customer = temp.next();
				}
			}
		}
		return customer;
	}

	@Override
	public Result confirmOrder(Order orderInfo, Shipping shippingInfo, Payment paymentInfo) {
		// TODO Auto-generated method stub
		return null;
	}

}
