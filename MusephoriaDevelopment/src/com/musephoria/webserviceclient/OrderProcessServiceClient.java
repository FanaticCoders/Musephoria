/**
 *
 */
package com.musephoria.webserviceclient;

import java.rmi.RemoteException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.musephoria.webserviceclient.OrderProcessServiceStub.ConfirmOrder;
import com.musephoria.webserviceclient.OrderProcessServiceStub.ConfirmOrderResponse;
import com.musephoria.webserviceclient.OrderProcessServiceStub.CreateAccount;
import com.musephoria.webserviceclient.OrderProcessServiceStub.CreateAccountResponse;
import com.musephoria.webserviceclient.OrderProcessServiceStub.CreateOrder;
import com.musephoria.webserviceclient.OrderProcessServiceStub.CreateOrderResponse;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Customer;
import com.musephoria.webserviceclient.OrderProcessServiceStub.GetAccount;
import com.musephoria.webserviceclient.OrderProcessServiceStub.GetAccountResponse;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Paymentinfo;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Purchaseorder;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Result;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Shipping;

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
	public int createOrder(List<Integer> shoppingCartInfo, Purchaseorder purchaseOrder, Shipping shippingInfo) {
		int purchaseOrderId = 0;
		try {
			// Creating an object of stub.
			OrderProcessServiceStub stub = new OrderProcessServiceStub();

			// Reference :
			// http://stackoverflow.com/questions/960431/how-to-convert-listinteger-to-int-in-java
			int[] cdIdArray = shoppingCartInfo.stream().mapToInt(i -> i).toArray();

			// Setting the parameters in the create order parameter object.
			CreateOrder parameter = new CreateOrder();
			parameter.setShoppingCartInfo(cdIdArray);
			parameter.setPurchaseOrder(purchaseOrder);
			parameter.setShippingInfo(shippingInfo);

			// Calling the WebService to capture the response.
			CreateOrderResponse response = stub.createOrder(parameter);

			if (!response.equals(null)) {
				// Populating the response in user defined result object.
				purchaseOrderId = response.get_return();
			}
		} catch (RemoteException e) {
			log.error(e.getLocalizedMessage(), e);
		}

		return purchaseOrderId;
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
			OrderProcessServiceStub stub = new OrderProcessServiceStub();

			// Setting the parameters in the create account parameter object.
			CreateAccount parameter = new CreateAccount();
			parameter.setAccountName(accountName);
			parameter.setAccountInfo(accountInfo);

			// Calling the WebService to capture the response.
			CreateAccountResponse response = stub.createAccount(parameter);

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
			OrderProcessServiceStub stub = new OrderProcessServiceStub();

			// Setting the parameters in the get account parameter object.
			GetAccount parameter = new GetAccount();
			parameter.setAccountName(accountName);
			parameter.setAccountPassword(accountPassword);
			parameter.setAccountInfo(accountInfo);

			// Calling the WebService to capture the response.
			GetAccountResponse response = stub.getAccount(parameter);

			if (!response.equals(null)) {
				// Populating the response in user defined result object.
				resObj = response.get_return();
			}
		} catch (RemoteException e) {
			log.error(e.getLocalizedMessage(), e);
		}

		return resObj;
	}

	public boolean confirmOrder(Purchaseorder purchaseOrder, Shipping shippingInfo, Paymentinfo paymentInfo) {
		boolean flag = false;
		// Creating an object of stub.
		try {
			OrderProcessServiceStub stub = new OrderProcessServiceStub();

			// Setting the parameters in the confirm order parameter object.

			ConfirmOrder parameter = new ConfirmOrder();
			parameter.setPurchaseOrder(purchaseOrder);
			parameter.setShippingInfo(shippingInfo);
			parameter.setPaymentInfo(paymentInfo);

			// Calling the WebService to capture the response.
			ConfirmOrderResponse response = stub.confirmOrder(parameter);

			if (!response.equals(null)) {
				// Populating the response in user defined result object.
				flag = response.get_return();
			}

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
