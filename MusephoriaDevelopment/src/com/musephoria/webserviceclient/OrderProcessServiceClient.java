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
import com.musephoria.webserviceclient.OrderProcessServiceStub.Customer;
import com.musephoria.webserviceclient.OrderProcessServiceStub.GetAccount;
import com.musephoria.webserviceclient.OrderProcessServiceStub.GetAccountResponse;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Result;

/**
 * @author FanaticCoders
 *
 */
public class OrderProcessServiceClient {
	private static final Log log = LogFactory.getLog(OrderProcessServiceClient.class);

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
			OrderProcessServiceStub client = new OrderProcessServiceStub();

			// Creating parameter object.
			CreateAccount parameter = new CreateAccount();

			// Populating the parameter object with parameters.
			parameter.setAccountName(accountName);
			parameter.setAccountInfo(accountInfo);

			CreateAccountResponse response = client.createAccount(parameter);

			if (!response.equals(null)) {
				statusMessage = response.get_return();
			}

		} catch (RemoteException e) {
			log.error(e.getLocalizedMessage(), e);
		}
		return statusMessage;
	}

	/**
	 *
	 * Gets account if the Username and Password is match. Else returns
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
			OrderProcessServiceStub client = new OrderProcessServiceStub();

			// Creating parameter object.
			GetAccount parameter = new GetAccount();

			// Populating the parameter object with parameters.
			parameter.setAccountName(accountName);
			parameter.setAccountPassword(accountPassword);
			parameter.setAccountInfo(accountInfo);

			GetAccountResponse response = client.getAccount(parameter);

			if (!response.equals(null)) {
				resObj = response.get_return();
			}
		} catch (RemoteException e) {
			log.error(e.getLocalizedMessage(), e);
		}

		return resObj;
	}

}
