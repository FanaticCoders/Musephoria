/**
 *
 */
package com.musephoria.testing;

import java.sql.Timestamp;
import java.util.Date;

import com.musephoria.helper.Helper;
import com.musephoria.util.Types;
import com.musephoria.webserviceclient.OrderProcessServiceClient;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Customer;
import com.musephoria.webserviceclient.OrderProcessServiceStub.Result;

/**
 * @author FanaticCoders
 *
 */
public class CustomerHomeConsole {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		try {

			// Do Not Delete this. For Testing

			OrderProcessServiceClient client = new OrderProcessServiceClient();

			Customer accountInfo = new Customer();
			accountInfo.setUserName("user12");
			accountInfo.setPassword("pa1ssword");
			accountInfo.setCustomerName("firstname");
			accountInfo.setDateOfBirth(Helper.FormatDate("1989/01/25"));
			accountInfo.setSex(Types.Sex.Male.toString());
			accountInfo.setAddress("address");
			accountInfo.setCity("city");
			accountInfo.setProvince("prov");
			accountInfo.setCountry("country");
			accountInfo.setZipCode("zip");
			accountInfo.setEmail("email");
			accountInfo.setPhone("phone");
			accountInfo.setDefaultPaymentInfo(Types.PaymentInfo.Credit.toString());
			Date today = new Date();
			accountInfo.setTimeStamp(new Timestamp(today.getTime()));
			accountInfo.setIsCustomerActive(true);


	/*		String res = client.createAccount(accountInfo.getUserName(), accountInfo);
			System.out.println(res);*/

			Result res1 = client.getAccount("monis256", "1234", accountInfo);
			System.out.println(res1.getStatusMessage());



			// Do Not Delete this. For Testing
			/*
			 * List<Integer> primaryIdList = new ArrayList<Integer>();
			 * primaryIdList.add(3015); DBManager db = new DBManager();
			 * db.DeleteData(Customer.class, primaryIdList);
			 * db.cleanUpSession();
			 */

			/*
			 * CartitemHome temp = new CartitemHome();
			 * temp.deleteFromCartItem(6001);
			 */

			/*
			 * CartitemHome dao = new CartitemHome();
			 *
			 * List<Cartitem> primaryIdList = new ArrayList<Cartitem>();
			 * primaryIdList.add(temp); dao.updateCartItems(primaryIdList);
			 */

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getLocalizedMessage());
		}

	}

}
