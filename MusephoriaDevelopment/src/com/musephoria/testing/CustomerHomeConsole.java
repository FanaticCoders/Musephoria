/**
 *
 */
package com.musephoria.testing;

import java.sql.Timestamp;
import java.util.Date;

import com.musephoria.dao.CustomerHome;
import com.musephoria.dao.ICustomerHome;
import com.musephoria.entity.Customer;
import com.musephoria.entity.Result;
import com.musephoria.helper.Helper;
import com.musephoria.util.Types;

/**
 * @author FanaticCoders
 *
 */
public class CustomerHomeConsole {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {

			ICustomerHome customerHome = new CustomerHome();
			Customer accountInfo = new Customer();
			accountInfo.setUserName("u1sername");
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
			Result res = customerHome.createAccount(accountInfo.getUserName(), accountInfo);
			String status = res.getStatusMessage();

			System.out.println(status);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getLocalizedMessage());
		}

	}

}
