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
import com.musephoria.webserviceclient.OrderProcessServiceStub.Customerdetail;

/**
 * @author FanaticCoders
 *
 */
public class OrderProcessServiceClient {

	public String createAccount(String accountName, Customer loginInfo, Customerdetail addressInfo) {
		String statusMessage = StringUtils.EMPTY;
		try {
			OrderProcessServiceStub client = new OrderProcessServiceStub();
			CreateAccount paramter = new CreateAccount();
			paramter.setAccountName(accountName);
			paramter.setLoginInfo(loginInfo);
			paramter.setAddressInfo(addressInfo);

			try {
				//Calling WebService.
				CreateAccountResponse res = client.createAccount(paramter);
				if (!res.equals(null)) {
					statusMessage = res.get_return().getStatusMessage();
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
