/**
 *
 */
package com.musephoria.webserviceclient;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.apache.commons.lang3.StringUtils;

import com.musephoria.webserviceclient.OrderProcessServiceStub.CreateAccount;
import com.musephoria.webserviceclient.OrderProcessServiceStub.CreateAccountResponse;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Customer;

/**
 * @author FanaticCoders
 *
 */
public class OrderProcessServiceClient {

	public String createAccount(String accountName, Customer accountInfo) {
		String statusMessage = StringUtils.EMPTY;
		try {
			OrderProcessServiceStub client = new OrderProcessServiceStub();
			CreateAccount paramter = new CreateAccount();
			paramter.setAccountName(accountName);
			paramter.setAccountInfo(accountInfo);

			try {
				CreateAccountResponse result = client.createAccount(paramter);
				if (!result.equals(null)) {
					statusMessage = result.get_return();
				}

			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statusMessage;
	}

}
