/**
 *
 */
package com.musephoria.webserviceclient;

import java.rmi.RemoteException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.musephoria.webserviceclient.OrderProcessServiceStub.CreateAccount;
import com.musephoria.webserviceclient.OrderProcessServiceStub.CreateAccountResponse;
import com.musephoria.webserviceclient.OrderProcessServiceStub.CreateOrder;
import com.musephoria.webserviceclient.OrderProcessServiceStub.CreateOrderResponse;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Customer;
import com.musephoria.webserviceclient.OrderProcessServiceStub.GetAccount;
import com.musephoria.webserviceclient.OrderProcessServiceStub.GetAccountResponse;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Result;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Shipping;
import com.musephoria.webserviceclient.OrderProcessServiceStub.ShoppingCart;

/**
 * @author FanaticCoders
 *
 */
public class OrderProcessServiceClient {
	private static final Log log = LogFactory.getLog(OrderProcessServiceClient.class);

	/**
	 *
	 * Creates an order based on shopping cart info & shipping info.
	 *
	 * @param shoppingCartInfo
	 * @param shippingInfo
	 * @return
	 */
	public Result createOrder(ShoppingCart shoppingCartInfo, Shipping shippingInfo) {
		Result resObj = null;
		try {
			// Creating an object of stub.
			OrderProcessServiceStub client = new OrderProcessServiceStub();

			// Setting the parameters in the create order parameter object.
			CreateOrder parameter = new CreateOrder();
			parameter.setShoppingCartInfo(shoppingCartInfo);
			parameter.setShippingInfo(shippingInfo);

			// Calling the webservice & capturing the response.
			CreateOrderResponse response = client.createOrder(parameter);

			if (!response.equals(null)) {
				// Populating the response in user defined result object.
				resObj = response.get_return();
			}
		} catch (RemoteException e) {
			log.error(e.getLocalizedMessage(), e);
		}

		return resObj;
	}

	/**
	 * Creates an account if the account doesnt exists.
	 *
	 * @param accountName
	 * @param accountInfo
	 * @return success/error message.
	 */
	public String createAccount(String accountName, Customer accountInfo) {
		String statusMessage = StringUtils.EMPTY;
		try {
			// Creating an object of stub.
			OrderProcessServiceStub client = new OrderProcessServiceStub();

			// Setting the parameters in the create account parameter object.
			CreateAccount parameter = new CreateAccount();
			parameter.setAccountName(accountName);
			parameter.setAccountInfo(accountInfo);

			// Calling the webservice & capturing the response.
			CreateAccountResponse response = client.createAccount(parameter);

			if (!response.equals(null)) {
				// Extracting the status message from the response object.
				statusMessage = response.get_return();
			}

		} catch (RemoteException e) {
			log.error(e.getLocalizedMessage(), e);
		}
		return statusMessage;
	}

	/**
	 *
	 * Gets account if the Username and Password is matched. Else returns
	 * appropriate error message.
	 *
	 * @param accountName
	 * @param accountPassword
	 * @param accountInfo
	 * @return
	 */
	public Result getAccount(String accountName, String accountPassword, Customer accountInfo) {
		Result resObj = null;
		try {
			// Creating an object of stub.
			OrderProcessServiceStub client = new OrderProcessServiceStub();

			// Setting the parameters in the get account parameter object.
			GetAccount parameter = new GetAccount();
			parameter.setAccountName(accountName);
			parameter.setAccountPassword(accountPassword);
			parameter.setAccountInfo(accountInfo);

			// Calling the webservice & capturing the response.
			GetAccountResponse response = client.getAccount(parameter);

			if (!response.equals(null)) {
				// Populating the response in user defined result object.
				resObj = response.get_return();
			}
		} catch (RemoteException e) {
			log.error(e.getLocalizedMessage(), e);
		}

		return resObj;
	}

}
